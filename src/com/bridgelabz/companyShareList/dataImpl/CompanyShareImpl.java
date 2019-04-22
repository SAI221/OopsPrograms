package com.bridgelabz.companyShareList.dataImpl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.companyShareList.data.CompanyShareManagement;
import com.bridgelabz.companyShareList.model.CompanyShare;
import com.bridgelabz.oops.exception.CustomException;
import com.bridgelabz.util.CustomLinkedList;
import com.google.gson.Gson;

public class CompanyShareImpl implements CompanyShareManagement {
	JSONArray jsonArray;
	CompanyShare shares = new CompanyShare();
	Scanner sc = new Scanner(System.in);

	List<CompanyShare> list = new ArrayList<>();
	CustomLinkedList<CompanyShare> linkedList = new CustomLinkedList<>();
	JSONObject jobject = new JSONObject();

	@Override
	public void fileRead() {
		JSONParser parser = new JSONParser();
		FileReader fr;
		try {
			fr = new FileReader(
					"/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/companyShareList/model/companyShares.json");
			jobject = (JSONObject) parser.parse(fr);

			jsonArray = (JSONArray) jobject.get("shares");
		} catch (Exception e) {
			throw new CustomException("Exception occured while reading your file", e);

		}
		for (Object obj : jsonArray) {
			CompanyShare comShare = new CompanyShare();
			jobject = (JSONObject) obj;
			String name = (String) jobject.get("name");
			Long noOfShare = (Long) jobject.get("share");
			comShare.setName(name);
			comShare.setShare(noOfShare);
			linkedList.add(comShare);

		}
	}

	@Override
	public void add() {
		fileRead();
		System.out.println("linked  list before adding:");
		linkedList.printList();
		CompanyShare share = new CompanyShare();
		System.out.println("enter company name to add");
		String name = sc.next();
		System.out.println("enter the number of share");
		Long noOfShare = sc.nextLong();
		share.setName(name);
		share.setShare(noOfShare);
		linkedList.add(share);
		System.out.println("linked  list after adding:");
		linkedList.printList();
		System.out.println(linkedList.size());
		writeFile();
	}

	@Override
	public void remove(String name) {

		System.out.println("Linked List" + new Gson().toJson(linkedList));

		for (CompanyShare share : linkedList) {
			if (share != null && share.getName().equals(name)) {
				linkedList.remove(share);
			}

		}
		System.out.println("removed");
		System.out.println("linked  list after removing:");
		linkedList.printList();
		writeFile();
	}

	@Override
	public void writeFile() {
		Gson gson = new Gson();
		System.out.println("list to be written into file");
		linkedList.printList();
		String g = gson.toJson(linkedList);
		System.out.println("writing into file");
		System.out.println("content" + g);

		try (FileWriter file = new FileWriter(
				"/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/companyShareList/model/companyShares.json")) {
			file.write(g);
			file.flush();
			System.out.println("written into file");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}