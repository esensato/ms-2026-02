# ms-2026-02 - Microservices Development

## Instalação

- [Spring Boot para VS Code](https://code.visualstudio.com/docs/java/java-spring-boot)

## Injeção de Dependência

- Calculadora **monolítico**
```java
public class CalculadoraMonolitica {

    public void calcular(String[] args) {
        String operacao = args[0];
        Integer n1 = Integer.parseInt(args[1]);
        Integer n2 = Integer.parseInt(args[2]);

        System.out.println("\n\n------------ CALCULADORA MONOLITICA ------------");
        System.out.print("Resultado: ");

        if (operacao.equals("soma")) {
            System.out.println(n1 + n2);
        } else if (operacao.equals("subtracao")) {
            System.out.println(n1 - n2);
        } else if (operacao.equals("divisao")) {
            System.out.println(n1 / n2);
        } else if (operacao.equals("multiplicacao")) {
            System.out.println(n1 * n2);
        } else {
            System.out.println("Operacao invalida: " + operacao);
        }

        System.out.println();

    }

    public static void main(String[] args) {

        // Calculadora instanciada pelo usuário, dono do fluxo principal
        CalculadoraMonolitica c = new CalculadoraMonolitica();
        c.calcular(args);

    }
}
```
- Calculadora com **Spring**
- Criar uma interface para abstrair as operações
```java
public interface Operacao {

    String getNome();

    float executar(float v1, float v2);
}
```
- Implementar as operações como componentes (Soma, Multiplicação, etc...)
```java
import org.springframework.stereotype.Component;

@Component
public class Soma implements Operacao {

    @Override
    public String getNome() {
        return "soma";
    }

    @Override
    public float executar(float v1, float v2) {
        return v1 + v2;
    }

}
```
- Implementar a calculadora
```java
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Calculadora {

    private final List<Operacao> operacoes;

    public Calculadora(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public float calcular(String operacao, float v1, float v2) {

        System.out.println("Operacao: " + operacoes);

        for (Operacao op : operacoes) {
            if (op.getNome().equals(operacao))
                return op.executar(v1, v2);
        }

        return 0;
    }
}
```
- Finalmente, a aplicação principal
```java

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final Calculadora calculadora;

	public DemoApplication(Calculadora calculadora) {
		this.calculadora = calculadora;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		String operacao = args[0];
		Integer a = Integer.parseInt(args[1]);
		Integer b = Integer.parseInt(args[2]);

		System.out.println(calculadora.calcular(operacao, a, b));

	}

}
```


