package com.HealthCare.PatientCRUD.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HealthCare.PatientCRUD.model.Patient;

@Controller
public class PatientController {

    private List<Patient> patientList = new ArrayList<>();

    @GetMapping({"/", "/patient", "/patient/homepage", "/homepage", "/home"})
    public String patientHome(){
        return "home_page";
    }

    @GetMapping("/patient/form")
    public String showForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient_form";
    }

    @PostMapping("/patient/add")
    public String addPatient(@ModelAttribute Patient patient, Model model) {
        model.addAttribute("patient", patient);
        patientList.add(patient);
        return "patient_information";
    }

    @GetMapping("/patient/list")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientList);
        return "patient_list";
    }

    @GetMapping("/patient/updateParam")
    public String showUpdateParamForm(
        @RequestParam("patient_id") String patient_id, 
        @RequestParam("full_name") String full_name, 
        @RequestParam("contact_number") String contact_number, 
        @RequestParam("email") String email, 
        @RequestParam("address") String address, 
        Model model) {

        Patient patient = new Patient(patient_id, full_name, contact_number, email, address);
        model.addAttribute("patient", patient);
        return "patient_form";
    }

    @PostMapping("/patient/updateHiddenForm")
    public String showUpdateHiddenForm(@ModelAttribute Patient patient, Model model) {
        model.addAttribute("patient", patient);
        return "patient_form";
    }
}
