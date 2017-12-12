package com.sg.inventory;

import com.sg.domain.Brand;

public class BrandBuilder {

	public static Brand buildBrand(String[] attributes) {
		Brand brand = new Brand();
		brand.setName(attributes[1].trim());
		return brand;
	}
}
