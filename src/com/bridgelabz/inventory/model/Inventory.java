package com.bridgelabz.inventory.model;
public class Inventory {
	private String name;
	private long weight;
	private long price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "name: " + name + "\n "
				+ "weight: " + weight + "\n "
						+ "price: " + price + "";
	}

}