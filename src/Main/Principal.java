/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author User
 */

import java.net.*;
import java.io.*;

public class Principal {

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(4444);
            System.out.println("Aguardando cliente!");
            while (true) {
                Socket socket = servidor.accept(); // espera
                Servidor cliente = new Servidor(socket);
                System.out.println("Chegou um cliente!");
                cliente.start();
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }

    }
}