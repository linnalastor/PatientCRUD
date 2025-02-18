package com.HealthCare.PatientCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.HealthCare.PatientCRUD.model.Patient;

@Controller
public class PatientController {

    @GetMapping("/patient/form")
    public String showForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient_form";
    }

    @PostMapping("/patient/submit")
    public String submitForm(@ModelAttribute Patient patient, Model model) {
        model.addAttribute("patient", patient);
        return "patient_information";
    }
}
