package com.sg.inventory.factory;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryFactoryTest {

	private InventoryFactory inventoryFactory;

	@Before
	public void setUp() throws Exception {
		inventoryFactory = new InventoryFactory();
	}

	@After
	public void tearDown() throws Exception {
		inventoryFactory = null;
	}

	@Test
	public void testGetInventoryBuilder() {
		InventoryBuilder builder = inventoryFactory.getInventoryBuilder("file");
		assertTrue(builder instanceof FileSourceInventoryBuilder);
	}
}
