package com.sg.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sg.discount.strategy.DiscountStrategy;
import com.sg.domain.Price;
import com.sg.domain.Product;

public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3592002880260438171L;

	private List<Product> products;

	private DiscountStrategy discountStrategy;

	public Cart(DiscountStrategy discountStrategy) {
		this.products = new ArrayList<Product>();
		this.discountStrategy = discountStrategy;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void removeProduct(Product product) {
		this.products.remove(product);
	}

	public List<Product> getProducts() {
		return products;
	}

	public Double getCartValue() {
		return products.stream().map(product -> product.getPrice()).mapToDouble(Price::getPrice).sum();
	}

	public Double calculateCartValue() {
		Double value = Double.valueOf(0.0);
		for (Product product : products) {
			Double discount = discountStrategy.getDiscount(product);
			value = value + (product.getPrice().getPrice() - discount * product.getPrice().getPrice() / 100);
		}
		return value;
	}

	@Override
	public String toString() {
		return "Cart [products=" + products + "]";
	}
}
