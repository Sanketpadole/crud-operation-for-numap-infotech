package com.mvcSpringFashion.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.mvcSpringFashion.DAO.ProductDAOImpl.ProductMapper;
import com.mvcSpringFashion.Model.CartItems;
import com.mvcSpringFashion.Model.Customer;
import com.mvcSpringFashion.Model.Product;

public class CustomerDAOImpl implements CustomerDAO {
	
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
		
	}
	
	

	public void register(Customer cust, Customer order) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `groupassignment`.`order` (`id`, `total`, `email`, `address`, `name`, `orderstatus`,`city`,`phone`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    template.update(sql, new Object[] { cust.getId(),cust.getTotal(), cust.getEmail(),
	     order.getAddress(),order.getName(),order.getOrderstatus(),order.getCity(),order.getPhone()});
		
	     String sql1 = "INSERT INTO `groupassignment`.`item` (`id`, `orderid`, `quantity`) VALUES (?, ?, ?)";

	     template.update(sql1, new Object[] { cust.getId(),cust.getEmail(),cust.getOrderstatus()});
	}

	public Customer getCustomerByemailId(String emailId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM order where email ="+ emailId;
	    return template.query(sql, new ResultSetExtractor<Customer>() {
			 
	        public Customer extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Customer p = new Customer();
	                p.setId(rs.getInt("id"));
	                p.setEmail(rs.getString("email"));
	                p.setName(rs.getString("name"));
	                
	                p.setAddress(rs.getString("address"));
	                p.setOrderstatus(rs.getInt("orderstatus"));
	           	    p.setCity(rs.getString("city"));
	           	    
	           	    p.setPhone(rs.getInt("phone"));
	                return p;
	            }
	 
	            return null;
	        }
	 
	    });
		
	}
	
	class CustomerMapper implements RowMapper<Customer> {

     	  public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
     		 Customer order = new Customer();
        	    order.setEmail(rs.getString("email"));
        	    order.setAddress(rs.getString("address"));
        	    order.setName(rs.getString("name"));
        	    order.setCity(rs.getString("city"));
        	    order.setId(rs.getInt("id"));
        	    order.setPhone(rs.getInt("phone"));
        	   
        	    order.setOrderstatus(1);
        	    return order;
     	  }
		
		
	}
  
		 class CartItemsMapper implements RowMapper<CartItems> {

	       	  public CartItems mapRow(ResultSet rs, int arg1) throws SQLException {
	       	    CartItems cart = new CartItems();
	       	    cart.setProductid(rs.getInt("id"));
	       	    cart.setOrderid(rs.getString("name"));
	       	    cart.setQuantity(rs.getInt("quantity"));
	       	    return cart;
	       	  }
			
			
		}


	public Customer getCustomerdetails(int cartId, String u) {
		// TODO Auto-generated method stub
		String sql2 = String.format("select * from groupassignment.order where id=%s and email='%s'",cartId,u);
	      return template.query(sql2, new ResultSetExtractor<Customer>() {
	 		 
		        public Customer extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		                Customer order = new Customer();
		                order.setEmail(rs.getString("email"));
		           	    order.setAddress(rs.getString("address"));
		        	    order.setName(rs.getString("name"));
		        	    order.setCity(rs.getString("city"));
		           	   
		           	    order.setPhone(rs.getInt("phone"));
		           	   
		           	    order.setOrderstatus(1);
		                return order;
		            }
		 
		            return null;
		        }
		 
		    });
	}
	
	
	
	public List<Customer> getOrderdetails() {
		// TODO Auto-generated method stub
		String sql2 = String.format("select * from groupassignment.order;");
		List<Customer> orderlist = template.query(sql2, new CustomerMapper());
	    return orderlist;
	}
	

    

}
