package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByDepartmentName(String name);
    List<Student> findByGradesCourseName(String name);

    @Query("SELECT s FROM Student s JOIN FETCH s.department d WHERE d.name = :name")
    List<Student> findDepartmentNameEager(@Param("name") String name);

    @Query("SELECT DISTINCT s FROM Student s JOIN FETCH s.grades g JOIN FETCH g.course c WHERE c.name = :name")
    List<Student> findGradesCourseNameEager(@Param("name") String name);


}
