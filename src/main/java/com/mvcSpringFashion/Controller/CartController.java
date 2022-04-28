package com.mvcSpringFashion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvcSpringFashion.DAO.CartDAO;
import com.mvcSpringFashion.DAO.CustomerDAO;
import com.mvcSpringFashion.DAO.ProductDAO;
import com.mvcSpringFashion.Model.Product;



@Controller
public class CartController {

	@Autowired
	CartDAO cartdao;
	
	@Autowired
	CustomerDAO customerdao;
	
	@Autowired
	ProductDAO productdao;
	
	@RequestMapping("/cart/getCart")
	public String getCartItems(Model m){
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String emailId = user.getUsername();
		 List<Product> products= productdao.getCartByCartId(emailId);
	      m.addAttribute("lists", products);
	      double total=0;

	      for (Product src : products) {
	    	
	    	  total+=src.getPrice();
	      }
	      
	      
	    // double overall = total;
 
	      m.addAttribute("Total",total);


	    return "cart";
	} 
	
}
