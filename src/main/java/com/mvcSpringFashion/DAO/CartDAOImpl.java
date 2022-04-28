package com.mvcSpringFashion.DAO;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mvcSpringFashion.Model.CartItems;

public class CartDAOImpl implements CartDAO {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public CartItems getCartByCartId(int CartId) {
		 String sql = "SELECT id FROM item WHERE orderid = ?";
		
		 return (CartItems) template.query(sql, new CartIdRowMapper()) ; 
		
	}
	
	public class CartIdRowMapper implements RowMapper<CartItems> {
	    public CartItems mapRow(ResultSet rs, int rowNum) throws SQLException {

	    	CartItems cart = new CartItems();
	    	cart.setOrderid(rs.getString("orderid"));
	    	cart.setProductid(rs.getInt("productid"));
	    	cart.setQuantity(rs.getInt("quantity"));
	       

	        return cart;

	    }}
	
	
	
	
	

}
