package com.sg.cart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.sg.discount.BrandDiscount;
import com.sg.discount.CategoryDiscount;
import com.sg.discount.Discount;
import com.sg.discount.ProductDiscount;
import com.sg.discount.strategy.DiscountStrategy;
import com.sg.domain.Product;
import com.sg.inventory.Inventory;

public class CartBuilder {

	public List<Cart> buildCart(String filePath, Inventory inventory) {

		List<Discount> discounts = new ArrayList<>();
		discounts.add(new BrandDiscount());
		discounts.add(new CategoryDiscount());
		discounts.add(new ProductDiscount());
		DiscountStrategy strategy = new DiscountStrategy(discounts);

		List<Cart> carts = new ArrayList<>();
		try {
			Integer productCount = Integer.valueOf(Files.readAllLines(Paths.get(filePath)).get(0));
			String cartCount = Files.readAllLines(Paths.get(filePath)).get(productCount + 2);
			Integer sellRecordIndex = Integer.valueOf(productCount) + 2;
			for (int i = 0; i < Integer.valueOf(cartCount); i++) {
				Cart cart = new Cart(strategy);
				String line = Files.readAllLines(Paths.get(filePath)).get(sellRecordIndex + 1);
				String[] attributes = line.split(",");
				for (String productId : attributes) {
					Product product = inventory.getProductById(Long.valueOf(productId));
					cart.addProduct(product);
				}
				carts.add(cart);
				sellRecordIndex++;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return carts;
	}
}
