package com.routeone.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StoreRegister {
	final List<Inventory> inventory = new ArrayList<>();
	public StoreRegister() throws FileNotFoundException {
		loadInventory(new File("sample-inventory.csv"));
	}
	public void loadInventory(File inventoryFile) throws FileNotFoundException {
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		try {
			br = new BufferedReader(new FileReader(inventoryFile));
			while ((line = br.readLine()) != null) {
				String[] values = line.split(splitBy);
				Inventory inv = new Inventory(values[0],Double.valueOf(values[1]), values[2]);
				inventory.add(inv);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Receipt checkoutOrder(List<String> items) {
		ReceiptImpl receipt = new ReceiptImpl();
		List<Order> orderItems = receipt.orderItems;

		for(String item: items) {
			int index = IntStream.range(0, inventory.size())
				    .filter(inventoryInd-> inventory.get(inventoryInd).getName().equals(item))
				    .findFirst().getAsInt();
			Inventory inv = inventory.get(index);
			orderItems.add(new Order(inv.getName(), inv.getPrice()));
		}
		return receipt;
	}
}