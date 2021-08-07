package ru.vorobyoff.petclinicweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.services.base.OwnerService;

import java.util.List;

@Controller
@RequestMapping("/owners/")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(final OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("{ownerId}")
    public ModelAndView showOwnerDetailsByOwnerId(@PathVariable final Long ownerId) {
        final var mav = new ModelAndView("/owners/owner-details");
        final var owner = ownerService.findById(ownerId).orElseThrow();
        mav.addObject(owner);
        return mav;
    }

    @GetMapping("find")
    public String showFindOwnersPage(final Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/find-owners";
    }

    @GetMapping
    public String findOwnersByLastName(final Owner owner, final BindingResult result, final Model model) {
        if (owner.getLastName() == null) owner.setLastName("");

        final var foundOwners = ownerService.findAllByLastname(owner.getLastName());

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
        return "owners/find-owners";
    }

    private String getViewNameIfOnlyOneOwnerExists(final Owner owner) {
        return "redirect:/owners/" + owner.getId();
    }

    private String getViewNameIfMultipleOwnersExist(final List<Owner> owners, final Model model) {
        model.addAttribute("owners", owners);
        return "owners/owner-list";
    }
}