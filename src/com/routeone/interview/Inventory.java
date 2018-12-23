package com.routeone.interview;

public final class Inventory {
	private final String name;
	private final double price;
	private final String category;
	
	
	public Inventory(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}
}
