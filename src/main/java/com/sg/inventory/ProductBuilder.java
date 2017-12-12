package com.sg.inventory;

import com.sg.domain.Product;

public class ProductBuilder {

	public static Product buildProduct(String[] attributes) {
		Product product = productAttrBuilder(attributes);
		product.setBrand(BrandBuilder.buildBrand(attributes));
		product.setCategory(CategoryBuilder.buildCategory(attributes));
		product.setPrice(PriceBuilder.buildProductPrice(attributes));
		return product;
	}

	private static Product productAttrBuilder(String[] attributes) {
		Product product = new Product();
		product.setId(Long.valueOf(attributes[0].trim()));
		product.setName(attributes[2].trim());
		return product;
	}
}
