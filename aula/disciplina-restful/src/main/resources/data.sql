DROP TABLE IF EXISTS tab_disciplina;

CREATE TABLE tab_disciplina (
    id_disciplina INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    creditos INTEGER);

INSERT INTO tab_disciplina(nome, creditos) VALUES ('Estrutura de Dados', 10);

INSERT INTO tab_disciplina(nome, creditos) VALUES ('Gestão de Projetos', 15);