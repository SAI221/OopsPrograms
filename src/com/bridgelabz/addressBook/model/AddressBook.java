package com.bridgelabz.addressBook.model;

public class AddressBook {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private Long phonenumber;
	private Long zipCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Long getZipcode() {
		return zipCode;
	}

	public void setZipcode(Long zipcode) {
		this.zipCode = zipcode;
	}

	@Override
	public String toString() {
		return "firstname: " + firstName + "\n " + "lastname: " + lastName + "\n " + "address: " + address + "\n "
				+ "city: " + city + "\n " + "state: " + state + "\n " + "phonenumber: " + phonenumber + "\n "
				+ "zipcode: " + zipCode + "";
	}

}
