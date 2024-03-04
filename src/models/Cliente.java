package models;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;

    public Cliente() {
    }

    public Cliente (int id, String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    // Getter/Setter - ID
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

    // Getter/Setter - Telefone
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
