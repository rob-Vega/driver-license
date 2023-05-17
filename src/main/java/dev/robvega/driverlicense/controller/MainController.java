package dev.robvega.driverlicense.controller;

import dev.robvega.driverlicense.model.License;
import dev.robvega.driverlicense.model.Person;
import dev.robvega.driverlicense.service.LicenseService;
import dev.robvega.driverlicense.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private PersonService personService;

    @Autowired
    private LicenseService licenseService;

    @GetMapping("/")
    public String index() {
        System.out.println("Hola");
        return "license.jsp";
    }

    @GetMapping("/persons/new")
    public String newPerson(@ModelAttribute("Person") Person person) {
        personService
                .findAll()
                .stream()
                .forEach(p -> System.out.println(p.toString()));
        return "person.jsp";
    }

    @PostMapping("/persons/new")
    public String createNewPerson(
            @Valid
            @ModelAttribute("Person") Person person,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            System.out.println("has errors");
            return "person.jsp";
        }
        personService.createPerson(person);
        return "redirect:/persons/new";
    }

    @GetMapping("/licenses/new")
    public String newLicense(
            Model model,
            @ModelAttribute("License") License license
    ) {
        System.out.println(personService.findAll());
        model.addAttribute(
                "personList",
                personService.findAll()
        );
        return "license.jsp";
    }

    @PostMapping("/licenses/new")
    public String createNewLicence(
            @Valid
            @ModelAttribute("License") License license,
            BindingResult result
    ) {
        System.out.println(result.getAllErrors());
        if (result.hasErrors()) {
            return "license.jsp";
        }
        return "redirect:/licenses/new";
    }

}
