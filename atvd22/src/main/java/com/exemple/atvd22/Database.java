package com.exemple.atvd22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/uc11"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "@CaioAlves1"; 

    public static Connection getConnection() throws DatabaseException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new DatabaseException("❌ Driver JDBC não encontrado! Certifique-se de que a dependência MySQL está instalada.", e);
        } catch (SQLException e) {
            throw new DatabaseException("❌ Erro na conexão com o banco de dados! Verifique se o banco 'uc11' está ativo e as credenciais estão corretas.", e);
        }
    }
}
