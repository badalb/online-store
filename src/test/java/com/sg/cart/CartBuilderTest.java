package com.sg.cart;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sg.domain.Product;
import com.sg.inventory.Inventory;

public class CartBuilderTest {

	private CartBuilder cartBuilder;

	Inventory inventory;

	Product product;

	@Before
	public void setUp() throws Exception {
		product = mock(Product.class);
		inventory = mock(Inventory.class);
		cartBuilder = new CartBuilder();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testBuildCart() {
		when(inventory.getProductById(1L)).thenReturn(product);
		String filePath = "/Users/badalb/Kubrenetes/shopping-kart/src/test/resources/test.csv";
		List<Cart> carts = cartBuilder.buildCart(filePath, inventory);
		assertEquals(carts.size(), 1);
	}
}
