DROP TABLE IF EXISTS tab_aluno;

CREATE TABLE tab_aluno (
    id_aluno INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    turma VARCHAR(10) NOT NULL,
    curso VARCHAR(50) DEFAULT NULL
);

insert into tab_aluno(nome, turma, curso)
values ('Edson A. Sensato', '3AB', 'CDN');
