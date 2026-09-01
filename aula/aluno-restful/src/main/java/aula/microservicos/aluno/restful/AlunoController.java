package aula.microservicos.aluno.restful;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoRepository repo;

    public AlunoController(AlunoRepository repo) {
        this.repo = repo;
    }

    // http://localhost:8080/aluno/100 -> retorna aluno com id = 100
    @GetMapping("{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Integer id) {
        Aluno teste = new Aluno();
        teste.id = 100;
        teste.nome = "Joao da Silva";
        teste.curso = "CDN";

        if (id == 100) {
            return new ResponseEntity<Aluno>(teste, HttpStatus.OK);
        } else {
            // return new ResponseEntity<Aluno>(new Aluno(), HttpStatus.NOT_FOUND);
            throw new AlunoInexistenteException();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Aluno> cadastro(@Valid @RequestBody Aluno aluno) {

        repo.save(aluno);
        // if (aluno.nome.length() > 30) {
        // return new ResponseEntity<Aluno>(new Aluno(), HttpStatus.BAD_REQUEST);
        // } else {
        return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
        // }

    }

}
