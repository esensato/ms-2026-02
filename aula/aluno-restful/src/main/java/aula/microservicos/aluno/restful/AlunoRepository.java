package aula.microservicos.aluno.restful;

import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

    // localizar todos os alunos por turma
    public Iterable<Aluno> findByTurma(String turma);

}
