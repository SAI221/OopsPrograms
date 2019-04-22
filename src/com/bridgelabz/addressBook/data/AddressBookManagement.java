package com.bridgelabz.addressBook.data;

public interface AddressBookManagement {
	public void addPerson(String firstname, String lastname, String address, String city, String state,
			Long phonenumber, Long zipcode);

	public void removePerson(String name);

	public void sortByLastName();

	public void sortByZipCode();

	public void fileRead();

	public void writeFile();
}
