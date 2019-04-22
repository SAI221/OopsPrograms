package com.bridgelabz.inventory.data;

import java.util.List;

import com.bridgelabz.inventory.model.Inventory;

public interface InventoryManagement {

	public void addInventory(String name, long weight, long price);

	public void removeInventory(String name);

	public void calculateInventory();

	public List<Inventory> fileRead();

	public void writeJson();
}