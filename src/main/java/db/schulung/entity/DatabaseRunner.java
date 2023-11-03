package db.schulung.entity;

import db.schulung.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseRunner implements CommandLineRunner {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public void run(String... args) throws Exception {
        studentRepo.save(new Student("Nico"));
        studentRepo.save(new Student("Renate"));
        studentRepo.save(new Student("Anisa"));

        List<Student> allStudents = studentRepo.findByNameContains("a");
        allStudents.forEach(System.out::println);
    }
}
