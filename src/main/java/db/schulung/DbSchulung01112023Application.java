package db.schulung;

import db.schulung.hospital.Doctor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class DbSchulung01112023Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(DbSchulung01112023Application.class, args);

		ConfigurableEnvironment environment = context.getEnvironment();
		System.out.println(environment.getProperty("hallo"));

		Doctor doctor = context.getBean(Doctor.class);
		System.out.println(doctor.assist());
	}

}
