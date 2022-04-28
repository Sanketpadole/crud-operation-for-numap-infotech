package com.mvcSpringFashion.Model;


public class CartItems {

	public String orderid;
	
	private int productid;
	
	private int quantity;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public CartItems() {
		super();
		this.orderid = orderid;
		this.productid = productid;
		this.quantity = quantity;
	}
	
}
