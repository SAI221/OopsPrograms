package com.bridgelabz.companyShareStack.dataImpl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.companyShareStack.data.CompanyShareStackMngmt;
import com.bridgelabz.companyShareStack.model.CompanyShareStack;
import com.bridgelabz.oops.exception.CustomException;
import com.bridgelabz.util.CustomLinkedList;
import com.bridgelabz.util.MyStack;
import com.google.gson.Gson;

public class CompanyShareStackImpl implements CompanyShareStackMngmt {
	JSONArray jsonArray;
	CompanyShareStack shares = new CompanyShareStack();
	MyStack<CompanyShareStack> stack = new MyStack<CompanyShareStack>();
	CustomLinkedList<CompanyShareStack> list = new CustomLinkedList<CompanyShareStack>();
	Scanner sc = new Scanner(System.in);
	JSONObject jobject = new JSONObject();

	public void fileRead() throws Exception {
		JSONParser parser = new JSONParser();

		try {
			jsonArray = (JSONArray) parser.parse(new FileReader(
					"/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/companyShareStack/modal/companyShareStack.json"));

			for (Object obj : jsonArray) {
				CompanyShareStack comShare = new CompanyShareStack();
				jobject = (JSONObject) obj;
				String name = (String) jobject.get("name");
				long share = (Long) jobject.get("share");
				long value = (Long) jobject.get("value");
				comShare.setName(name);
				comShare.setShare(share);
				comShare.setValue(value);
				stack.push(comShare);
				System.out.println(stack.toString());

			}
		} catch (Exception e) {
			throw new CustomException("Exception occured while reading your file", e);
		}
	}

	@Override
	public void purshare(String name, int share, int value) {
		CompanyShareStack stock = new CompanyShareStack();
		stock.setName(name);
		stock.setShare(share);
		stock.setValue(value);
		list.add(stock);
		try {
			stack.push(stock);
		} catch (Exception e) {

			e.printStackTrace();
		}
		fileWrite();

	}

	@Override
	public void sell(String name) {

		for (CompanyShareStack share : list) {
			if (share != null && share.getName().equals(name)) {
				list.remove(share);
			}

		}
		fileWrite();
	}

	private void fileWrite() {
		Gson gson = new Gson();
		System.out.println("list to be written into file");
		list.printList();
		String g = gson.toJson(list);
		System.out.println("writing into file");
		System.out.println("content" + g);

		try (FileWriter file = new FileWriter(
				"/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/companyShareList/modal/companyShares.json")) {
			file.write(g);
			file.flush();
			System.out.println("written into file");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
