/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemple.atvd22;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListagemVIEW extends JFrame {
    private JTable tabela;
    private DefaultTableModel modelo;
    private JButton btnVender;

    public ListagemVIEW() {
        setTitle("Listagem de Produtos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Valor");
        modelo.addColumn("Status");

        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane, BorderLayout.CENTER);

        btnVender = new JButton("Vender Produto");
        add(btnVender, BorderLayout.SOUTH);

        btnVender.addActionListener(e -> venderProduto());

        carregarItens();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void carregarItens() {
        modelo.setRowCount(0);
        ProdutosDAO dao = new ProdutosDAO();
        List<Produto> produtos = dao.listarProdutosVendidos();
        for (Produto p : produtos) {
            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getValor(), p.getStatus()});
        }
    }

    private void venderProduto() {
        int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada != -1) {
            int idProduto = (int) tabela.getValueAt(linhaSelecionada, 0);
            ProdutosDAO dao = new ProdutosDAO();
            dao.venderProduto(idProduto);
            JOptionPane.showMessageDialog(null, "Produto vendido!");
            carregarItens();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item!");
        }
    }
}





