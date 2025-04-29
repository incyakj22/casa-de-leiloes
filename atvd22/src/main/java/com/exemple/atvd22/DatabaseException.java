/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exemple.atvd22;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

