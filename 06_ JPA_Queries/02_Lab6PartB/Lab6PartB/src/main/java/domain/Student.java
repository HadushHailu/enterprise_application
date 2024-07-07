package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int studentNumber;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Department department;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Grade> grades = new ArrayList<>();

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                '}';
    }

    public Student(String name, int studentNumber, Department department, Grade grades) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.department = department;
        this.grades.add(grades);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void addGrades(Grade grades) {
        this.grades.add(grades);
    }

    public String getName() {
        return name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Grade> getGrades() {
        return grades;
    }
}
