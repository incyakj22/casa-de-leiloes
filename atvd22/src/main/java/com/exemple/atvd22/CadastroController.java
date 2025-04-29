package com.exemple.atvd22;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroController {
    public boolean salvarItem(String nome, double valor) {
        if (nome.isEmpty() || valor <= 0) {
            throw new IllegalArgumentException("❌ Nome do item não pode estar vazio e o valor deve ser maior que zero!");
        }

        try {
            Connection conn = Database.getConnection();
            String sql = "INSERT INTO itens (nome, valor) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            stmt.executeUpdate();
            conn.close(); // Fecha a conexão corretamente
            return true;
        } catch (DatabaseException e) {
            System.err.println("❌ Erro de conexão: " + e.getMessage());
            return false;
        } catch (SQLException e) {
            System.err.println("❌ Erro ao salvar item no banco: " + e.getMessage());
            return false;
        }
    }
}
