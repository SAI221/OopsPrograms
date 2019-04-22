package com.bridgelabz.clinicManagement.data;

public interface PatientInterface {
	public void fileRead();

	public void addPatients(String name, int id, int mobilenumber, int age);

	public void searchPatients(String name, int id, int mobilenumber, int age);

	public void appointmentPatients(String name, int id, int mobilenumber, int age);

	void searchPatients(String name);
}