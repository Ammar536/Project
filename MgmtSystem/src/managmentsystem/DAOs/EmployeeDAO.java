/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managmentsystem.DAOs;

import managmentsystem.Models.Employee;
import managmentsystem.DatabaseHandler;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import managmentsystem.Models.User;
/**
 *
 * @author DELL
 */
public class EmployeeDAO {
    private final DatabaseHandler db;
    public EmployeeDAO(){
        db=new DatabaseHandler();
        db.init();
     }
    public void insertEmployee(Employee employee)
    {
        System.out.println("DOA");
        String query,status;
        
        query="insert into employees(firstname, lastname, phone, cnic, email, designation) "
                + "values"+"('"+employee.getFirstName()+"','"+employee.getLastName()+"','"+employee.getPhone()+"','"+employee.getCnic()+"','"+employee.getEmail()+"','"+employee.getDesignation()+"')";
        
        System.out.println(query);
        status=db.insertRecord(query);
        System.out.println(status);
    }
    
    public List<User> viewAllEmployees()
    {
        String query;
        query="select * from employees";
        System.out.println("EMPLOYEE DAO");
        List<User> uList = new ArrayList<>();
        
        ResultSet rs = db.getAllRecords(query);
       
        
        try{
            while(rs.next())
            {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setFirstName(rs.getString(2));
                e.setLastName(rs.getString(3));
                e.setPhone(rs.getString(4));
                e.setCnic(rs.getString(5));
                e.setEmail(rs.getString(6));
                e.setDesignation(rs.getString(7));
                
                uList.add(e);
            }
            return uList;
        }catch(Exception e){
            return null;
        }
    }
    
    public Employee getEmployeeById(String id)
    {
        String query;
        query="select * from employees WHERE id="+id+";";
        System.out.println("EMPLOYEE DAO:"+query);
        
        ResultSet rs = db.getById(query);
        Employee employee = new Employee();
        try{
//            if(rs.next())
//            {
                while(rs.next())
                {
                    employee.setId(rs.getInt(1));
                    employee.setFirstName(rs.getString(2));
                    employee.setLastName(rs.getString(3));
                    employee.setPhone(rs.getString(4));
                    employee.setCnic(rs.getString(5));
                    employee.setEmail(rs.getString(6));
                    employee.setDesignation(rs.getString(7));
                    return employee;
                }
                return employee;
            
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
    
    public void editEmployee(Employee e)
    {
        String query,status;
        query="UPDATE employees SET firstname='"+e.getFirstName()+"', lastname='"+e.getLastName()+"', phone='"+e.getPhone()+"', cnic='"+e.getCnic()+
                "', email='"+e.getEmail()+"', designation='"+e.getDesignation()+"' WHERE id="+Integer.toString(e.getId())+";";
        System.out.println(query);
        status=db.editRecord(query);
        System.out.println(status);
    }
    
    public void deleteEmployee(String id)
    {
        String query,status;
        query="DELETE FROM EMPLOYEES WHERE id="+id+";";
        System.out.println(query);
        status=db.editRecord(query);
        System.out.println(status);
    }
}
