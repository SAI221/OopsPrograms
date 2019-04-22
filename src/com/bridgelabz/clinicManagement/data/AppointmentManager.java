package com.bridgelabz.clinicManagement.data;

import com.bridgelabz.clinicManagement.model.Doctor;

public interface AppointmentManager {
	public void takeAppointment();

	public Doctor searchDoctorByName(String doctorName);

	public Doctor searchDoctorBySpec(String spec);

}