package com.routeone.interview;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReceiptImpl implements Receipt {
	double total = 0;
	List<Order> orderItems = new ArrayList<>();
	
	@Override
	public String getFormattedTotal() {
		for(Order order: orderItems){
			this.total = this.total + order.getPrice();
		}
		if(this.total == 0) {
			return "$0.00";
		}
		DecimalFormat df = new DecimalFormat("0.00");
		final String x = df.format(this.total);
		String y = x.substring(x.length() - 2, x.length());
		StringBuffer value = new StringBuffer();		
		char[] charArr = x.toCharArray();
		int temp = 0;
		for(int i = charArr.length - 4; i >= 0; i--) {
			temp++;
			value.append(charArr[i]);
			if(temp % 3 == 0 && i > 0) {
				 value.append(',');
			}
		}
		return value.append("$").reverse().append(".").append(y).toString();
	}

	@Override
	public List<String> getOrderedItems() {
		List<String> items = new ArrayList<>();
		// order of most expensive item to least. If items have an identical price, sort in alphabetical (A-Z) order.
		Collections.sort(this.orderItems, new Comparator<Order>() {

	        public int compare(Order o1, Order o2) {

	            Double x1 = o1.getPrice();
	            Double x2 = o2.getPrice();
	            int sComp = x2.compareTo(x1);

	            if (sComp != 0) {
	               return sComp;
	            } 

	            String x3 = o1.getName();
	            String x4 = o2.getName();
	            return x3.compareTo(x4);
	    }});
		for(Order order: orderItems){
			items.add(order.getName());
		}
		return items;
	}

}
