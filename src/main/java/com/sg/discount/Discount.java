package com.sg.discount;

import java.util.Map;

import com.sg.domain.Product;

public interface Discount {

	/**
	 * Returns discount % for product at different level
	 * 
	 * @param product
	 * @return
	 */
	public Double getDiscount(Product product);

	public void applyDiscount(Product product, Map<String, Double> discounts);

	public void removeDiscount(Product product, Map<String, Double> discounts);
}
