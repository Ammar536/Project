package Controllers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import managmentsystem.ProductManagment.DataSource;
import managmentsystem.ProductManagment.MySqlDataSource;
import managmentsystem.ProductManagment.ProductDAO;
import managmentsystem.ProductManagment.ProductDaoImpl;
import managmentsystem.Models.Product;
import managmentsystem.ProductManagment.ProductInterface;

public class ProductController {
    DataSource dataSource = new MySqlDataSource();
    ProductDAO pdao = new ProductDaoImpl(dataSource);
    Product product = new Product() {};
    
    public ProductController(int id, String name, int price, int quntity, String ctegory){
        
        this.product.setId(id);
        this.product.setName(name);
        this.product.setPrice(price);
        this.product.setQuantity(quntity);
        this.product.setCategory(ctegory);
    }
    
    public ProductController(String name, int price, int quantity, String category){
        this.product.setName(name);
        this.product.setPrice(price);
        this.product.setQuantity(quantity);
        this.product.setCategory(category);
    }

    public ProductController() {
    }
    
    

    public ProductController(int id){
        this.product.setId(id);
    }
    public void addProduct() throws Exception {
        pdao.insertProduct(product);
    }

    public void editProduct() {
        pdao.editProduct(product);
    }

    public void deleteProduct(String id) {
        pdao.deleteProduct(id);
    }

    public List<Product> viewProducts() {
        return pdao.viewAllProducts();
    }
    public Product getProductById(String id){
        return pdao.getProductById(id);
    }
}
