package com.bridgelabz.CompanyShare.dataImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.CompanyShare.data.CompanyShareManagement;
import com.bridgelabz.CompanyShare.model.CompanyShare;
import com.google.gson.Gson;

public class CompanyShareImpl implements CompanyShareManagement {
	JSONArray jsonArray;
	JSONObject jobject = new JSONObject();
	List<CompanyShare> list=new ArrayList<>();

	@Override
	public void fileRead() {
		JSONParser parser = new JSONParser();
		{
			try {
				jsonArray = (JSONArray) parser.parse(new FileReader(
						"/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/CompanyShare/model/companyShares.json"));

				for (Object obj : jsonArray) {
					CompanyShare shares=new CompanyShare();

					jobject = (JSONObject) obj;
					String name= (String) jobject.get("name");
					int share=((Long) jobject.get("share")).intValue();
					int value=((Long) jobject.get("value")).intValue();
					String date=(String) jobject.get("date");
					shares.setDate(date);
					shares.setName(name);
					shares.setShare(share);
					shares.setValue(value);
					/*
					 * System.out.println(shares.getName()); System.out.println(shares.getShare());
					 * System.out.println(shares.getValue()); Syst
					 em.out.println(shares.getDate());*/
					list.add(shares);
				}
				System.out.println(list.toString());
			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
					
	}

	@Override
	public void add(String name, int share,int value) {
		CompanyShare shares=new CompanyShare();
		  String now = LocalDateTime.now().toString();  
		shares.setDate(now);
		shares.setName(name);
		shares.setShare(share);
		shares.setValue(value);
		list.add(shares);
		System.out.println("After adding--->"+list.toString());
		fileWrite();
	}

	@Override
	public void remove(String name) {
list.removeIf(share -> share.getName().equals(name));
System.out.println("removed");
fileWrite();
	}

	@Override
	public void fileWrite() {
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		try (FileWriter file = new FileWriter("/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/CompanyShare/model/companyShares.json")){
				file.write(json);
				System.out.println("SuccessFully copied to JSON  Object to File......");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void stockValue() {
		list.forEach(shares -> System.out.println(shares.getName()+"'s StockValue is "+shares.getShare()*shares.getValue()));
		
	}

}
