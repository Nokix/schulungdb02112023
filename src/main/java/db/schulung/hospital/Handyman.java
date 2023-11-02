package db.schulung.hospital;

import org.springframework.stereotype.Component;

@Component
public class Handyman implements Helper{
    @Override
    public String assist() {
        return "Handyman is helping";
    }
}
