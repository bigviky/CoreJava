package com.routeone.interview;

public final class Order {
	private final String name;
	private final double price;	
	
	public Order(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}	
}
