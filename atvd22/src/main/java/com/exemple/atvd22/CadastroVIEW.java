package com.exemple.atvd22;

import javax.swing.*;
import java.awt.*;

public class CadastroVIEW extends JFrame {
    private JTextField txtNome, txtValor;
    private JButton btnCadastrar, btnListar, btnVendas;

    public CadastroVIEW() {
        setTitle("Cadastro de Produtos");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));

        txtNome = new JTextField();
        txtValor = new JTextField();
        btnCadastrar = new JButton("Cadastrar Produto");
        btnListar = new JButton("Listar Produtos");
        btnVendas = new JButton("Consultar Vendas");

        add(new JLabel("Nome do Produto:"));
        add(txtNome);
        add(new JLabel("Valor:"));
        add(txtValor);
        add(btnCadastrar);
        add(btnListar);
        add(btnVendas);

        btnCadastrar.addActionListener(e -> cadastrarProduto());
        btnListar.addActionListener(e -> new ListagemVIEW());
        btnVendas.addActionListener(e -> new VendasVIEW());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cadastrarProduto() {
        String nome = txtNome.getText();
        double valor = Double.parseDouble(txtValor.getText());
        Produto produto = new Produto(0, nome, valor, "Disponível");

        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
    }

    public static void main(String[] args) {
        new CadastroVIEW();
    }
}


