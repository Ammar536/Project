/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managmentsystem.DAOs;


import managmentsystem.Models.Customer;
import managmentsystem.DatabaseHandler;
import managmentsystem.Models.Employee;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import managmentsystem.Models.User;
public class CustomerDAO {
    
    private final DatabaseHandler db;
    public CustomerDAO(){
        db=new DatabaseHandler();
        db.init();
     }
    
    public void insertCustomer(User customer)
    {
        System.out.println("DOA");
        String query,status;
        
        query="insert into customers(firstname, lastname, phone, cnic, email, address) "
                + "values"+"('"+customer.getFirstName()+"','"+customer.getLastName()+"','"+customer.getPhone()+"','"+customer.getCnic()+"','"+customer.getEmail()+"','"+customer.getAddress()+"')";
        
        System.out.println(query);
        status=db.insertRecord(query);
        System.out.println(status);
    }
    
    public List<User> viewAllCustomers()
    {
        String query;
        query="select * from customers";
        System.out.println("CUSTOMER DAO");
        List<User> uList = new ArrayList<>();
        
        ResultSet rs = db.getAllRecords(query);
       
        
        try{
            while(rs.next())
            {
                User c = new Customer();
                c.setId(rs.getInt(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setCnic(rs.getString(4));
                c.setPhone(rs.getString(5));
                c.setEmail(rs.getString(6));
                c.setAddress(rs.getString(7));
                
                uList.add(c);
            }
            return uList;
        }catch(Exception e){
            return null;
        }
        
    }
    
    public User getCustomerById(String id)
    {
        String query;
        query="select * from customers WHERE id="+id+";";
        System.out.println("CUSTOMER DAO :"+query);
        
        User customer = new Customer();
        ResultSet rs = db.getById(query);
        
        try{
//            if(rs.next())
//            {
                while(rs.next())
                {
                    customer.setId(rs.getInt(1));
                    customer.setFirstName(rs.getString(2));
                    customer.setLastName(rs.getString(3));
                    customer.setCnic(rs.getString(4));
                    customer.setPhone(rs.getString(5));
                    customer.setEmail(rs.getString(6));
                    customer.setAddress(rs.getString(7));
                    System.out.println("C1:"+customer.getFirstName());
                    return customer;
                }
                return customer;
//            }
//            else
//            {
//                System.out.println("Customer Not Found");
//                return null;
//            }
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
    
     public List<User> getCustomerByName(String name)
    {
        String query;
        query="select * from customers WHERE firstname="+name+";";
        System.out.println("CUSTOMER DAO :"+query);
        
        List<User> uList = new ArrayList<>();
        
        ResultSet rs = db.getById(query);
        
        try{
//            if(rs.next())
//            {
                while(rs.next())
                {
                    Customer customer = new Customer();
                    customer.setId(rs.getInt(1));
                    customer.setFirstName(rs.getString(2));
                    customer.setLastName(rs.getString(3));
                    customer.setCnic(rs.getString(4));
                    customer.setPhone(rs.getString(5));
                    customer.setEmail(rs.getString(6));
                    customer.setAddress(rs.getString(7));
                    uList.add(customer);
                }
                return uList;
//            }
//            else
//            {
//                System.out.println("Customer Not Found");
//                return null;
//            }
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    public void editCustomer(User c)
    {
        String query,status;
        query="UPDATE customers SET firstname='"+c.getFirstName()+"', lastname='"+c.getLastName()+"', phone='"+c.getPhone()+"', cnic='"+c.getCnic()+
                "', email='"+c.getEmail()+"', address='"+c.getAddress()+"' WHERE id="+c.getId()+";";
        System.out.println(query);
        status=db.editRecord(query);
        System.out.println(status);
    }
    
    public void deleteCustomer(String id)
    {
        String query,status;
        query="DELETE FROM CUSTOMERS WHERE id="+id+";";
        System.out.println(query);
        status=db.deleteRecord(query);
        System.out.println(status);
    }
    
}
