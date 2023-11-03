package db.schulung.repo;

import db.schulung.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByNameContains(String name);
}
