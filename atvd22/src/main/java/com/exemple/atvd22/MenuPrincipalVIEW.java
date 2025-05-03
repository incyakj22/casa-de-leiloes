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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalVIEW extends JFrame {
    private JButton btnConsultarVendas;

    public MenuPrincipalVIEW() {
        setTitle("Menu Principal");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnConsultarVendas = new JButton("Consultar Vendas");
        btnConsultarVendas.setBounds(50, 150, 150, 30);
        add(btnConsultarVendas);

        btnConsultarVendas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VendasVIEW();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuPrincipalVIEW();
    }
}
