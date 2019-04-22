package com.bridgelabz.addressBook.dataImpl;

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

import com.bridgelabz.addressBook.data.AddressBookManagement;
import com.bridgelabz.addressBook.model.AddressBook;
import com.bridgelabz.oops.exception.CustomException;
import com.google.gson.Gson;

public class AddressBookImpl implements AddressBookManagement {
	JSONArray jsonArray;
	List<AddressBook> addressdetails = new ArrayList<>();

	JSONObject jobject = new JSONObject();

	@Override
	public void fileRead() {
		JSONParser parser = new JSONParser();
		{
			try {
				jsonArray = (JSONArray) parser.parse(new FileReader(
						"/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/addressBook/model/addressBook.json"));

				for (Object obj : jsonArray) {
					AddressBook addressdetail = new AddressBook();

					jobject = (JSONObject) obj;
					String firstname = (String) jobject.get("firstName");
					String lastname = (String) jobject.get("lastName");
					String city = (String) jobject.get("city");
					String address = (String) jobject.get("address");
					String state = (String) jobject.get("state");
					Long phonenumber = (Long) jobject.get("phonenumber");
					Long zipcode = ((Long) jobject.get("zipCode"));

					addressdetail.setFirstName(firstname);
					addressdetail.setLastName(lastname);
					addressdetail.setCity(city);
					addressdetail.setAddress(address);
					addressdetail.setState(state);
					addressdetail.setPhonenumber(phonenumber);
					addressdetail.setZipcode(zipcode);

					addressdetails.add(addressdetail);
				}
				System.out.println(addressdetails.toString());
			}

			catch (Exception e) {
				throw new CustomException("Exception occured while reading your file", e);
			}

		}
	}

	@Override
	public void addPerson(String firstname, String lastname, String address, String city, String state,
			Long phonenumber, Long zipcode) {
		AddressBook addressdetail = new AddressBook();
		addressdetail.setFirstName(firstname);
		addressdetail.setLastName(lastname);
		addressdetail.setCity(city);
		addressdetail.setAddress(address);
		addressdetail.setState(state);
		addressdetail.setPhonenumber(phonenumber);
		addressdetail.setZipcode(zipcode);

		addressdetails.add(addressdetail);
		addressdetails.forEach(persondetails -> System.out.println(persondetails.toString()));
		writeFile();
	}

	@Override
	public void writeFile() {
		Gson gson = new Gson();
		String json = gson.toJson(addressdetails);
		System.out.println(json);
		System.out.println(addressdetails);

		try (FileWriter file = new FileWriter(
				"/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/addressBook/model/addressBook.json")) {
			file.write(json);
			System.out.println("SuccessFully copied to JSON  Object to File......");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removePerson(String name) {
		// fileRead();

		addressdetails.removeIf(inventory -> inventory.getFirstName().equals(name));

		System.out.println("SuccessFully Removed the Elements From The List");
		writeFile();
	}

	public void sortByLastName() {
		addressdetails.sort((AddressBook s1, AddressBook s2) -> s1.getLastName().compareTo(s2.getLastName()));
		addressdetails.forEach((s) -> System.out.println(s));
		writeFile();
	}

	public void sortByZipCode() {
		addressdetails.sort((AddressBook s1, AddressBook s2) -> s1.getZipcode().compareTo(s2.getZipcode()));
		addressdetails.forEach((s) -> System.out.println(s));
		writeFile();
	}

}
