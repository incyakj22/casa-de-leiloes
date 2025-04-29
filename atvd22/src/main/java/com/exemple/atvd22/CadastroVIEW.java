package com.exemple.atvd22;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroVIEW extends JFrame {
    private JTextField txtNome;
    private JTextField txtValor;
    private JButton btnSalvar;

    public CadastroVIEW() {
        setTitle("Tela de Cadastro");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 30);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(120, 20, 200, 30);
        add(txtNome);

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(20, 60, 100, 30);
        add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(120, 60, 200, 30);
        add(txtValor);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(120, 100, 100, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = txtNome.getText();
                    double valor = Double.parseDouble(txtValor.getText());

                    CadastroController controller = new CadastroController();
                    if (controller.salvarItem(nome, valor)) {
                        JOptionPane.showMessageDialog(null, "✅ Item cadastrado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "❌ Erro ao cadastrar o item. Verifique a conexão!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "❌ O campo 'Valor' deve ser um número válido!", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}
