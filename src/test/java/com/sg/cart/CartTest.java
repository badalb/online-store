package com.sg.cart;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sg.discount.Discount;
import com.sg.discount.ProductDiscount;
import com.sg.discount.strategy.DiscountStrategy;
import com.sg.domain.Brand;
import com.sg.domain.Category;
import com.sg.domain.Price;
import com.sg.domain.Product;

public class CartTest {

	private Cart cart;

	private DiscountStrategy discountStrategy;

	@Before
	public void setUp() throws Exception {
		List<Discount> discounts = new ArrayList<>();
		discounts.add(new ProductDiscount());
		discountStrategy = new DiscountStrategy(discounts);
		cart = new Cart(discountStrategy);
	}

	@After
	public void tearDown() throws Exception {
		cart = null;
		discountStrategy = null;
	}

	@Test
	public void testAddProduct() {
		Product product = createProduct();
		cart.addProduct(product);
		List<Product> products = cart.getProducts();
		assertEquals(products.size(), 1);
	}

	@Test
	public void testRemoveProduct() {
		cart.removeProduct(createProduct());
		List<Product> products = cart.getProducts();
		assertEquals(products.size(), 0);
	}

	@Test
	public void testGetProducts() {
		Product product = createProduct();
		cart.addProduct(product);
		List<Product> products = cart.getProducts();
		assertEquals(products.size(), 1);
	}

	@Test
	public void testGetCartValue() {
		Product product = createProduct();
		cart.addProduct(product);
		Double cartValue = cart.getCartValue();
		assertTrue(cartValue == 800);
	}

	@Test
	public void testCalculateCartValue() {
		Product product = createProduct();
		cart.addProduct(product);
		Double cartValue = cart.calculateCartValue();
		assertTrue(cartValue == 720);
	}

	private Product createProduct() {
		Product product = new Product();
		product.setName("T Shirt");
		product.setPrice(new Price("INR", Double.valueOf(800)));
		product.setBrand(new Brand("Puma"));
		product.setCategory(createCategory());
		product.setDiscount(Double.valueOf(10));
		return product;
	}

	private Category createCategory() {
		Category parentCategory = new Category();
		parentCategory.setName("Men's wear");
		Category category = new Category();
		category.setName("T Shirt");
		category.setParent(parentCategory);

		return category;
	}

}
