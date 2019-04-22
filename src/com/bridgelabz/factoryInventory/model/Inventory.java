package com.bridgelabz.factoryInventory.model;

import java.util.List;

public class Inventory {
	private String name;
	private long weight;
	private long price;
	private List<Inventory> rice;
	private List<Inventory> pulses;

	private List<Inventory> wheat;

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
		return "name: " + name + "\n " + "weight: " + weight + "\n " + "price: " + price + "";
	}

	public List<Inventory> getRice() {
		return rice;
	}

	public void setRice(List<Inventory> rice) {
		this.rice = rice;
	}

	public List<Inventory> getPulses() {
		return pulses;
	}

	public void setPulses(List<Inventory> pulses) {
		this.pulses = pulses;
	}

	public List<Inventory> getWheat() {
		return wheat;
	}

	public void setWheat(List<Inventory> wheat) {
		this.wheat = wheat;
	}

	public long getTotalPrice() {
		return getPrice() * getWeight();
	}

}