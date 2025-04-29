/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemple.atvd22;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListagemVIEW extends JFrame {
    private JTable tabela;
    private DefaultTableModel modelo;

    public ListagemVIEW() {
        setTitle("Lista de Itens");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Valor");

        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(20, 20, 350, 200);
        add(scrollPane);

        carregarItens();
        setVisible(true);
    }

    private void carregarItens() {
        ListagemController controller = new ListagemController();
        List<Item> itens = controller.listarItens();

        for (Item item : itens) {
            modelo.addRow(new Object[]{item.getNome(), item.getValor()});
        }
    }
}

