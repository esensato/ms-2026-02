package aula.microservicos.calculadora.restful;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Calculadora {

    private final List<Operacao> operacoes;

    public Calculadora(List<Operacao> operacoes) {
        System.out.println(operacoes);
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
