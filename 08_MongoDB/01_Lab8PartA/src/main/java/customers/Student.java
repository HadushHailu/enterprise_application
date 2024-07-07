package customers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Student {
    @Id
    private Long studentNumber;
    private String name;
    private String phone;
    private Address address;

    private List<Grade> grades;

    public Student(Long studentNumber, String name, String phone, Address address) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber=" + studentNumber +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                ", grades=" + grades +
                '}';
    }
}
