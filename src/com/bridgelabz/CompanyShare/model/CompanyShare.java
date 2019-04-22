package com.bridgelabz.CompanyShare.model;

public class CompanyShare {
	private String name;
	private int share;
	private int value;
	private String date;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}
	@Override
	public String toString() {
	    return "name: " + name + "\n "
	            + "share: " + share + "\n "
	            + "value: " + value + "\n "
	            + "date: " + date +  "";
	}

}
