package com.bridgelabz.CompanyShare.data;

public interface CompanyShareManagement {
	public void fileRead();

	public void add(String name, int share, int value);

	public void remove(String name);

	public void fileWrite();

	public void stockValue();
}
