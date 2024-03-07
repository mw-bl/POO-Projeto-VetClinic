package models;

public class Consulta {
    private int id;
    private String dataHora;
    private int veterinarioId;  
    private int petId; 
    private String notas;

    public Consulta() {
    }

    public Consulta(String dataHora, int veterinarioId, int petId, String notas) {
        this.dataHora = dataHora;
        this.veterinarioId = veterinarioId;
        this.petId = petId;
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
    public int getVeterinarioId() {
        return veterinarioId;
    }
    public void setVeterinarioId(int veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    // Getter/Setter - Pet
    public int getPetId() {
        return petId;
    }
    public void setPetId(int petId) {
        this.petId = petId;
    }

    // Getter/Setter - Notas
    public String getNotas() {
        return notas;
    }
    public void setNotas(String notas) {
        this.notas = notas;
    }
}
