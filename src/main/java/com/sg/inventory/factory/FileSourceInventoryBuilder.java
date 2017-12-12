package com.sg.inventory.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sg.inventory.ProductBuilder;
import com.sg.inventory.Inventory;

public class FileSourceInventoryBuilder implements InventoryBuilder {

	@Override
	public Inventory createInventory(String sourcePath) {

		Inventory inventory = new Inventory();
		Path pathToFile = Paths.get(sourcePath);
		try {
			BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
			String line = br.readLine();
			Integer productCount = Integer.valueOf(line);
			for (int i = 0; i < productCount; i++) {
				line = br.readLine();
				String[] attributes = line.split(",");
				inventory.addProduct(ProductBuilder.buildProduct(attributes));

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return inventory;
	}
}