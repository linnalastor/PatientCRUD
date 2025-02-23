package com.HealthCare.PatientCRUD.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HealthCare.PatientCRUD.model.Patient;

@Controller
public class PatientController {

    Map<String, Patient> patientList = new HashMap<>();

    public PatientController() {
        Patient new_patient = new Patient("linnalastor1", "Nyan Linn Soe", "09799246279", "linnalastor@gmail.com", "Thailand, Bangkok");
        patientList.put(new_patient.getPatient_id(), new_patient);
        new_patient = new Patient("linnalastor2", "Nyan Linn Soe", "09799246279", "linnalastor@gmail.com", "Thailand, Bangkok");
        patientList.put(new_patient.getPatient_id(), new_patient);
        new_patient = new Patient("linnalastor3", "Nyan Linn Soe", "09799246279", "linnalastor@gmail.com", "Thailand, Bangkok");
        patientList.put(new_patient.getPatient_id(), new_patient);
        new_patient = new Patient("linnalastor4", "Nyan Linn Soe", "09799246279", "linnalastor@gmail.com", "Thailand, Bangkok");
        patientList.put(new_patient.getPatient_id(), new_patient);
    }
    
    //home page
    @GetMapping({"/", "/patient", "/patient/homepage", "/homepage", "/home"})
    public String patientHome(){
        return "home_page";
    }

    //patient form for registering and updating
    @GetMapping("/patient/form")
    public String showForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient_form";
    }

    //add new patient to the list
    @PostMapping("/patient/add")
    public String addPatient(@ModelAttribute Patient new_patient, Model model) {
        model.addAttribute("patient", new_patient);
        if (patientList.containsKey(new_patient.getPatient_id())) {
            // Patient already exists, return form page
            System.out.println("Patient already exists");
            return "patient_form"; 
        }
        patientList.put(new_patient.getPatient_id(), new_patient);
        return "patient_information";
    }

    //show off the patient list
    @GetMapping("/patient/list")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientList);
        return "patient_list";
    }

    //pass patient information to patient form using parameter
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
        model.addAttribute("update_patient", true);
        return "patient_form";
    }

    //pass patient information to patient form using hidden form
    @PostMapping("/patient/updateHiddenForm")
    public String showUpdateHiddenForm(@ModelAttribute Patient patient, Model model) {
        model.addAttribute("patient", patient);
        model.addAttribute("update_patient", true);
        return "patient_form";
    }

    //pass patient information from patient list using parameter 
    @GetMapping("/patient/update_from_list")
    public String showUpdateForm_FromList(@RequestParam("patient_id") String patient_id, Model model) {
        Patient patient = patientList.get(patient_id);
        model.addAttribute("patient", patient);
        model.addAttribute("update_patient", true);
        return "patient_form";
    }

    @PostMapping("/patient/update")
    public String showUpdateForm_FromList(@ModelAttribute Patient patient, Model model) {
        model.addAttribute("patient", patient);
        if (patientList.containsKey(patient.getPatient_id())) {
            patientList.put(patient.getPatient_id(), patient);
            return "patient_information";
        }else{
            return "patient_form";
        }
    }

    @PostMapping("/patient/delete")
    public String deletePatient(@ModelAttribute Patient patient, Model model) {
        if (patientList.containsKey(patient.getPatient_id())) {
            patientList.remove(patient.getPatient_id());
        }
        model.addAttribute("patients", patientList);
        return "patient_list";
    }
}
