package ru.vorobyoff.petclinicweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vorobyoff.petclinicdata.services.base.VetService;

@Controller
@RequestMapping("/vets")
@RequiredArgsConstructor
public final class VetController {

    private final VetService vetService;

    @RequestMapping({"", "/index", "/index.html"})
    public String index(final Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}