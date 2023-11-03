package db.schulung.hospital;

import lombok.Setter;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Doctor {
//    @Autowired
    private String name;
//    @Autowired
    private Nurse nurse;

    public Doctor(@Value("Greta") String name, Nurse nurse) {
        this.name = name;
        this.nurse = nurse;
    }

    public String assist() {
        return "Doctor " + this.name + " is helping. " + nurse.assist();
    }
}
