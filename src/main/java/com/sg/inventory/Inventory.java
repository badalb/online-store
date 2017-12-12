package com.sg.inventory;

import java.util.ArrayList;
import java.util.List;

import com.sg.domain.Product;

public class Inventory {

	private List<Product> products;

	public Inventory() {
		products = new ArrayList<Product>();
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}

	public List<Product> getProduct() {
		return products;
	}

	public Product getProductById(Long id) {
		return products.stream().filter(p -> p.getId() == id).findAny().orElse(null);
	}
}
