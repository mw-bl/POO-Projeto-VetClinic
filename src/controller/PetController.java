package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import models.Tutor;
import models.Pet;

public class PetController {
    // CRUD
    public static void insertData(Connection conn, Pet pet) throws SQLException {
        String sql = "INSERT INTO Pet (nome, especie, raca, idade, tutor_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pet.getNome());
            pstmt.setString(2, pet.getEspecie());
            pstmt.setString(3, pet.getRaca());
            pstmt.setInt(4, pet.getIdade());
            pstmt.setInt(5, pet.getTutor().getId());
            pstmt.executeUpdate();
            System.out.println("Pet cadastrado com sucesso.");
        }
    }
    public static ArrayList<Pet> selectData(Connection conn) throws SQLException {
        ArrayList<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM Pet";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setNome(rs.getString("nome"));
                pet.setEspecie(rs.getString("especie"));
                pet.setRaca(rs.getString("raca"));
                pet.setIdade(rs.getInt("idade"));
                        
                Tutor tutor = new Tutor();
                tutor.setId(rs.getInt("tutor_id"));
                pet.setTutor(tutor);
        
                pets.add(pet);
            }
        }
        return pets;
    }
        
    public static void updateData(Connection conn, int petId, Pet novoPet) throws SQLException {
        String sql = "UPDATE Pet SET nome = ?, especie = ?, raca = ?, idade = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoPet.getNome());
            pstmt.setString(2, novoPet.getEspecie());
            pstmt.setString(3, novoPet.getRaca());
            pstmt.setInt(4, novoPet.getIdade());
            pstmt.setInt(5, novoPet.getId());
            pstmt.executeUpdate();
            System.out.println("Pet atualizado com sucesso.");
        }
    }
    
        
    public static void deleteData(Connection conn, int petId) throws SQLException {
        String sql = "DELETE FROM Pet WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, petId);
            pstmt.executeUpdate();
            System.out.println("Pet excluído com sucesso.");
        }
    }

    // Método para selecionar os pets pelo tutor
    public static ArrayList<Pet> selectPetsByTutor(Connection conn, Tutor tutor) throws SQLException {
        String sql = "SELECT * FROM Pet WHERE tutor_id = ?";
        ArrayList<Pet> pets = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tutor.getId());

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Pet pet = new Pet();
                    pet.setId(rs.getInt("id"));
                    pet.setNome(rs.getString("nome"));
                    pet.setEspecie(rs.getString("especie"));
                    pet.setRaca(rs.getString("raca"));
                    pet.setIdade(rs.getInt("idade"));
                    pet.setTutor(tutor);  // Associa o tutor ao pet
                    pets.add(pet);
                }
            }
        }
        return pets;
    }

    // Método para selecionar um pet pelo ID
    public static Pet getPetById(Connection conn, int petId) throws SQLException {
        String sql = "SELECT * FROM Pet WHERE id = ?";
        Pet pet = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, petId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    pet = new Pet();
                    pet.setId(rs.getInt("id"));
                    pet.setNome(rs.getString("nome"));
                    pet.setEspecie(rs.getString("especie"));
                    pet.setRaca(rs.getString("raca"));
                    pet.setIdade(rs.getInt("idade"));
                }
            }
        }
        return pet;
    }
}
        