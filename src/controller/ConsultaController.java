package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Consulta;

public class ConsultaController {
    public static void insertData(Connection conn, Consulta consulta) throws SQLException {
        String sql = "INSERT INTO Consulta (dataHora, veterinario_id, pet_id, notas) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, consulta.getDataHora());
            pstmt.setInt(2, consulta.getVeterinario().getId());
            pstmt.setInt(3, consulta.getPet().getId());
            pstmt.setString(4, consulta.getNotas());
            pstmt.executeUpdate();
            System.out.println("Consulta agendada com sucesso.");
        }
    }

    public static ArrayList selectData(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Consulta";
        ArrayList<Consulta> listConsulta = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Consulta c = new Consulta();
                    c.setId(rs.getInt("id"));
                    c.setDataHora(rs.getString("DataHora"));
                    // Preencha as referências para Veterinário e Pet conforme necessário
                    c.setNotas(rs.getString("notas"));
                    listConsulta.add(c);
                }
        }
        return listConsulta;
    }

    public static void update(Connection conn, Consulta consulta) throws SQLException {
        String sql = "UPDATE Consulta SET dataHora = ?, veterinario_id = ?, pet_id = ?, notas = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, consulta.getDataHora());
            pstmt.setInt(2, consulta.getVeterinario().getId());
            pstmt.setInt(3, consulta.getPet().getId());
            pstmt.setString(4, consulta.getNotas());
            pstmt.setInt(5, consulta.getId());
            pstmt.executeUpdate();
            System.out.println("Consulta atualizada com sucesso.");
        }
    }

    public static void delete(Connection conn, int consultaId) throws SQLException {
        String sql = "DELETE FROM Consulta WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, consultaId);
            pstmt.executeUpdate();
            System.out.println("Consulta excluída com sucesso.");
        }
    }
}
