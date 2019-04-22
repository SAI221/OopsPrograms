package com.bridgelabz.factoryInventory.main;

import com.bridgelabz.factoryInventory.data.InventoryFactoryManagement;
import com.bridgelabz.factoryInventory.dataImpl.InventoryFactoryImp;

public class InventoryFactoryApp {

	public static void main(String[] args) {
		InventoryFactoryManagement imp=new InventoryFactoryImp();
		imp.fileRead(); 
		imp.calculate();

	}

}