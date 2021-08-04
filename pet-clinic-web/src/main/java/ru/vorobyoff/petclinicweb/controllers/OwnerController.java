package ru.vorobyoff.petclinicweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.vorobyoff.petclinicdata.services.base.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(final OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String index(final Model model) {
        final var owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "owners/index";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwnerDetailsByOwnerId(@PathVariable final Long ownerId) {
        final var mav = new ModelAndView("/owners/owner-details");
        final var owner = ownerService.findById(ownerId).orElseThrow();
        mav.addObject(owner);
        return mav;
    }
}