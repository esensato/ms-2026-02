package aula.microservicos.aluno.restful;

import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

}
