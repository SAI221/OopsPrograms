package com.bridgelabz.factoryInventory.dataImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.factoryInventory.data.InventoryFactoryManagement;
import com.bridgelabz.factoryInventory.model.Inventory;
import com.bridgelabz.oops.exception.CustomException;

public class InventoryFactoryImp implements InventoryFactoryManagement {
	Inventory invt = new Inventory();

	List<Inventory> rice = new ArrayList<>();
	List<Inventory> wheat = new ArrayList<>();
	List<Inventory> pulses = new ArrayList<>();

	JSONArray jsonarray = new JSONArray();
	JSONParser parser = new JSONParser();

	@Override
	public void fileRead() {
		try {

			Object obj = parser.parse(new FileReader(
					"/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/factoryInventory/model/factoryInventory.json"));
			JSONObject job = (JSONObject) obj;

			jsonarray = (JSONArray) job.get("rice");
			System.out.println(obj);
			for (Object obj1 : jsonarray) {
				Inventory inventory = new Inventory();
				JSONObject jobject = (JSONObject) obj1;
				String name = (String) jobject.get("name");
				long price = (Long) jobject.get("price");
				long weight = ((Long) jobject.get("weight"));
				inventory.setWeight(weight);

				inventory.setName(name);

				inventory.setPrice(price);

				rice.add(inventory);
				System.out.println(inventory.toString());
			}

			invt.setRice(rice);

			jsonarray = (JSONArray) job.get("wheat");
			System.out.println(obj);
			for (Object obj1 : jsonarray) {
				Inventory inventory = new Inventory();
				JSONObject jobject = (JSONObject) obj1;
				String name = (String) jobject.get("name");
				long price = (Long) jobject.get("price");
				long weight = ((Long) jobject.get("weight"));
				inventory.setWeight(weight);

				inventory.setName(name);

				inventory.setPrice(price);

				wheat.add(inventory);
				System.out.println(inventory.toString());
			}
			invt.setWheat(wheat);

			jsonarray = (JSONArray) job.get("pulses");
			System.out.println(obj);
			for (Object obj1 : jsonarray) {
				Inventory inventory = new Inventory();
				JSONObject jobject = (JSONObject) obj1;
				String name = (String) jobject.get("name");
				long price = (Long) jobject.get("price");
				long weight = (Long) jobject.get("weight");
				inventory.setWeight(weight);

				inventory.setName(name);

				inventory.setPrice(price);

				pulses.add(inventory);
				System.out.println(inventory.toString());
			}
			invt.setPulses(pulses);

		} catch (Exception e) {

		throw new CustomException("Exception in reading File",e);
	}
	}

	@Override
	public void calculate() {
		invt.getRice().forEach(inventory -> {
			System.out.println("Total price of " + inventory.getName() + " is " + inventory.getTotalPrice());
		});
		invt.getWheat().forEach(inventory -> {
			System.out.println("Total price of " + inventory.getName() + " is " + inventory.getTotalPrice());
		});
		invt.getPulses().forEach(inventory -> {
			System.out.println("Total price of " + inventory.getName() + " is " + inventory.getTotalPrice());
		});

	}
}