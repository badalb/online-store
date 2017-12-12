package com.sg.inventory;

import com.sg.domain.Price;

public class PriceBuilder {

	public static Price buildProductPrice(String[] attributes) {
		Price price = new Price();
		price.setPrice(Double.valueOf(attributes[3].trim()));
		price.setCurrency("INR");
		return price;
	}
}
