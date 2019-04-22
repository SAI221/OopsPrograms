package com.bridgelabz.inventory.dataImpl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.inventory.data.InventoryManagement;
import com.bridgelabz.inventory.model.Inventory;
import com.bridgelabz.oops.exception.CustomException;
import com.google.gson.Gson;

public class InventoryManagementImp implements InventoryManagement {

	List<Inventory> inventories = new ArrayList<>();
	JSONParser parser = new JSONParser();
	JSONObject object = new JSONObject();

	public List<Inventory> fileRead() {

		JSONArray jsonArray;
		{

			try {
				jsonArray = (JSONArray) parser.parse(new FileReader(
						"/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/inventory/model/inventory.json"));

				for (Object obj : jsonArray) {
					Inventory inventory = new Inventory();
					JSONObject jobject = (JSONObject) obj;
					String name = (String) jobject.get("name");
					inventory.setName(name);
					long weight = (Long) jobject.get("weight");
					inventory.setWeight(weight);
					long price = (Long) jobject.get("price");
					inventory.setPrice(price);

					inventories.add(inventory);
					// System.out.println(inventory.toString());
				}
			} catch (Exception e) {

				throw new CustomException("Exception while reading your file", e);
			}
		}
		return inventories;
	}

	@Override
	public void addInventory(String name, long weight, long price) {
		fileRead();
		Inventory inventory = new Inventory();
		inventory.setName(name);
		inventory.setWeight(weight);
		inventory.setPrice(price);
		inventories.add(inventory);
		inventories.forEach(inventory1 -> System.out.println(inventory1.toString()));

		writeJson();

	}

	@Override
	public void calculateInventory() {
		inventories.forEach(inventory -> {
			System.out.println(
					"Total price of " + inventory.getName() + " is " + (inventory.getPrice() * inventory.getWeight()));
		});
	}

	@Override
	public void removeInventory(String name) {
		// fileRead();
		inventories.removeIf(inventory1 -> inventory1.getName().equals(name));
		writeJson();

	}

	public void writeJson() {
		Gson gson = new Gson();
		String json = gson.toJson(inventories);

		try (FileWriter file = new FileWriter(
				"/home/bridgelabz/eclipse-workspace/OopsPrograms/src/com/bridgelabz/inventory/model/inventory.json")) {
			file.write(json);
			System.out.println("written to json");
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("inventories :" + json);

	}

}