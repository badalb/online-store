package com.sg.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.sg.cart.CartBuilder;
import com.sg.cart.Cart;
import com.sg.inventory.Inventory;
import com.sg.inventory.factory.InventoryFactory;
import com.sg.sell.Sell;

public class AppMain {

	public static void main(String[] args) {

		switch (args.length) {
		case 0:
			System.out.println("Please enter 'exit' to quit");
			System.out.println("Waiting for input...");

			for (;;) {
				try {
					BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
					String inputString = bufferRead.readLine();
					if (inputString.equalsIgnoreCase("exit")) {
						break;
					} else if ((inputString == null) || (inputString.isEmpty())) {
						System.out.println("Please enter valid input ....");
					} else {
						InventoryFactory factory = new InventoryFactory();
						Inventory inventory = factory.getInventoryBuilder("file").createInventory(inputString);

						String discountFilePath = "discounts.csv";
						Sell discount = new Sell();
						discount.applySellDiscountToInventory(inventory, discountFilePath);

						List<Cart> cartList = new CartBuilder().buildCart(inputString, inventory);
						for (Cart shoppingCart : cartList) {
							System.out.println("Cart Value: " + shoppingCart.calculateCartValue());
						}
					}
				} catch (IOException e) {
					System.out.println("Oops! Error in reading the input from console.");
					e.printStackTrace();
				}
			}

		}
	}
}
