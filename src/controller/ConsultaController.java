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
        String sql = "INSERT INTO Consulta (dataHora, nomeVeterinario, nomePet, notas) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, consulta.getDataHora());
            pstmt.setString(2, consulta.getNomeVeterinario());
            pstmt.setString(3, consulta.getNomePet());
            pstmt.setString(4, consulta.getNotas());
            pstmt.executeUpdate();
        }  catch (SQLException e) {
            throw new SQLException("Erro ao inserir os dados da Consulta", e);
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
                    consulta.setDataHora(rs.getString("dataHora"));
                    consulta.setNomeVeterinario(rs.getString("nomeVeterinario"));
                    consulta.setNomePet(rs.getString("nomePet"));
                    consulta.setNotas(rs.getString("notas"));
                    listConsultas.add(consulta);
                }
        }  catch (SQLException e) {
            throw new SQLException("Erro ao selecionar os dados da Consulta", e);
        }
        return listConsultas;
    }

    public static void updateData(Connection conn, Consulta consulta) throws SQLException {
        String sql = "UPDATE Consulta SET dataHora = ?, nomeVeterinario = ?, nomePet = ?, notas = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, consulta.getDataHora());
            pstmt.setString(2, consulta.getNomeVeterinario());
            pstmt.setString(3, consulta.getNomePet());
            pstmt.setString(4, consulta.getNotas());
            pstmt.setInt(5, consulta.getId());
            pstmt.executeUpdate();
        }  catch (SQLException e) {
            throw new SQLException("Erro ao atualizar os dados da Consulta", e);
        }
    }

    public static void deleteData(Connection conn, int consultaId) throws SQLException {
        String sql = "DELETE FROM Consulta WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, consultaId);
            pstmt.executeUpdate();
        }  catch (SQLException e) {
            throw new SQLException("Erro ao deletar os dados da Consulta", e);
        }
    }
}
