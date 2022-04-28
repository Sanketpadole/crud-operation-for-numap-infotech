package com.mvcSpringFashion.DAO;

import com.mvcSpringFashion.Model.Product;

public interface CartItemsDAO {

	void addCartItem(Product p);
	void removeCartItem(int CartItemId, String u);
	void removeAllCartItems(String u);
}
