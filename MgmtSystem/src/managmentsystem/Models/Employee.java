package managmentsystem.Models;

import java.util.List;
import managmentsystem.DAOs.EmployeeDAO;

public class Employee extends User implements UsersInterface, EmployeeInterface{
    
    EmployeeDAO edao = new EmployeeDAO();
    String designation;
    public Employee() {
    }
    
    //FROM EMPLOYEE INTERFCE
    public String getDesignation() {
        return designation;
    }

    //FROM EMPLOYEE INTERFCE
    public void setDesignation(String designation) {
        this.designation = designation;
    }
   
    //-----------------------FROM USERS INTERFCE------------------------------//
    public void addUser(Employee e) {
        edao.insertEmployee(e);
    }

    public void editUser(Employee e) {
        edao.editEmployee(e);
    }

    public void deleteUser(String id) {
        edao.deleteEmployee(id);
    }

    @Override
    public List<User> viewUsers() {
        return edao.viewAllEmployees();
    }
    
}
