package db.schulung.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue
    Long id;

    String name;

    public Student(String name) {
        this.name = name;
    }
}
