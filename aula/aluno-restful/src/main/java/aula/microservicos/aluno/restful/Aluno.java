package aula.microservicos.aluno.restful;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(name = "Aluno", description = "Representa um aluno")
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

    @Schema(name = "turma", description = "Turma do aluno", example = "T001")
    public String turma;

}
