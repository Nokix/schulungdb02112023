package db.schulung.hospital;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig2 {

    @Bean
    String getName() {
        return "Dios";
    }

    @Bean
    @Primary
    String getName2() {
        return "Renate";
    }
}
