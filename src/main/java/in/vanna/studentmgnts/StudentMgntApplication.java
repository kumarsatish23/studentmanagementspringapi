package in.vanna.studentmgnts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class StudentMgntApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMgntApplication.class, args);
	}

}
