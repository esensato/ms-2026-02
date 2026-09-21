package aula.microservicos.disciplina.restful;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "aluno", url = "http://localhost:8081")
public interface AlunoClienteFeign {

    @GetMapping("/aluno/{id}")
    public ResponseEntity<String> obterAluno(@PathVariable Integer id);

}
