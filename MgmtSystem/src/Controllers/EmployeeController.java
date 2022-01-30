package Controllers;

import java.util.List;
import managmentsystem.Models.Employee;
import managmentsystem.Models.User;

public class EmployeeController {

    Employee employee = new Employee();
    
    public EmployeeController(){}

    public void addEmployee(Employee e) {
        employee.addUser(e);
    }

    public void editEmployee(String id, Employee e) {
        employee.editUser(e);
    }

    public void deleteEmployee(String id) {
        employee.deleteUser(id);
    }

    public List<User> viewEmployees() {
        return employee.viewUsers();
    }
}