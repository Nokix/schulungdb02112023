package db.schulung.rest;

import db.schulung.entity.Student;
import db.schulung.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("students")
    public List<Student> getAllStudent() {
        return studentService.findAll();
    }

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Student> createRandomStudent(
            @RequestParam(value = "n") int amount) {
        return studentService.createRandomStudents(amount);
    }
}
