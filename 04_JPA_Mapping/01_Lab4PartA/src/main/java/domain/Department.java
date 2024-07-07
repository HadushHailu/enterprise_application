package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    // Method to add an employee to the department
    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setDepartment(this); // Set the department on the employee side
    }

    public Department(){}
    public Department(String name) {
        this.name = name;
    }
}
