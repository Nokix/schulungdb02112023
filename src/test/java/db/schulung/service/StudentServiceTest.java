package db.schulung.service;

import db.schulung.entity.Student;
import db.schulung.generator.Generator;
import db.schulung.repo.StudentRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    StudentService studentService;

    @MockBean
    Generator generator;

    @MockBean
    StudentRepo studentRepo;

    @Test
    void createRandomStudentsTest() {
        Mockito.when(generator.name())
                .thenReturn("Daniel")
                .thenReturn("Georg")
                .thenReturn("Greta");

        Mockito.when(studentRepo.save(Mockito.any()))
                .thenAnswer(m -> m.getArgument(0));

        List<Student> randomStudents = studentService.createRandomStudents(3);
        List<String> names = randomStudents.stream().map(Student::getName).collect(Collectors.toList());
        assertIterableEquals(List.of("Daniel", "Georg", "Greta"), names);
    }
}