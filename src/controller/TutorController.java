package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import models.Tutor;

public class TutorController {
    // CRUD
    public static void insertData(Connection conn, Tutor tutor) throws SQLException {
        String sql = "INSERT INTO Tutor (nome, telefone, email, dataNascimento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tutor.getNome());
            pstmt.setString(2, tutor.getTelefone());
            pstmt.setString(3, tutor.getEmail());
            pstmt.setString(4, tutor.getDataNascimento());
            pstmt.executeUpdate();
            System.out.println("Tutor cadastrado com sucesso.");
        }
    }

    public static ArrayList<Tutor> selectData(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Tutor";
        ArrayList<Tutor> listTutors = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tutor tutor = new Tutor();
                tutor.setId(rs.getInt("id"));
                tutor.setNome(rs.getString("nome"));
                tutor.setTelefone(rs.getString("telefone"));
                tutor.setEmail(rs.getString("email"));
                tutor.setDataNascimento(rs.getString("dataNascimento"));
                listTutors.add(tutor);
            }
        }
        return listTutors;
    }

    public static void updateData(Connection conn, int tutorId, Tutor novoTutor) throws SQLException {
        String sql = "UPDATE Tutor SET nome = ?, telefone = ?, email = ?, dataNascimento = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoTutor.getNome());
            pstmt.setString(2, novoTutor.getTelefone());
            pstmt.setString(3, novoTutor.getEmail());
            pstmt.setString(4, novoTutor.getDataNascimento());
            pstmt.setInt(5, tutorId);  // Corrigido para o índice 5
            pstmt.executeUpdate();
            System.out.println("Dados do tutor atualizados com sucesso.");
        }
    }
    
    public static void deleteData(Connection conn, int tutorId) throws SQLException {
        String sql = "DELETE FROM Tutor WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tutorId);
            pstmt.executeUpdate();
            System.out.println("Tutor excluído com sucesso.");
        }
    }
}
