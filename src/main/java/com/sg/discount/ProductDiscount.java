package com.sg.discount;

import java.util.Map;

import com.sg.domain.Product;

public class ProductDiscount implements Discount {

	/**
	 * Returns product level discount
	 */
	@Override
	public Double getDiscount(Product product) {
		Double discount = Double.valueOf(0.0);
		if (product.getDiscount() != null && discount < product.getDiscount()) {
			discount = product.getDiscount();
		}
		return discount;
	}

	@Override
	public void applyDiscount(Product product, Map<String, Double> discounts) {
		product.setDiscount(discounts.get(product.getName()));

	}

	@Override
	public void removeDiscount(Product product, Map<String, Double> discounts) {
		// TODO Auto-generated method stub
	}
}
