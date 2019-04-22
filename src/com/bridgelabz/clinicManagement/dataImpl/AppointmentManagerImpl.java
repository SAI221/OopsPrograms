package com.bridgelabz.clinicManagement.dataImpl;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bridgelabz.clinicManagement.data.AppointmentManager;
import com.bridgelabz.clinicManagement.data.DoctorManager;
import com.bridgelabz.clinicManagement.model.Appointment;
import com.bridgelabz.clinicManagement.model.Doctor;
import com.bridgelabz.oops.exception.CustomException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AppointmentManagerImpl implements AppointmentManager {
	private List<Appointment> appointments;
	private Gson gson;
	private DoctorManager doctorManager;
	private Scanner scan;
	private Map<String, List<Appointment>> appointmentLookup;

	public AppointmentManagerImpl() {
		this.appointments = readFile();
		System.out.println(appointments);
		this.gson = new Gson();
		this.doctorManager = new DoctorManagerImpl();
		this.scan = new Scanner(System.in);
		this.appointmentLookup = appointments.stream().collect(Collectors.groupingBy(Appointment::getKey));
	}

	private List<Appointment> readFile() {
		try {
			File file = new File("D:\\apt.json");
			FileReader fileReader = new FileReader(file);
			// Converting json to List of appointments
			List<Appointment> appointments = gson.fromJson(fileReader, new TypeToken<List<Appointment>>() {
			}.getType());
			return appointments;
		} catch (Exception e) {
			throw new CustomException("Error fetching appointments from json", e);
		}
	}

	@Override
	public void takeAppointment() {
		System.out.println("Inside takeApp");
		System.out.println("Enter Doctor name to take appointment ");
		String doctor = scan.next();
		System.out.println("Enter AppointmentDate ");
		String date = scan.next();

		if (canTakeAppointment(doctor, date)) {
			System.out.println("Enter Patient Name");
			String patient = scan.next();
			Appointment appointment = new Appointment(date, doctor, patient);
			appointments.add(appointment);
			System.out.println(appointments);
		}
	}

	private boolean canTakeAppointment(String doctor, String date) {
		String key = doctor + ":" + date;
		List<Appointment> appointmentsForDoctor = appointmentLookup.get(key);
		if (appointmentsForDoctor == null) {
			return true;
		}

		if (appointmentsForDoctor.size() < 5) {
			return true;
		}
		return false;
	}

	@Override
	public Doctor searchDoctorByName(String doctorName) {
		return doctorManager.getDoctor(doctorName);
	}

	@Override
	public Doctor searchDoctorBySpec(String spec) {
		return null;
	}

}