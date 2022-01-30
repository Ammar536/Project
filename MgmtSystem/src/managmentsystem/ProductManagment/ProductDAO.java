package managmentsystem.ProductManagment;

import java.util.List;
import managmentsystem.Models.Product;

public interface ProductDAO {
    public void insertProduct(Product p) throws Exception;
    public void deleteProduct(String id);
    public void editProduct(Product p);
    public Product getProductById(String id);
    public List<Product> viewAllProducts();
}
