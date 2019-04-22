package com.bridgelabz.inventory.main;

import java.util.Scanner;

import com.bridgelabz.inventory.data.InventoryManagement;
import com.bridgelabz.inventory.dataImpl.InventoryManagementImp;

public class InventoryApp {

	public static void main(String[] args) {

		InventoryManagement inventaryImp = new InventoryManagementImp();

		{
			Scanner sc = new Scanner(System.in);

			System.out.println("enter name ");
			String name = sc.next();
			System.out.println("enter weight ");
			long weight = sc.nextLong();
			System.out.println("enter price ");
			long price = sc.nextLong();
			inventaryImp.addInventory(name, weight, price);

			inventaryImp.calculateInventory();
			System.out.println("enter the name to remove");
			String remove = sc.next();
			inventaryImp.removeInventory(remove);
			sc.close();

		}

	}
}