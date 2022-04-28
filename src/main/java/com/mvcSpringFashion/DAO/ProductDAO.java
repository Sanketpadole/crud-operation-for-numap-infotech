package com.mvcSpringFashion.DAO;

import java.util.List;

import com.mvcSpringFashion.Model.Product;


public interface ProductDAO {

	List<Product> getAllProducts();//list of all product present in list

	Product getProductById(int id); // for the id

	void deleteProduct(int id); // delete product 

	void addProduct(Product product); // add product 
    void addProduct2(Product product) ;
	
	void editProduct(Product product); //edit
	
	List<Product> getCartByCartId(String CartId); //here list of cartitemsId
	
}
