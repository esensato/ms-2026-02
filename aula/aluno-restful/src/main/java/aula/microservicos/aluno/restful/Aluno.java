package aula.microservicos.aluno.restful;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Aluno {

    @NotNull(message = "O campo id não pode ser nulo")
    public Integer id;
    @Size(min = 10, max = 30, message = "Nome deve ter entre 10 e 30 caracteres")
    public String nome;
    public String curso;
    @Pattern(regexp = "/^(55)?(?:([1-9]{2})?)(\\d{4,5})(\\d{4})$/;", message = "Número de telefone inválido")
    public String telefone;
    public Date dataNascimento;

}
