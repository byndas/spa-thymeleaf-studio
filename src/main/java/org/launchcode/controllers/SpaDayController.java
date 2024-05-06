package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@Controller
public class SpaDayController {

    @GetMapping("/")
    public String HomePageForm() { return "index"; }

    public boolean checkSkinType(String skinType, String facialType) {
        switch(skinType) {
            case "oily":
                return facialType.equals("Microdermabrasion")
                    || facialType.equals("Rejuvenating");
            case "combination":
                return facialType.equals("Microdermabrasion")
                    || facialType.equals("Rejuvenating")
                    || facialType.equals("Enzyme Peel");
            case "dry":
                return facialType.equals("Rejuvenating")
                    || facialType.equals("Hydrofacial");
            default: return true;
        }
    }

    @PostMapping("/menu")
    public String spaMenu(
        @RequestParam String name,
        @RequestParam String skinType,
        @RequestParam String manipedi,
        Model model
    ) {
        ArrayList<String> facials = new ArrayList<>();
        facials.add("Microdermabrasion");
        facials.add("Hydrofacial");
        facials.add("Rejuvenating");
        facials.add("Enzyme Peel");

        ArrayList<String> appropriateFacials = new ArrayList<>();
        for (String facial : facials) {
            if (checkSkinType(skinType, facial)) {
                appropriateFacials.add(facial);
            }
        }

        model.addAttribute("appropriateFacials", appropriateFacials);

        model.addAttribute("name", name);
        model.addAttribute("skinType", skinType);
        model.addAttribute("manipedi", manipedi);

        return "menu";
    }
}