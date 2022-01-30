package managmentsystem.ProductManagment;

import java.sql.ResultSet;
import managmentsystem.Models.Product;

public abstract class ProductInterface extends Product {
    
    
    public abstract void addProduct();
    public abstract void deleteProduct();
    public abstract void editProduct();
    public abstract ResultSet viewProduct();
    public abstract ResultSet viewProducts();
}
