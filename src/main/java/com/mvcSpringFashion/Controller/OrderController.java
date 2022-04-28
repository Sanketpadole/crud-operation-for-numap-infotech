package com.mvcSpringFashion.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mvcSpringFashion.DAO.CartDAO;
import com.mvcSpringFashion.DAO.CartItemsDAO;
import com.mvcSpringFashion.DAO.CustomerDAO;
import com.mvcSpringFashion.DAO.ProductDAO;
import com.mvcSpringFashion.Model.Customer;
import com.mvcSpringFashion.Model.Product;
import com.mvcSpringFashion.Model.UserPort;

@Controller
public class OrderController {

	@Autowired
	CartDAO cartdao;
	
	@Autowired
	CustomerDAO customerdao;
	
	@Autowired
	ProductDAO productdao;
    

	@Autowired
	CartItemsDAO cartitemdao;


	@RequestMapping(value="/orderConfirmation/{id}/{name}/{price}/{totalp}")
	public ModelAndView customerDetails(@PathVariable("id") int id,
			@PathVariable(value = "name") String name ,
			@PathVariable(value = "price") int price ,
			@PathVariable(value = "totalp") int totalp,Model m) {

		 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 String emailId = user.getUsername();
		 Product pr= new Product();
		// pr.setImageurl(imageUrl);
		 pr.setId(id);
		 pr.setName(name);
		 pr.setPrice(price);
		 productdao.addProduct2(pr);
		Customer cust= customerdao.getCustomerdetails(id,emailId);
		
	cust.setTotal(totalp);
		return new ModelAndView("orderConfirmation","cust",cust);
	}
	
	 @RequestMapping(value = "/collectCustomerInfo/{id}/{price}", method = RequestMethod.GET)
	  public ModelAndView orderRegister(@PathVariable(value = "id") int id,@PathVariable(value = "price") int price,HttpServletRequest request, HttpServletResponse response,UserPort object) {
	    ModelAndView mav = new ModelAndView("collectCustomerInfo");
	    mav.addObject("order", new Customer());
        Customer cust = new Customer();
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String emailId = user.getUsername();
		cust.setEmail(emailId);
	    cust.setId(id);
	    cust.getCity();
        cust.setTotal(price);
        ModelAndView mav1 = new ModelAndView(new RedirectView("collectCustomerInfoProcess"));
        mav1.addObject("cust",cust);
        UserPort.setUser(cust);
	    return mav;
	  }
      
	  
	  @RequestMapping(value = "/collectCustomerInfoProcess", method = RequestMethod.POST)
	  public ModelAndView addorder(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("order") Customer order) {
		    Customer cust=UserPort.getUser();
		    customerdao.register(cust,order);
	  return new ModelAndView("redirect:/cart/getCart", "order", order);
	  }
	  
	  
	  @RequestMapping(value = "/admin/orderdisplay")
	  public String OrderDisplay(Model m) {
	 
		  List<Customer> order = customerdao.getOrderdetails();
	      m.addAttribute("lists", order);
	   
	  return "orderdisplay";
	  }
	

}
