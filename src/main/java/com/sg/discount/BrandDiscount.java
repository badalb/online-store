package com.sg.discount;

import java.util.Map;

import com.sg.domain.Product;

public class BrandDiscount implements Discount {

	/**
	 * Returns brand discount
	 */
	@Override
	public Double getDiscount(Product product) {

		Double discount = Double.valueOf(0.0);
		if (product.getBrand().getDiscount() != null && discount < product.getBrand().getDiscount()) {
			discount = product.getBrand().getDiscount();
		}
		return discount;
	}

	@Override
	public void applyDiscount(Product product, Map<String, Double> discounts) {

		product.getBrand().setDiscount(discounts.get(product.getBrand().getName()));
	}

	@Override
	public void removeDiscount(Product product, Map<String, Double> discounts) {

	}
}
