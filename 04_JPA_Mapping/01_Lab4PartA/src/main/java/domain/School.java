package domain;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class School {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @MapKey(name="studentID")
    private Map<String, Student> studentMap = new HashMap<>();

    public School() {
    }

    public School(String name, Student student) {
        studentMap.put(student.getFirstName(), student);
        this.name = name;
    }

    public void setStudentMap(Student student) {
        studentMap.put(student.getFirstName(), student);
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", studentMap=" + studentMap +
                '}';
    }
}
