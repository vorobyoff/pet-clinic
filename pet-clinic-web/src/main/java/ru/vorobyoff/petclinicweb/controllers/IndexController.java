package ru.vorobyoff.petclinicweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public final class IndexController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping("/oups")
    public String error() {
        return "not-implemented";
    }
}