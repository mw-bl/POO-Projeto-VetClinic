package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import models.Consulta;

public class ConsultaController {
    // CRUD
    public static void insertData(Connection conn, Consulta consulta) throws SQLException {
        String sql = "INSERT INTO Consulta (dataHora, veterinario_id, pet_id, notas) VALUES (STR_TO_DATE(?, '%Y-%m-%d %H:%i:%s'), ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, consulta.getDataHora());
            pstmt.setInt(2, consulta.getVeterinarioId());
            pstmt.setInt(3, consulta.getPetId());
            pstmt.setString(4, consulta.getNotas());
            pstmt.executeUpdate();
            System.out.println("Consulta agendada com sucesso.");
        }
    }

    public static ArrayList<Consulta> selectData(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Consulta";
        ArrayList<Consulta> listConsultas = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Consulta consulta = new Consulta();
                    consulta.setId(rs.getInt("id"));
                    consulta.setDataHora(rs.getString("DataHora"));
                    // Preencha as referências para Veterinário e Pet conforme necessário
                    consulta.setNotas(rs.getString("notas"));
                    listConsultas.add(consulta);
                }
        }
        return listConsultas;
    }

    public static void updateData(Connection conn, Consulta consulta) throws SQLException {
        String sql = "UPDATE Consulta SET dataHora = ?, veterinario_id = ?, pet_id = ?, notas = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, consulta.getDataHora());
            pstmt.setInt(2, consulta.getVeterinarioId());
            pstmt.setInt(3, consulta.getPetId());
            pstmt.setString(4, consulta.getNotas());
            pstmt.setInt(5, consulta.getId());
            pstmt.executeUpdate();
            System.out.println("Consulta atualizada com sucesso.");
        }
    }

    public static void deleteData(Connection conn, int consultaId) throws SQLException {
        String sql = "DELETE FROM Consulta WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, consultaId);
            pstmt.executeUpdate();
            System.out.println("Consulta excluída com sucesso.");
        }
    }
}
