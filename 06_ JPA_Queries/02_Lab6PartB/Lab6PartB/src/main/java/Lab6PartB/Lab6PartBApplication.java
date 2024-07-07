package Lab6PartB;

import domain.Course;
import domain.Department;
import domain.Grade;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.StudentRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Lab6PartBApplication implements CommandLineRunner {
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {

		SpringApplication.run(Lab6PartBApplication.class, args);
	}

	public void run(String... args) throws Exception{
		Course course1 = new Course("EA");
		Course course2 = new Course("SE");
		Course course3 = new Course("MPP");
		Course course4 = new Course("FPP");
		Course course5 = new Course("ML");
		Course course6 = new Course("ASD");

		Grade grade1 = new Grade("A", course1);
		Grade grade2 = new Grade("B", course2);
		Grade grade3 = new Grade("A+", course3);
		Grade grade4 = new Grade("A-", course4);
		Grade grade5 = new Grade("C", course5);
		Grade grade6 = new Grade("B+", course6);

		Department department1 = new Department("ComPro");
		Department department2 = new Department("MSD");

		Student student1 = new Student("Haudsh", 8976, department1, grade1);
		student1.addGrades(grade2);
		student1.addGrades(grade3);

		Student student2 = new Student("Tedros", 450, department2, grade4);
		student2.addGrades(grade5);
		student2.addGrades(grade6);

		studentRepository.save(student1);
		studentRepository.save(student2);

		// ========= Then perform the following queries using method names: ==========
		//• Get all students from a certain department
//		studentRepository.findByDepartmentName("MSD").stream()
//				.forEach(p->{
//					System.out.println(p);
//					System.out.println(p.getDepartment());
//				});

		//• Get all students who took a course with a certain name.
//		studentRepository.findByGradesCourseName("MPP").stream()
//				.forEach(p->{
//					System.out.println(p);
//					System.out.println(p.getGrades());
//				});

		// ======= Then perform the following queries using @Query: ===========
		//• Get all students from a certain department
		studentRepository.findDepartmentNameEager("MSD").stream()
				.forEach(p->{
					System.out.println(p);
					System.out.println(p.getDepartment());
				});
		//• Get all students who took a course with a certain name.
		studentRepository.findGradesCourseNameEager("MPP").stream()
		.forEach(p->{
			System.out.println(p);
			System.out.println(p.getGrades());
		});

	}

}
