package db.schulung.service;

import com.github.javafaker.Faker;
import db.schulung.entity.Student;
import db.schulung.generator.Generator;
import db.schulung.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private Generator generator;

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public List<Student> createRandomStudents(int amount) {
        return Stream
                .generate(generator::name)
                .limit(amount)
                .map(Student::new)
                .map(studentRepo::save)
                .collect(Collectors.toList());
    }
}
