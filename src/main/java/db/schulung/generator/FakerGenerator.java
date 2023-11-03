package db.schulung.generator;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FakerGenerator implements Generator{

    @Autowired
    private Faker faker;

    @Override
    public String name() {
        return faker.name().firstName();
    }
}
