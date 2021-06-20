package ru.vorobyoff.petclinicweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vorobyoff.petclinicdata.services.VetService;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(final VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String index(final Model model) {
        final var vets = vetService.findAll();
        model.addAttribute("vets", vets);
        return "vets/index";
    }
}