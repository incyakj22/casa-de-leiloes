/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemple.atvd22;

import java.sql.Connection;




/**
 *
 * @author Caio
 */
public class TesteConexao {
    public static void main(String[] args) {
        Connection conn = Database.getConnection();
        if (conn != null) {
            System.out.println("✅ Conexão bem-sucedida!");
        } else {
            System.out.println("❌ Erro na conexão com o banco de dados.");
        }
    }
}
