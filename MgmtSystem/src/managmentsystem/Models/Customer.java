package managmentsystem.Models;

import java.util.List;
import managmentsystem.DAOs.CustomerDAO;

public class Customer extends User implements UsersInterface{
    
    CustomerDAO cdao = new CustomerDAO();
    public Customer() {
    } 
    
    public void addUser(User u) {
        cdao.insertCustomer(u);
    }

    public void editUser(User c) {
        cdao.editCustomer(c);
    }

    public void deleteUser(String id) {
        cdao.deleteCustomer(id);
    }

    public List<User> viewUsers() {
        return cdao.viewAllCustomers();
    }
}
