package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import models.Veterinario;

public class VeterinarioController {
    // CRUD
    public static void insertData(Connection conn, Veterinario veterinario) throws SQLException {
        String sql = "INSERT INTO Veterinario (nome, especialidade, telefone) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, veterinario.getNome());
            pstmt.setString(2, veterinario.getEspecialidade());
            pstmt.setString(3, veterinario.getTelefone());
            pstmt.executeUpdate();
        }   catch (SQLException e) {
            throw new SQLException("Erro ao inserir os dados do veterinario", e);
        }
    }

    public static ArrayList<Veterinario> selectData(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Veterinario";
        ArrayList<Veterinario> listVeterinarios = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Veterinario veterinario = new Veterinario();
                veterinario.setId(rs.getInt("id"));
                veterinario.setNome(rs.getString("nome"));
                veterinario.setEspecialidade(rs.getString("especialidade"));
                veterinario.setTelefone(rs.getString("telefone"));
                listVeterinarios.add(veterinario);
            }
        }   catch (SQLException e) {
            throw new SQLException("Erro ao selecionar os dados do veterinario", e);
        }
        return listVeterinarios;
    }

    public static void updateData(Connection conn, int veterinarioId, Veterinario veterinario) throws SQLException {
        String sql = "UPDATE Veterinario SET nome = ?, especialidade = ?, telefone = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, veterinario.getNome());
            pstmt.setString(2, veterinario.getEspecialidade());
            pstmt.setString(3, veterinario.getTelefone());
            pstmt.setInt(4, veterinario.getId());
            pstmt.executeUpdate();
        }   catch (SQLException e) {
            throw new SQLException("Erro ao atualizar os dados do veterinario", e);
        }
    }

    public static void deleteData(Connection conn, int veterinarioId) throws SQLException {
        String sql = "DELETE FROM Veterinario WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, veterinarioId);
            pstmt.executeUpdate();
        }   catch (SQLException e) {
            throw new SQLException("Erro ao deletar os dados do veterinario", e);
        }
    }
}
