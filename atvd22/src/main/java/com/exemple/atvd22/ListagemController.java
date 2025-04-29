/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemple.atvd22;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListagemController {
    public List<Item> listarItens() {
        List<Item> lista = new ArrayList<>();
        try {
            Connection conn = Database.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM itens");

            while (rs.next()) {
                lista.add(new Item(rs.getString("nome"), rs.getDouble("valor")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
