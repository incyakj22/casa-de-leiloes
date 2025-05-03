/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemple.atvd22;

/**
 *
 * @author Caio
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VendasVIEW extends JFrame {
    private JTable tabelaVendas;
    private DefaultTableModel modelo;

    public VendasVIEW() {
        setTitle("Itens Vendidos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Valor");

        tabelaVendas = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabelaVendas);
        add(scrollPane, BorderLayout.CENTER);

        carregarProdutosVendidos();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void carregarProdutosVendidos() {
        ProdutosDAO dao = new ProdutosDAO();
        List<Produto> vendidos = dao.listarProdutosVendidos();
        modelo.setRowCount(0);
        for (Produto p : vendidos) {
            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getValor()});
        }
    }
}




