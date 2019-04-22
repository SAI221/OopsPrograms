package com.bridgelabz.addressBook.main;

import java.util.Scanner;

import com.bridgelabz.addressBook.data.AddressBookManagement;
import com.bridgelabz.addressBook.dataImpl.AddressBookImpl;

public class AddressBookApp {

	public static void main(String[] args) {
		AddressBookManagement addimpl = new AddressBookImpl();
		addimpl.fileRead();

		Scanner sc = new Scanner(System.in);

		System.out.println(" 1.addperson \n 2.remove person \n 3.sortbyname \n 4.sortzip");
		System.out.println("Input choice");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			System.out.println("enter firstname:");
			String firstName = sc.next();
			System.out.println("enter lastname:");
			String lastName = sc.next();
			System.out.println("enter addrress:");
			String address = sc.next();
			System.out.println("enter state:");
			String state = sc.next();
			System.out.println("enter city:");
			String city = sc.next();
			System.out.println("enter zipcode:");
			long zipCode = sc.nextLong();
			System.out.println("enter mobileNo:");
			long phoneNo = sc.nextLong();

			addimpl.addPerson(firstName, lastName, address, city, state, zipCode, phoneNo);
			break;
		case 2:
			System.out.println("enter name to delete:");
			String name=sc.next();
			addimpl.removePerson(name);
			break;
		case 3:
			addimpl.sortByLastName();
			break;
		case 4:
			addimpl.sortByZipCode();
			break;
		}

		sc.close();
	}

}
