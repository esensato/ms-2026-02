package aula.microservicos.calculadora.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/calcular")
// endpoint http://localhost:8080/calcular
public class CalculadoraController {

    // geração de logs no terminal
    private static final Logger logger = LoggerFactory.getLogger(CalculadoraController.class);
    // Spring faz a injeção de dependência
    Calculadora calculadora;

    public CalculadoraController(Calculadora calculadora) {
        this.calculadora = calculadora;
    }
    // GET http://localhost:8080/calcular/soma?v1=10&v2=20
    // GET http://localhost:8080/calcular/subtrair?v1=10&v2=30
    // GET http://localhost:8080/calcular/multiplica?v1=10&v2=5
    @GetMapping("/{operacao}")
    public ResponseEntity<Float> calcular(@PathVariable String operacao, Float v1, Float v2) {
        logger.debug("Operacao solicitada!");
        Float resultado = calculadora.calcular(operacao, v1, v2);
        return new ResponseEntity<Float>(resultado,HttpStatus.OK);

    }
}
