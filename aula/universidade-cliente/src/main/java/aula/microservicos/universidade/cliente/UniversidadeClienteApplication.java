package aula.microservicos.universidade.cliente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootApplication
public class UniversidadeClienteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniversidadeClienteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestClient restClient = RestClient.create();

		ResponseEntity<Void> result2 = restClient.post()
				.uri("http://localhost:8081/aluno")
				.contentType(APPLICATION_JSON)
				.body("{\"nome\":\"Aluno JSON\", \"curso\": \"CDN\", \"turma\":\"XPTO4\"}")
				.retrieve()
				.toBodilessEntity();
		System.out.println("Status: " + result2.getStatusCode());

		ResponseEntity<String> result = restClient.get()
				.uri("http://localhost:8081/aluno")
				.retrieve()
				.toEntity(String.class);
		System.out.println("Status: " + result.getStatusCode());
		System.out.println("Headers: " + result.getHeaders());
		System.out.println("Conteudo: " + result.getBody());
	}

}
