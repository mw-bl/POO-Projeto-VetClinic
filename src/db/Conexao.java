package db;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

// Para conexão com o banco (versao 8.0.30): https://jar-download.com/artifacts/mysql/mysql-connector-java

public class Conexao {
    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;
        String serverName = "localhost";
        String mydatabase = "VetClinic";

        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
        String username = "root";
        String password  = "mw123";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}