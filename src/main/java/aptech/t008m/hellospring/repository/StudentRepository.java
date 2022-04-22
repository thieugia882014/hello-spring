package aptech.t008m.hellospring.repository;

import aptech.t008m.hellospring.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
