package com.mvcSpringFashion.Model;

import java.util.List;


public class Cart {
	private String cartId;


	private Customer customer;

	private List<CartItems> cartItem;

	private double totalPrice;

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItems> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItems> cartItem) {
		this.cartItem = cartItem;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	

}
