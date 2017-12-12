package com.sg.inventory.factory;

import com.sg.inventory.Inventory;

public interface InventoryBuilder {
	public Inventory createInventory(String sourcePath);
}
