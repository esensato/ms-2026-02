package aula.spring.calculadora;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculadoraApplication implements CommandLineRunner {

	private final Calculadora calculadora;

	public CalculadoraApplication(Calculadora calculadora) {
		this.calculadora = calculadora;
	}

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraApplication.class, args);
	}

	@Override
	public void run(String... args) {

		String operacao = args[0];
		Integer a = Integer.parseInt(args[1]);
		Integer b = Integer.parseInt(args[2]);

		System.out.println(calculadora.calcular(operacao, a, b));

	}

}