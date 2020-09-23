package com.example.demo.controllers;

import com.example.demo.models.CatFact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CatFactController {
    CatFact displayCatFact = new CatFact("");

    @GetMapping("/")
    public String index(Model catFactModel) {
        catFactModel.addAttribute("displayCatFact", displayCatFact);
        return "index";
    }

    @PostMapping("/postCatFact")
    public String postCatFact(WebRequest formData) {
        CatFact catFact = new CatFact(formData.getParameter("catfact"));
        displayCatFact = catFact;
        return "redirect:/";
    }
}
