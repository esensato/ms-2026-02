package aula.microservicos.calculadora.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/calcular")
public class CalculadoraController {

    // Spring faz a injeção de dependência
    Calculadora calculadora;

    public CalculadoraController(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    @GetMapping("/{operacao}")
    public float calcular(@PathVariable String operacao, Float v1, Float v2) {
        return calculadora.calcular(operacao, v1, v2);
    }
}
