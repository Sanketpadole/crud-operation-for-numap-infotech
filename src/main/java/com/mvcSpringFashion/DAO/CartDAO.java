package com.mvcSpringFashion.DAO;

import com.mvcSpringFashion.Model.CartItems;

public interface CartDAO {

	CartItems getCartByCartId(int CartId);
}
