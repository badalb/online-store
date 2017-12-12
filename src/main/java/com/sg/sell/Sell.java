package com.sg.sell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sg.discount.BrandDiscount;
import com.sg.discount.CategoryDiscount;
import com.sg.discount.Discount;
import com.sg.discount.ProductDiscount;
import com.sg.domain.Product;
import com.sg.inventory.Inventory;

public class Sell {

	private List<Discount> discounts;

	public Sell() {
		discounts = new ArrayList<>();
		discounts.add(new BrandDiscount());
		discounts.add(new CategoryDiscount());
		discounts.add(new ProductDiscount());
	}

	private Map<String, Double> readDiscounts(String filePath) {

		Map<String, Double> discountMap = new HashMap<>();
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = br.readLine();
			while (line != null) {
				String[] attributes = line.split(",");
				discountMap.put(attributes[0].trim(), Double.valueOf(attributes[1].trim()));
				line = br.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return discountMap;
	}

	public void applySellDiscountToInventory(Inventory inventory, String discountFilePath) {

		Map<String, Double> discountMap = readDiscounts(discountFilePath);
		for (Product product : inventory.getProduct()) {
			for (Discount discount : discounts) {
				discount.applyDiscount(product, discountMap);
			}
		}
	}
}
