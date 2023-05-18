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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private PersonService personService;

    @Autowired
    private LicenseService licenseService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute(
                "personList",
                personService.findByLicenseIsNotNull()
        );
        return "index.jsp";
    }

    @GetMapping("/persons/new")
    public String newPerson(@ModelAttribute("Person") Person person) {
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
        personService.create(person);
        return "redirect:/";
    }

    @GetMapping("/licenses/new")
    public String newLicense(
            Model model,
            @ModelAttribute("License") License license
    ) {
        model.addAttribute(
                "personList",
                personService.findByLicenseIsNull()
        );
        return "license.jsp";
    }

    @PostMapping("/licenses/new")
    public String createNewLicence(
            @Valid
            @ModelAttribute("License") License license,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute(
                    "personList",
                    personService.findByLicenseIsNull()
            );
            return "license.jsp";
        }
        licenseService.create(license);
        return "redirect:/";
    }

    @GetMapping("/persons/{id}")
    public String showDetail(Model model, @PathVariable("id") Long id) {
        model.addAttribute(
                "person",
                personService.findById(id)
        );
        return "showDetails.jsp";
    }
}
