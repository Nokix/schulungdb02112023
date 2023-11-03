package db.schulung.repo;

import db.schulung.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepoTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private StudentRepo studentRepo;

    @BeforeEach
    void setUp() {
        entityManager.persist(new Student("Karl"));
        entityManager.persist(new Student("Berta"));
        entityManager.persist(new Student("Alex"));
    }

    @Test
    void testFindByNameContains() {
        List<Student> result = studentRepo.findByNameContains("e");

        List<Student> expected = List.of(
                new Student(2L, "Berta"),
                new Student(3L,"Alex"));

        assertEquals(expected.size(), result.size());
        assertIterableEquals(expected, result);
    }
}