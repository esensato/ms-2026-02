DROP TABLE IF EXISTS tab_aluno;

CREATE TABLE tab_aluno (
    id_aluno INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    turma VARCHAR(10) NOT NULL,
    curso VARCHAR(50) DEFAULT NULL
);

insert into tab_aluno(nome, turma, curso)
values ('Edson A. Sensato', '3AB', 'CDN');

insert into tab_aluno(nome, turma, curso)
values ('Maria dos Santos', '3CD', 'CDN');

create table users(username varchar(50) not null primary key,password varchar(500) not null, enabled boolean not null);

create table authorities (username varchar(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));

create unique index ix_auth_username on authorities (username,authority);

insert into users (username, password, enabled) values ('db', '{noop}db', true);

insert into authorities (username, authority) values ('db', 'USER');

insert into users (username, password, enabled) values ('prof', '{noop}prof', true);

insert into authorities (username, authority) values ('prof', 'ROLE_PROFESSOR');