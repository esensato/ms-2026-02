package aula.microservicos.aluno.restful;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

@Component
public class AlunoMetrica {

    AlunoMetrica(MeterRegistry registry) {
        registry.counter("alunos.metrica", Tags.of("cadastros", "10"));
    }

}
