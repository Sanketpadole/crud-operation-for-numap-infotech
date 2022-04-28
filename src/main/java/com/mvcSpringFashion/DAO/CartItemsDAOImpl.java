package com.mvcSpringFashion.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mvcSpringFashion.Model.Product;

public class CartItemsDAOImpl implements CartItemsDAO {
	
	
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	final 
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.template = jdbcTemplate;
	}

	
	
	
	public void addCartItem(Product p) {
		// TODO Auto-generated method stub
		 String sql = "insert into order values(?,?,?)";
	     template.update(sql, new Object[] { p.getName(), p.getQuantity(), p.getPrice() });
			
		
	}

	public void removeCartItem(int Id, String u) {
		// TODO Auto-generated method stub
		String sql2 = String.format("delete from groupassignment.item where orderid='%s' and id='%s';", u,Id);		
		
		template.update(sql2);
		String sql1 = String.format("delete from groupassignment.order where email='%s' and id='%s';", u,Id);		
		template.update(sql1);
		
	}
	
	
	public class ProductMapper implements RowMapper<Product> {

	    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

	    	Product p = new Product();
	    	p.setId(rs.getInt("id"));
	    	p.setName(rs.getString("name"));
	    	p.setPrice(rs.getInt("price"));
	    	p.setQuantity(rs.getInt("quantity"));
	       

	        return p;

	    }
	}
	
	
	

	public void removeAllCartItems(String u) {
		// TODO Auto-generated method stub
		
		
		String sql2 = String.format("DELETE FROM groupassignment.item where orderid='%s';", u);		
		
		template.update(sql2);
		
		String sql1 = String.format("DELETE FROM groupassignment.order where email='%s';", u);		
		template.update(sql1);
		
	}

	

}
