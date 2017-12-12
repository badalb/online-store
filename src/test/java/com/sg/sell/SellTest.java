package com.sg.sell;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sg.domain.Product;
import com.sg.inventory.Inventory;
import com.sg.inventory.factory.FileSourceInventoryBuilder;

public class SellTest {

	private Sell sell;
	private FileSourceInventoryBuilder builder;

	@Before
	public void setUp() throws Exception {
		sell = new Sell();
		builder = new FileSourceInventoryBuilder();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testApplySellDiscountToInventory() {
		String sourcePath = "/Users/badalb/Kubrenetes/shopping-kart/src/test/resources/test.csv";
		Inventory inventory = builder.createInventory(sourcePath);
		String discountFilePath = "discounts.csv";
		sell.applySellDiscountToInventory(inventory, discountFilePath );
		Product product = inventory.getProduct().get(0);
		assertTrue(product !=null );
		assertEquals(product.getBrand().getDiscount().intValue(),20);
	}

}
