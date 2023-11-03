package db.schulung.rest;

import db.schulung.entity.Student;
import db.schulung.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("students")
    public List<Student> getAllStudent() {
        return studentService.findAll();
    }

    @PostMapping("students/create")
    public List<Student> createRandomStudent(
            @RequestParam(value = "n") int amount) {
        return studentService.createRandomStudents(amount);
    }
}
