package db.schulung.hospital;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class BeanConfig {

    @Bean
    @Profile("test")
    public String getName() {
        return "Elisabeth";
    }

    @Bean
    @Profile("prod")
    public String getBaseUrl() {
        return "Hans";
    }

    @Bean("germanName")
    @ConditionalOnMissingBean
    public String getDoctorName() {
        return "Allerweltsname";
    }

    @Bean
    public String firstName() {
        return "Dionysios";
    }

    @Bean
    public String lastName() {
        return "Basdanis";
    }

    @Bean
    public String name(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

//    @Bean
//    @Primary
    public Helper getHelper() {
        return new Nurse();
    }

}
