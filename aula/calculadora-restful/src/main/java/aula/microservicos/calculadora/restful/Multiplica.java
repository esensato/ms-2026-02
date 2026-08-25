package aula.microservicos.calculadora.restful;

import org.springframework.stereotype.Component;

@Component
public class Multiplica implements Operacao {

    @Override
    public String getNome() {
        return "multiplica";
    }

    @Override
    public float executar(float v1, float v2) {
        return v1 * v2;
    }

}
