package com.bridgelabz.CompanyShare.main;

import java.util.Scanner;

import com.bridgelabz.CompanyShare.data.CompanyShareManagement;
import com.bridgelabz.CompanyShare.dataImpl.CompanyShareImpl;

public class CompanyShareApp {

	public static void main(String[] args) {
		CompanyShareManagement share = new CompanyShareImpl();
		share.fileRead();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name:");
		String name = sc.next();
		System.out.println("enter share:");
		int shares = sc.nextInt();
		System.out.println("enter value:");
		int value = sc.nextInt();

		share.add(name, shares, value);
		System.out.println("remove name:");
		String nameToRemove = sc.next();
		share.remove(nameToRemove);
		share.stockValue();
		sc.close();
	}

}
