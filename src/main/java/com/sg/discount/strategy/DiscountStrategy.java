package com.sg.discount.strategy;

import java.util.List;

import com.sg.discount.Discount;
import com.sg.domain.Product;

public class DiscountStrategy {

	List<Discount> discounts;

	public DiscountStrategy(List<Discount> discounts) {
		this.discounts = discounts;
	}

	/**
	 * Return maximum discount for a product (product/brand/category)
	 * 
	 * @param product
	 * @return
	 */
	public Double getDiscount(Product product) {
		Double applicableDiscount = Double.valueOf(0.0);
		for (Discount discount : discounts) {
			Double currentDiscount = discount.getDiscount(product);
			if (currentDiscount > applicableDiscount) {
				applicableDiscount = currentDiscount;
			}
		}
		return applicableDiscount;
	}
}
