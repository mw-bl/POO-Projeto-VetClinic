CREATE DATABASE VetClinic;
USE VetClinic;

-- Tabela Tutores
CREATE TABLE Tutor (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(15),
    email VARCHAR(200),
    dataNascimento VARCHAR(20) NOT NULL
);

-- Tabela Pets
CREATE TABLE Pet (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    especie VARCHAR(50),
    raca VARCHAR(50),
    idade INT,
    tutor_id INT,
    FOREIGN KEY (tutor_id) REFERENCES Tutor(id)
);

-- Tabela Veterinários
CREATE TABLE Veterinario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    especialidade VARCHAR(50),
    telefone VARCHAR(15)
);

-- Tabela Consultas
CREATE TABLE Consulta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dataHora VARCHAR(20) NOT NULL,
    veterinario_id INT,
    pet_id INT,
    notas TEXT,
    FOREIGN KEY (veterinario_id) REFERENCES Veterinario(id),
    FOREIGN KEY (pet_id) REFERENCES Pet(id)
);
