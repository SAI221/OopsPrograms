package com.bridgelabz.clinicManagement.data;

import com.bridgelabz.clinicManagement.model.Doctor;

public interface DoctorManager {
	public void fileRead();

	public void addDoctor(String name, int id, String availability, String specialization);

	public boolean searchDoctor(String name);

	public String AvailablityDoctor(String name);

	public void writefile();

	public Doctor getDoctor(String name);
}