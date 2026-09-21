package aula.microservicos.disciplina.restful;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class IntegracaoAluno {

    private AlunoClienteFeign client;

    public IntegracaoAluno(AlunoClienteFeign client) {
        this.client = client;
    }

    @GetMapping("/{idAluno}")
    public ResponseEntity<String> obterAluno(@PathVariable Integer idAluno) {
        return new ResponseEntity<String>(client.obterAluno(idAluno).getBody(), HttpStatus.OK);
    }
}
