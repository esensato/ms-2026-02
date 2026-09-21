package aula.microservicos.disciplina.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DisciplinaRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisciplinaRestfulApplication.class, args);
	}

}
