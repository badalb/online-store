package com.sg.inventory;

import java.util.HashMap;
import java.util.Map;

import com.sg.domain.Category;

public class CategoryBuilder {

	private static Map<String, String> categoryMap;

	public static Category buildCategory(String[] attributes) {
		Category category = new Category();
		category.setName(attributes[2].trim());
		// It should have been dynamic, further hierarchy can be created looking
		// it further. Product creation guideline missing parent category
		// information, but we can set parent category, parents parent category
		// like that!!!
		if (getParentCategory(attributes[2].trim()) != null) {
			Category parentCategory = new Category();
			parentCategory.setName(getParentCategory(attributes[2].trim()));
			category.setParent(parentCategory);
		}
		return category;
	}

	/**
	 * Ideally hierarchy has to be created dynamically, here product creation do
	 * not have the parent category info so lets create it statically
	 * 
	 * @param categoryName
	 */
	public static String getParentCategory(String categoryName) {
		if (categoryMap == null) {
			categoryMap = new HashMap<>();
			poplateParentCategoryMap();
		}
		return categoryMap.get(categoryName);
	}

	public static Map<String, String> poplateParentCategoryMap() {
		categoryMap.put("Shirts", "Men's wear");
		categoryMap.put("Trousers", "Men's wear");
		categoryMap.put("Casuals", "Men's wear");
		categoryMap.put("Jeans", "Men's wear");
		categoryMap.put("Dresses", "Women's wear");
		categoryMap.put("Footwear", "Women's wear");
		return categoryMap;
	}
}
