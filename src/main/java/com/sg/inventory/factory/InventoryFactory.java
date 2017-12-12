package com.sg.inventory.factory;

public class InventoryFactory {

	public InventoryBuilder getInventoryBuilder(String source) {
		if (source.equalsIgnoreCase("file")) {
			return new FileSourceInventoryBuilder();
		}
		return null;
	}
}
