package models;

public class Consulta {
    private int id;
    private String dataHora;
    private String nomeVeterinario;  
    private String nomePet; 
    private String notas;

    public Consulta() {
    }

    public Consulta(String dataHora, String nomeVeterinario, String nomePet, String notas) {
        this.dataHora = dataHora;
        this.nomeVeterinario = nomeVeterinario;
        this.nomePet = nomePet;
        this.notas = notas;
    }

    // Getter/Setter - ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter/Setter - Data/Hora
    public String getDataHora() {
        return dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    // Getter/Setter - Veterinario
    public String getNomeVeterinario() {
        return nomeVeterinario;
    }
    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }

    // Getter/Setter - Pet
    public String getNomePet() {
        return nomePet;
    }
    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    // Getter/Setter - Notas
    public String getNotas() {
        return notas;
    }
    public void setNotas(String notas) {
        this.notas = notas;
    }
}
