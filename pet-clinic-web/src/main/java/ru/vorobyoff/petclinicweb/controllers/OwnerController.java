package ru.vorobyoff.petclinicweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.services.base.OwnerService;

import java.util.List;

@Controller
@RequestMapping("/owners/")
@RequiredArgsConstructor
public final class OwnerController {

    private static final String OWNER_DETAILS_VIEW_NAME = "/owners/owner-details";
    private static final String REDIRECT_TO_OWNER_DETAILS = "redirect:/owners/";
    private static final String FIND_OWNERS_VIEW_NAME = "owners/find-owners";
    private static final String OWNER_FORM_VIEW_NAME = "owners/owner-form";
    private static final String OWNER_LIST_VIEW_NAME = "owners/owner-list";

    static <I extends Number> String getRedirectUrlToOwnerDetails(final I identifier) {
        return REDIRECT_TO_OWNER_DETAILS + identifier;
    }

    private final OwnerService ownerService;

    @GetMapping("{ownerId}")
    public ModelAndView showOwnerDetailsByOwnerId(@PathVariable final Long ownerId) {
        return new ModelAndView(OWNER_DETAILS_VIEW_NAME)
                .addObject(ownerService.findById(ownerId));
    }

    @GetMapping("find")
    public String showFindOwnersPage(final Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return FIND_OWNERS_VIEW_NAME;
    }

    @GetMapping("new")
    public String showCreateOwnerForm(final Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return OWNER_FORM_VIEW_NAME;
    }

    @PostMapping("new")
    public String processCreateOwnerForm(@Validated final Owner owner, final BindingResult result) {
        if (result.hasErrors()) return OWNER_FORM_VIEW_NAME;
        final var saved = ownerService.save(owner);
        return getRedirectUrlToOwnerDetails(saved.getId());
    }

    @GetMapping("/{ownerId}/edit")
    public String showUpdateOwnerForm(final @PathVariable Long ownerId, final Model model) {
        final var owner = ownerService.findById(ownerId);
        model.addAttribute(owner);
        return OWNER_FORM_VIEW_NAME;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Validated final Owner owner, final @PathVariable Long ownerId, final BindingResult result) {
        if (result.hasErrors()) return OWNER_FORM_VIEW_NAME;
        owner.setId(ownerId);
        final var saved = ownerService.save(owner);
        return getRedirectUrlToOwnerDetails(saved.getId());
    }

    @GetMapping
    public String findOwnersByLastName(final Owner owner, final BindingResult result, final Model model) {
        if (owner.getLastName() == null) owner.setLastName("");

        final var foundOwners = ownerService.findAllByLastName(owner.getLastName());

        var viewName = "";
        if (foundOwners.isEmpty()) {
            viewName = getViewNameIfOwnersDontExist(result);
        } else if (foundOwners.size() == 1) {
            viewName = getViewNameIfOnlyOneOwnerExists(foundOwners.get(0));
        } else viewName = getViewNameIfMultipleOwnersExist(foundOwners, model);

        return viewName;
    }

    private String getViewNameIfOwnersDontExist(final BindingResult result) {
        result.rejectValue("lastName", "notfound", "not found");
        return FIND_OWNERS_VIEW_NAME;
    }

    private String getViewNameIfOnlyOneOwnerExists(final Owner owner) {
        return getRedirectUrlToOwnerDetails(owner.getId());
    }

    private String getViewNameIfMultipleOwnersExist(final List<Owner> owners, final Model model) {
        model.addAttribute("owners", owners);
        return OWNER_LIST_VIEW_NAME;
    }
}