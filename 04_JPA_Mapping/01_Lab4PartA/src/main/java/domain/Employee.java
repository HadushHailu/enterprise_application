package domain;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int employeeNumber;
    private String name;

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;

    public Employee(){}
    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
        if (department != null) {
            department.getEmployees().add(this); // Bidirectional relationship maintenance
        }
    }


}
