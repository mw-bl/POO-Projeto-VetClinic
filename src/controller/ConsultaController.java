package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import models.Consulta;
import models.Pet;
import models.Veterinario;

public class ConsultaController {
    // CRUD
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
            pstmt.setInt(2, consulta.getVeterinario().getId());
            pstmt.setInt(3, consulta.getPet().getId());
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

    // Método para obter consultas por cliente
    public static ArrayList<Consulta> readConsultasByCliente(Connection conn, int clienteId) throws SQLException {
        String sql = "SELECT * FROM Consulta WHERE pet_id IN (SELECT id FROM Pet WHERE tutor_id = ?)";
        ArrayList<Consulta> consultas = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clienteId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Consulta consulta = new Consulta();
                    consulta.setId(rs.getInt("id"));
                    consulta.setDataHora(rs.getString("dataHora"));
                    consulta.setVeterinario(getVeterinarioById(conn, rs.getInt("veterinario_id")));
                    consulta.setPet(getPetById(conn, rs.getInt("pet_id")));
                    consulta.setNotas(rs.getString("notas"));
                    // Adicione outras propriedades conforme necessário
                    consultas.add(consulta);
                }
            }
        }
        return consultas;
    }

    // Método auxiliar para obter um veterinário por ID
    private static Veterinario getVeterinarioById(Connection conn, int veterinarioId) throws SQLException {
        String sql = "SELECT * FROM Veterinario WHERE id = ?";
        Veterinario veterinario = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, veterinarioId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    veterinario = new Veterinario();
                    veterinario.setId(rs.getInt("id"));
                    veterinario.setNome(rs.getString("nome"));
                    veterinario.setEspecialidade(rs.getString("especialidade"));
                    veterinario.setTelefone(rs.getString("contato"));
                }
            }
        }
        return veterinario;
    }

    // Método auxiliar para obter um pet por ID
    private static Pet getPetById(Connection conn, int petId) throws SQLException {
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
