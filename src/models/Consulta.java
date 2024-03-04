package models;

import java.util.Date;

public class Consulta {
    private int id;
    private Date dataHora;
    private Veterinario veterinario;  
    private Pet pet; 
    private String notas;

    public Consulta(Date dataHora, Veterinario veterinario, Pet pet, String notas) {
        this.dataHora = dataHora;
        this.veterinario = veterinario;
        this.pet = pet;
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
    public Date getDataHora() {
        return dataHora;
    }
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    // Getter/Setter - Veterinario
    public Veterinario getVeterinario() {
        return veterinario;
    }
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    // Getter/Setter - Pet
    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    // Getter/Setter - Notas
    public String getNotas() {
        return notas;
    }
    public void setNotas(String notas) {
        this.notas = notas;
    }
}