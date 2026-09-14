package aula.microservicos.aluno.restful;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "TAB_ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALUNO")
    public Integer id;

    @Size(min = 10, max = 30, message = "Nome deve ter entre 10 e 30 caracteres")
    public String nome;
    @NotNull(message = "O campo curso não pode ser nulo")
    public String curso;

    public String turma;

}
