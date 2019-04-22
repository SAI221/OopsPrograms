package com.bridgelabz.companyShareList.main;

import java.util.Scanner;

import com.bridgelabz.companyShareList.data.CompanyShareManagement;
import com.bridgelabz.companyShareList.dataImpl.CompanyShareImpl;

public class ListOfCompanySharesApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		CompanyShareManagement ref = new CompanyShareImpl();

		
		ref.add();
		System.out.println("enter the name you want to delet");
		String name = sc.next();
		ref.remove(name);
		
		sc.close();
	}
}