package com.HealthCare.PatientCRUD.model;

public class Patient {
	private String patient_id, full_name, contact_number, email, address;

	public String getPatient_id() {
		return patient_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setPatient_id(String patienat_id) {
		this.patient_id = patienat_id;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_number() {
		return contact_number;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}
}