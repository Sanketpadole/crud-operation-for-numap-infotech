package com.mvcSpringFashion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvcSpringFashion.DAO.CartDAO;
import com.mvcSpringFashion.DAO.CartItemsDAO;
import com.mvcSpringFashion.DAO.CustomerDAO;
import com.mvcSpringFashion.DAO.ProductDAO;
import com.mvcSpringFashion.Model.Customer;
import com.mvcSpringFashion.Model.Product;

@Controller
public class CartItemsController {
	
	@Autowired
	CartDAO cartdao;
	
	@Autowired
	CustomerDAO customerdao;
	
	@Autowired
	ProductDAO productdao;
    

	@Autowired
	CartItemsDAO cartitemdao;
	
	

	@RequestMapping("/cart/add/{productId}")
	
	public void addCartItem(@PathVariable(value = "productId") int productId,Customer user,Product p) {

	    cartitemdao.addCartItem(p);
	}
	

	@RequestMapping("/cart/removeCartItem/{id}")
	
	public String removeCartItem(@PathVariable(value = "id") int id) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String emailId = user.getUsername();
		cartitemdao.removeCartItem(id,emailId);
		return "redirect:cart";
	}

	@RequestMapping("/cart/removeAllItems")
	
	public String removeAllCartItems() {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String emailId = user.getUsername();
		cartitemdao.removeAllCartItems(emailId);
		
		return "redirect:checkOutCancelled";
	}
	
	@RequestMapping("/checkOutCancelled")
	
	public String checkoutcancelled() {
	      
		return "checkOutCancelled";
	}
	

}