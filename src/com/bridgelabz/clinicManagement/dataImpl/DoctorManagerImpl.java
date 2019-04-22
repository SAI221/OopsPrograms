package com.bridgelabz.clinicManagement.dataImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.clinicManagement.data.DoctorManager;
import com.bridgelabz.clinicManagement.model.Doctor;
import com.bridgelabz.oops.exception.CustomException;
import com.google.gson.Gson;

public class DoctorManagerImpl implements DoctorManager {
	JSONArray jsonArray;
	List<Doctor> doctors = new ArrayList<>();

	JSONObject jobject = new JSONObject();

	public void fileRead() {
		JSONParser parser = new JSONParser();
		{
			try {
				File file = new File("D:\\doc.json");

				FileReader fileReader = new FileReader(file);

				jobject = (JSONObject) parser.parse(fileReader);

				jsonArray = (JSONArray) jobject.get("Doctor");

				for (Object obj : jsonArray) {

					Doctor doctor = new Doctor();

					jobject = (JSONObject) obj;
					String name = (String) jobject.get("name");
					int id = ((Long) jobject.get("id")).intValue();
					String spe = (String) jobject.get("specilization");
					String ava = (String) jobject.get("availability");

					doctor.setId(id);
					doctor.setName(name);
					doctor.setAvailability(ava);
					doctor.setSpecialization(spe);

					doctors.add(doctor);

					doctor.toString();
				}
			}

			catch (Exception e) {
				throw new CustomException("Exception occured while reading your file", e);

			}

		}

	}

	@Override
	public void addDoctor(String name, int id, String availability, String specialization) {
		Doctor doct = new Doctor();

		doct.setName(name);
		doct.setAvailability(availability);
		doct.setId(id);
		doct.setSpecialization(specialization);

		doctors.add(doct);

		doctors.forEach(doctor1 -> doctor1.toString());

		System.out.println(doctors);
		writefile();
	}

	@Override
	public boolean searchDoctor(String name) {
		for (Doctor doctor : doctors) {
			if (name.equals(doctor.getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String AvailablityDoctor(String name) {
		String time = "";

		for (Doctor availability : doctors) {
			if (searchDoctor(name) == true) {
				time = availability.getAvailability();
			}
		}
		return time;
	}

	@Override
	public void writefile() {
		Gson gson = new Gson();
		String json = gson.toJson(doctors);

		try (FileWriter file = new FileWriter("D:\\doc.json")) {
			file.write("{\"Doctor\": " + json + "}");
			System.out.println("SuccessFully copied to JSON  Object to File......");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Doctor getDoctor(String name) {
		for (Doctor doctor : doctors) {
			if (name.equals(doctor.getName())) {
				return doctor;
			}
		}
		return null;
	}

}