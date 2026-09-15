package aula.microservicos.aluno.restful;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoRepository repo;

    // Injeção de dependência do AlunoRepository
    public AlunoController(AlunoRepository repo) {
        this.repo = repo;
    }

    // GET - http://localhost:8080/aluno
    // obter a lista (Iterable) de todos os alunos cadastrados
    @GetMapping
    public ResponseEntity<Iterable<Aluno>> getAluno() {

        Iterable<Aluno> alunos = this.repo.findAll();
        return new ResponseEntity<Iterable<Aluno>>(alunos, HttpStatus.OK);
    }

    // GET - http://localhost:8080/aluno/turma/{turma}
    // obter a lista (Iterable) de todos os alunos de uma turma
    @GetMapping("/turma/{turma}")
    public ResponseEntity<Iterable<Aluno>> getAlunoTurma(@PathVariable String turma) {

        Iterable<Aluno> alunos = this.repo.findByTurma(turma);
        return new ResponseEntity<Iterable<Aluno>>(alunos, HttpStatus.OK);
    }

    // http://localhost:8080/aluno/1
    // retorna aluno com id = 1
    @GetMapping("{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Integer id) {

        // pode ser que o aluno com o id informado não exista...
        Optional<Aluno> resultado = this.repo.findById(id);

        // se retornou um aluno...
        if (resultado.isPresent()) {
            return new ResponseEntity<Aluno>(resultado.get(), HttpStatus.OK);
        } else {
            throw new AlunoInexistenteException();
        }
    }

    // POST - criar um novo aluno
    @PostMapping
    public ResponseEntity<Aluno> cadastro(@Valid @RequestBody Aluno aluno) {

        repo.save(aluno);
        // if (aluno.nome.length() > 30) {
        // return new ResponseEntity<Aluno>(new Aluno(), HttpStatus.BAD_REQUEST);
        // } else {
        return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
        // }

    }

    // remover um aluno pelo id
    // DELETE - http://localhost:8080/aluno/1
    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {

        // pode ser que o aluno com o id informado não exista...
        boolean existe = this.repo.existsById(id);

        // se retornou um aluno...
        if (existe) {
            this.repo.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            throw new AlunoInexistenteException();
        }
    }

    // Atualizar os dados de um aluno pelo id
    // PUT - http://localhost:8080/aluno/1
    @PutMapping("{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Integer id, @Valid @RequestBody Aluno aluno) {
        // pode ser que o aluno com o id informado não exista...
        boolean existe = this.repo.existsById(id);

        // se existe então atualiza
        if (existe) {
            // se existir um id definido então é UPDATE, caso contrário, INSERT
            aluno.id = id;
            this.repo.save(aluno);
            return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
        } else {
            throw new AlunoInexistenteException();
        }

    }

}
