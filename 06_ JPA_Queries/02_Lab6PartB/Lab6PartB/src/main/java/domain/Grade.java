package domain;

import jakarta.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Course course;

    public Grade() {
    }

    @Override
    public String toString() {
        return "Grade{" +
                "name='" + name + '\'' +
                '}';
    }

    public Grade(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }
}
