package com.bridgelabz.clinicManagement.dataImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.clinicManagement.data.PatientInterface;
import com.bridgelabz.clinicManagement.model.Patient;
import com.bridgelabz.oops.exception.CustomException;

public class PatientImplementation implements PatientInterface {
	JSONArray jsonarray1;
	List<Patient> patients = new ArrayList<>();
	JSONObject jobj1 = new JSONObject();

	@Override
	public void fileRead() {
		JSONParser jp = new JSONParser();
		{
			try {
				File file1 = new File("D:\\pat.json");
				System.out.println("file exists : " + file1.exists() + " \n" + "File path" + file1.getAbsolutePath());

				FileReader fr = new FileReader(file1);

				jobj1 = (JSONObject) jp.parse(fr);

				jsonarray1 = (JSONArray) jobj1.get("Patients");

				for (Object obj : jsonarray1) {

					Patient p = new Patient();

					jobj1 = (JSONObject) obj;

					String name = (String) jobj1.get("name");
					int id = ((Long) jobj1.get("id")).intValue();
					int mn = ((Long) jobj1.get("mobileNumber")).intValue();
					int age = (((Long) jobj1.get("age")).intValue());

					p.setId(id);
					p.setName(name);
					p.setMobilenumber(mn);
					p.setAge(age);

					patients.add(p);

					System.out.println(p.toString());
				}
			} catch (Exception e) {

				throw new CustomException("Exception occured while reading your file", e);

			}
		}

	}

	@Override
	public void addPatients(String name, int id, int mobilenumber, int age) {
		Patient pt = new Patient();
		pt.setName(name);
		pt.setId(id);
		pt.setMobilenumber(mobilenumber);
		pt.setAge(age);
		patients.forEach(patient1 -> System.out.println(patient1.toString()));
	}

	@Override
	public void appointmentPatients(String name, int id, int mobilenumber, int age) {

	}

	@Override
	public void searchPatients(String name, int id, int mobilenumber, int age) {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchPatients(String name) {
		// TODO Auto-generated method stub

	}
}