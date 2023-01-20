CREATE TABLE
    public.person (
                      id bigserial NOT NULL,
                      address character varying(80) NOT NULL,
                      first_name character varying(80) NOT NULL,
                      gender character varying(80) NOT NULL,
                      last_name character varying(80) NOT NULL
);

ALTER TABLE
    public.person
    ADD
        CONSTRAINT person_pkey PRIMARY KEY (id)

INSERT INTO person (address, first_name, gender, last_name) VALUES ('Rua dos Bobos, 0', 'João', 'Male', 'Silva');
INSERT INTO person (address, first_name, gender, last_name) VALUES ('Av. Paulista, 1000', 'Maria', 'Female', 'Santos');
INSERT INTO person (address, first_name, gender, last_name) VALUES ('Rua das Flores, 123', 'Carlos', 'Male', 'Gomes');
INSERT INTO person (address, first_name, gender, last_name) VALUES ('Rua da Paz, 789', 'Ana', 'Female', 'Lima');
INSERT INTO person (address, first_name, gender, last_name) VALUES ('Av. Brasil, 1234', 'José', 'Male', 'Pereira');
INSERT INTO person (address, first_name, gender, last_name) VALUES ('Rua do Sol, 567', 'Lucia', 'Female', 'Rodrigues');
INSERT INTO person (address, first_name, gender, last_name) VALUES ('Rua das Estrelas, 890', 'Marcos', 'Male', 'Martins');
INSERT INTO person (address, first_name, gender, last_name) VALUES ('Av. dos Sonhos, 321', 'Julia', 'Female', 'Souza');
INSERT INTO person (address, first_name, gender, last_name) VALUES ('Rua da Felicidade,654', 'Pedro', 'Make', 'Almeida');
INSERT INTO person (address, first_name, gender, last_name) VALUES ('Rua do destino,987', 'Carla', 'Female', 'Castro');