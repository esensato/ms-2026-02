package aula.spring.calculadora;

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
