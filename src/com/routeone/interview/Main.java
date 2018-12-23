package com.routeone.interview;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		StoreRegister storeRegister = new StoreRegister();
		List<String> orderList = new ArrayList<>();
		orderList.add("PC1033");
		orderList.add("GenericMotherboard");
		orderList.add("GenericProcessor");
		orderList.add("GenericMotherboardV2");
		orderList.add("LCD");
		Receipt receipt = storeRegister.checkoutOrder(orderList);
		List<String> items = receipt.getOrderedItems();
		String total = receipt.getFormattedTotal();
		for(int i = 0; i < items.size(); i++){
			System.out.println(items.get(i));
		}
		System.out.println("Total: " + total);
	}

}
