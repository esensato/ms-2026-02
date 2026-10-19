package aula.microservicos.aluno.restful;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class AlunoMetrica {

    private final Counter alunosCriados;

    public AlunoMetrica(MeterRegistry registry) {
        alunosCriados = Counter.builder("alunos.criados")
                .description("Quantidade de alunos criados")
                .register(registry);
    }

    public void alunoCriado() {
        alunosCriados.increment();
    }

}
