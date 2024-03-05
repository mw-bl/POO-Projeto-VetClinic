package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Cliente;

public class ClienteController {
    // CRUD
    public static void insertData(Connection conn, Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nome, telefone) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getTelefone());
            pstmt.executeUpdate();
            System.out.println("Cliente cadastrado com sucesso.");
        }
    }

    public static ArrayList<Cliente> selectData(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Cliente";
        ArrayList<Cliente> listClientes = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                listClientes.add(cliente);
            }
        }
        return listClientes;
    }

    public static void updateData(Connection conn, Cliente cliente) throws SQLException {
        String sql = "UPDATE Cliente SET nome = ?, telefone = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getTelefone());
            pstmt.setInt(3, cliente.getId());
            pstmt.executeUpdate();
            System.out.println("Dados do cliente atualizados com sucesso.");
        }
    }

    public static void deleteData(Connection conn, int clienteId) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clienteId);
            pstmt.executeUpdate();
            System.out.println("Cliente excluído com sucesso.");
        }
    }

    // Método para obter um cliente pelo ID
    public static Cliente getClienteById(Connection conn, int clienteId) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        Cliente cliente = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, clienteId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setTelefone(rs.getString("contato"));
                }
            }
        }
        return cliente;
    }
}
