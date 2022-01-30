package Controllers;

import managmentsystem.Models.Customer;
import managmentsystem.Models.User;

public class CustomerController {

    Customer customer = new Customer();
    
    public CustomerController(){}

    public void addCustomer(Customer c) {
        customer.addUser(c);
    }

    public void editCustomer(String id, Customer c) {
        customer.editUser(c);
    }

    public void deleteCustomer(String id) {
        customer.deleteUser(id);
    }

    public void viewCustomers() {
        customer.viewUsers();
    }
}
