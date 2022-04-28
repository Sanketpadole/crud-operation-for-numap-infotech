package com.mvcSpringFashion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping({"/" ,"/index1" })
	public String sayIndex() {
		return "index1";
	}
	
	@RequestMapping({"/thankCustomer"})
	public String order() {
		return "thankCustomer";
	}
	
	
	
	@RequestMapping("/aboutus")
	public String sayAbout() {
		return "aboutUs";
	}


}
