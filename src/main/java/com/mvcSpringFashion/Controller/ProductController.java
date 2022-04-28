package com.mvcSpringFashion.Controller;
//DAO --data access obj

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

import com.mvcSpringFashion.DAO.ProductDAO;
import com.mvcSpringFashion.Model.Product;
//indicates an annotated class 
//controlling the user interact with mvc app
@Controller 
public class ProductController {

	//framwork --enable to inject obj dependancy
	@Autowired
	ProductDAO productdao; // obj created 


	  @RequestMapping(value = "/productList")
	  public String ProductList(Model m) {
	 
		  List<Product> products = productdao.getAllProducts();
	      m.addAttribute("lists", products);
	   
	  return "productList";
	  }
	
	

	@RequestMapping("getProductById/{id}")
	
	public ModelAndView getProductById(@PathVariable(value = "id") int id) {
		Product product = productdao.getProductById(id);
		return new ModelAndView("productPage", "product", product);
	}
	
	

	@RequestMapping("/admin/delete/{id}")
	public String deleteProduct(@PathVariable(value = "id") int id) {

		productdao.deleteProduct(id);
		
		return "redirect:/productList";
	}
	
	

	//request map is allows easy mapping of url parameters
	 @RequestMapping(value = "/admin/addProduct", method = RequestMethod.GET) //req data from specific resources
	 
	 //here showing addproduct.jsp page after click on on -->addproduct
	  public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("addProduct"); //create an obj of modelview and pass value
	    mav.addObject("product", new Product());//Add an attribute to the model
	    User user =(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	  		  String name = user.getUsername(); 
	  		  System.out.println(name);

	    return mav;
	  }
	 
	 
	 
	 //after hitting the add button form colllect the datta from the admin
	 @RequestMapping(value = "/admin/addProductProcess", method = RequestMethod.POST)
	  public ModelAndView addProduct(HttpServletRequest request, HttpServletResponse response,
	  
		//Annotation that binds a method parameter 
		//method return value to a named model attribute, exposed to a web view. 	  
	   @ModelAttribute("product") Product product) {

	  productdao.addProduct(product);//calling of addproduct in productdao


	  return new ModelAndView("redirect:addProduct", "name", product); // redirect on same page
	  }

	
	  
	  //only for showing the edit page 
	  @RequestMapping(value = "/admin/editProduct/{id}")
	public ModelAndView getEditForm(@PathVariable(value = "id") int id) {
		
		Product product = productdao.getProductById(id);
		return new ModelAndView("editProduct", "editProductObj", product);
	}

	
	
	//after hitting the edit button product table updated
	@RequestMapping(value = "/admin/editProduct" , method = RequestMethod.POST)
	public String editProduct(@ModelAttribute(value = "editProductObj") Product product) {
		
		productdao.editProduct(product);
		
		return "redirect:/productList";
	}

	
	  
	
	
	@RequestMapping("/getProductsList")
	  public List<Product> getProductsListInJson() 
	  { return productdao.getAllProducts(); }
	 

}