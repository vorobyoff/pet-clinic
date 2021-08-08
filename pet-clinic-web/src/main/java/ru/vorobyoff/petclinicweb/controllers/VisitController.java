package ru.vorobyoff.petclinicweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.vorobyoff.petclinicdata.models.Visit;
import ru.vorobyoff.petclinicdata.services.base.PetService;
import ru.vorobyoff.petclinicdata.services.base.VisitService;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public final class VisitController {

    private static final String VISIT_FORM_VIEW_NAME = "pets/visit-form";

    private final VisitService visitService;
    private final PetService petService;

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.setDisallowedFields("id");

        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(final String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text));
            }
        });
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Map<String, Object> model) {
        final var pet = petService.findById(petId);
        model.put("pet", pet);
        final var visit = Visit.builder().build();
        pet.addVisit(visit);
        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId, Map<String, Object> model) {
        return VISIT_FORM_VIEW_NAME;
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Validated Visit visit, BindingResult result) {
        if (result.hasErrors()) return VISIT_FORM_VIEW_NAME;

        visitService.save(visit);
        return "redirect:/owners/{ownerId}";

    }
}