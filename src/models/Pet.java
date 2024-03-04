package models;

public class Pet {
    private int id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private Cliente tutor;

    public Pet() {
    }

    public Pet(String nome, String especie, String raca, int idade, Cliente tutor) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.tutor = tutor;
    }

    // Getter/Setters - ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter/Setter - Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter/Setter - Especie
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    // Getter/Setter - Raça
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }

    // Getter/Setter - Idade
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Getter/Setter - Cliente tutor
    public Cliente getTutor() {
        return tutor;
    }
    public void setTutor(Cliente tutor) {
        this.tutor = tutor;
    }
}
