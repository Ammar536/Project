/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managmentsystem.ProductManagment;

import managmentsystem.ProductManagment.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import managmentsystem.DatabaseHandler;
import managmentsystem.Models.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDaoImpl implements ProductDAO{
    private final DatabaseHandler db;
    private DataSource dataSource;

    public ProductDaoImpl(DataSource dataSource){
        db=new DatabaseHandler();
        db.init();
        this.dataSource=dataSource;
        dataSource.createConnection();
     }
    
    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
    
    public void insertProduct(Product p)
    {
        System.out.println("DOA");
        String query,status;
        
        query="insert into products(price, name, category, quantity) "
                + "values"+"("+p.getPrice()+",'"+p.getName()+"','"+p.getCategory()+"',"+p.getQuantity()+");";
        
        System.out.println(query);
        status=db.insertRecord(query);
        System.out.println(status);
    }
    
    public List<Product> viewAllProducts()
    {
        try {
        
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRODUCTS");
            ResultSet rs = statement.executeQuery();
            List<Product> pList = new ArrayList<>();
            Product p = new Product() {};
            if (rs.next()) {
                    p.setId(rs.getInt(1));
                    p.setPrice(rs.getInt(2));
                    p.setName(rs.getString(3));
                    p.setCategory(rs.getString(4));
                    p.setQuantity(rs.getInt(5));
                    pList.add(p);
                }
                return pList;
        } catch (SQLException ex) {
            try {
                throw new Exception(ex.getMessage(), ex);
            } catch (Exception ex1) {
                Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }
   
    @Override
    public Product getProductById(String id)
    {
        try {
            
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRODUCTS WHERE ID = "+id);
            ResultSet rs = statement.executeQuery();
            Product p = new Product() {};
            if (rs.next()) {
                    p.setId(rs.getInt(1));
                    p.setPrice(rs.getInt(2));
                    p.setName(rs.getString(3));
                    p.setCategory(rs.getString(4));
                    p.setQuantity(rs.getInt(5));
                    return p;
                }
                return p;
        } catch (SQLException ex) {
            try {
                throw new Exception(ex.getMessage(), ex);
            } catch (Exception ex1) {
                Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return null;
    }
    
    
    public void editProduct(Product p)
    {
        String query,status;
        query="UPDATE products SET name='"+p.getName()
                +"', price="+p.getPrice()
                +", category='"+p.getCategory()
                +"', quantity="+p.getQuantity()
                + " WHERE id="+p.getId()+";";
        System.out.println(query);
        status=db.editRecord(query);
        System.out.println(status);
    }
    
    public void deleteProduct(String id)
    {
        String query,status;
        query="DELETE FROM products WHERE id="+id+";";
        System.out.println(query);
        status=db.editRecord(query);
        System.out.println(status);
    }
}
