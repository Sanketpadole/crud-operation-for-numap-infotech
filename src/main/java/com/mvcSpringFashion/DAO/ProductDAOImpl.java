package com.mvcSpringFashion.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


import com.mvcSpringFashion.Model.Product;

public class ProductDAOImpl implements ProductDAO {
	
	JdbcTemplate  template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Product> getAllProducts() {
		String sql = "select * from product1";
		List<Product> productlist = template.query(sql, new ProductMapper());
	    return productlist;
	}

	
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product1 WHERE Id=" + id;
	    return template.query(sql, new ResultSetExtractor<Product>() {
	 
	        public Product extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Product p = new Product();
	                p.setId(rs.getInt("id"));
	                p.setName(rs.getString("name"));
	                p.setImageurl(rs.getString("imageurl"));
	                p.setPrice(rs.getInt("price"));
	                p.setQuantity(rs.getInt("quantity"));
	                return p;
	            }
	 
	            return null;
	        }
	 
	    });
}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM product1 where id="+id;
		  template.update(sql);
		
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO product1 (name, imageurl, price, quantity) VALUES ( ?, ?, ?,?)";

	        template.update(sql,new Object[] {product.getName(),product.getImageurl(),
	        		product.getPrice(),product.getQuantity() });
			
		}
	
	public void addProduct2(Product product) {
		// TODO Auto-generated method stub
		 String sql = "INSERT INTO product2 (id, name, price) VALUES ( ?, ?,?)";

	        template.update(sql,new Object[] {product.getId(),product.getName(),
	        		product.getPrice() });
			
		}


	public void editProduct(Product product) {
		// TODO Auto-generated method stub
		String sql = "UPDATE product1 SET name=?, imageurl=?, quantity=?, price=? WHERE id=?";
		 //String sql="update product1 set name='"+product.getName()+"', imageurl="+product.getImageurl()+",quantity="+product.getQuantity()+",price="+product.getPrice()+"'where id="+product.getId()+"";                 
				
		
        template.update(sql, product.getName(),product.getImageurl(), product.getQuantity(),product.getPrice(),product.getId());
        
		 //template.update(sql);
}

	public List<Product> getCartByCartId(String CartId) {
		String sql = "SELECT * FROM product1 where id IN (select id from item where orderid="+"'"+CartId+"');";
		
		 
		List <Product> productList=template.query(sql, new ProductMapper()) ; 
		double grandTotal = 0;
		for(Product total: productList){
			grandTotal += total.getPrice();
		}
		Product p = new Product();
		p.setGrandtotal(grandTotal);
		return productList;
	}
	
	//iterated the resultset and add in collection
	class ProductMapper implements RowMapper<Product> {
		
		//map each row 
		 public Product mapRow(ResultSet rs, int arg1) throws SQLException {
	         Product p = new Product();
	         //get and set
	         p.setId(rs.getInt("id"));
	         p.setName(rs.getString("name"));
	         p.setImageurl(rs.getString("imageurl"));
	         p.setPrice(rs.getInt("price"));
	         p.setQuantity(rs.getInt("quantity"));

	         return p;
	     }


		 }

}
