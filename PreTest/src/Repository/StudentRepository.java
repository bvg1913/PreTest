package Repository;

import java.beans.Statement;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asb.example.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Statement findByName(String studentName);

}