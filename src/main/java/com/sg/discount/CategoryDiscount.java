package com.sg.discount;

import java.util.Map;

import com.sg.domain.Category;
import com.sg.domain.Product;

public class CategoryDiscount implements Discount {

	/**
	 * Return category or parent category level discount which is max
	 */
	@Override
	public Double getDiscount(Product product) {

		Double discount = Double.valueOf(0.0);
		Category category = product.getCategory();
		while (category != null) {
			if (category.getDiscount() != null && discount < category.getDiscount()) {
				discount = category.getDiscount();
			}
			category = category.getParent();
		}

		return discount;
	}

	@Override
	public void applyDiscount(Product product, Map<String, Double> discounts) {
		Category category = product.getCategory();
		while (category != null) {
			category.setDiscount(discounts.get(category.getName()));
			category = category.getParent();
		}
	}

	@Override
	public void removeDiscount(Product product, Map<String, Double> discounts) {
		// TODO Auto-generated method stub

	}

}
