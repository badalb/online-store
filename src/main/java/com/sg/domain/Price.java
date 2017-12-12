package com.sg.domain;

import java.io.Serializable;

public class Price implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 587501899822945047L;

	private String currency;

	private Double price;

	public Price() {
	}
	
	public Price(String currency, Double price) {
		super();
		this.currency = currency;
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductPrice [currency=" + currency + ", price=" + price + "]";
	}

}
