package com.sg.inventory.factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sg.inventory.Inventory;

public class FileSourceInventoryBuilderTest {
	
	FileSourceInventoryBuilder builder;
	
	@Before
	public void setUp() throws Exception {
		builder = new FileSourceInventoryBuilder();
	}

	@After
	public void tearDown() throws Exception {
		builder = null;
	}

	@Test
	public void testCreateInventory() {
		String sourcePath = "/Users/badalb/Kubrenetes/shopping-kart/src/test/resources/test.csv";;
		Inventory inventory = builder.createInventory(sourcePath);
		assertTrue(inventory != null);
		assertEquals(inventory.getProduct().size(), 5);
	}

}
