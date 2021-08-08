package ru.vorobyoff.petclinicweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.models.Pet;
import ru.vorobyoff.petclinicdata.models.PetType;
import ru.vorobyoff.petclinicdata.services.base.OwnerService;
import ru.vorobyoff.petclinicdata.services.base.PetService;
import ru.vorobyoff.petclinicdata.services.base.PetTypeService;

import java.util.Collection;

import static org.springframework.util.StringUtils.hasLength;
import static ru.vorobyoff.petclinicweb.controllers.OwnerController.getRedirectUrlToOwnerDetails;

@Controller
@RequestMapping("owners/{ownerId}/")
@RequiredArgsConstructor
public final class PetController {

    private static final String PET_FORM_VIEW_NAME = "pets/pet-form";

    private final PetTypeService petTypeService;
    private final OwnerService ownerService;
    private final PetService petService;

    @ModelAttribute("owner")
    public Owner owner(@PathVariable("ownerId") final Long ownerId) {
        return ownerService.findById(ownerId);
    }

    @ModelAttribute("types")
    public Collection<PetType> petTypesDescriptions() {
        return petTypeService.findAll();
    }

    @InitBinder("owner")
    public void initOwnerBinder(final WebDataBinder binder) {
        binder.setDisallowedFields("id");
    }

    @GetMapping("pets/new")
    public String showCreatePetForm(final @ModelAttribute Owner owner, final ModelMap model) {
        final var pet = Pet.builder().build();
        owner.tamePet(pet);
        model.put("pet", pet);

        return PET_FORM_VIEW_NAME;
    }

    @PostMapping("pets/new")
    public String processCreateForm(final @ModelAttribute Owner owner, final @Validated Pet pet, final BindingResult result, final ModelMap model) {
        if (hasLength(pet.getName()) && pet.isNew() && owner.findPetByName(pet.getName()).isPresent())
            result.rejectValue("name", "duplicate", "already exists");

        owner.tamePet(pet);
        if (result.hasErrors()) {
            model.put("pet", pet);
            return PET_FORM_VIEW_NAME;
        }
        petService.save(pet);

        return getRedirectUrlToOwnerDetails(ownerService.save(owner).getId());
    }

    @GetMapping("pets/{petId}/edit")
    public String showUpdateForm(final @PathVariable Long petId, final ModelMap model) {
        model.put("pet", petService.findById(petId));
        return PET_FORM_VIEW_NAME;
    }

    @PostMapping("/pets/{petId}/edit")
    public String processUpdateForm(final @Validated Pet pet, final Owner owner, final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            pet.setOwner(owner);
            model.addAttribute("pet", pet);
            return PET_FORM_VIEW_NAME;
        } else {
            owner.tamePet(pet);
            petService.save(pet);
            return getRedirectUrlToOwnerDetails(ownerService.save(owner).getId());
        }
    }
}