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
public class Doctor implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println("this bean is named: " + s);
    }
//    @Autowired

    private String name;
//    @Autowired
//    @Qualifier("handyman")

    private Helper helper;


    public Doctor(String name, @Value("#{beanConfig.getHelper()}") Helper helper) {
        this.name = name;
        this.helper = helper;
    }

    public String assist() {
        return "Doctor " + this.name + " is helping. " + helper.assist();
    }
//    @Autowired

    public void setName(String name) {
        this.name = name;
    }
//    @Autowired

    public void setHelper(@Qualifier("handyman") Helper helper) {
        this.helper = helper;
    }

    @PostConstruct
    public void afterSetup() {
        System.out.println("I am ready!");
    }

    @PreDestroy
    public void timeToLeave() {
        System.out.println("Good bye cruel world...");
    }
}
