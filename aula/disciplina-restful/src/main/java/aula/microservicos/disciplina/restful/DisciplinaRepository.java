package aula.microservicos.disciplina.restful;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "disciplina")
public interface DisciplinaRepository extends CrudRepository<DisciplinaEntity, Integer> {

}
