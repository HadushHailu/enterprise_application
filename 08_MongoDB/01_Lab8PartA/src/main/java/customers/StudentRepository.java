package customers;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, Long> {
    public List<Student> findByName(String name);
    public List<Student> findByPhone(String phone);
    public List<Student> findByAddressCity(String city);

    public List<Student> findByGradesCourseName(String courseName);
    public List<Student> findByGradesGradeAndGradesCourseName(String grade, String courseName);
}
