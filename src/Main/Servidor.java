/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author User
 */

import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Servidor extends Thread {

    private static int contadorClientes = 0; 
    private Socket con;
    private BufferedReader in;
    private PrintWriter out;

    public Servidor(Socket socket) {
        try {
            con = socket;
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            out = new PrintWriter(con.getOutputStream(), true);
            
            // incrementa o contador de clientes
        contadorClientes++;
        System.out.println("Novo cliente conectado. Total de clientes: " + contadorClientes);
        } catch (IOException ioe) {
            System.err.println("Problemas de IO");
        }
    }

    public void run() {
        try {
            out.println("Bem vindo!"); //Escreve ao cliente
            String mensagem = "";
            while ((mensagem = in.readLine()) != null) {
                System.out.println(mensagem);
            }
        } catch (IOException ioe) {
            System.err.println("Problemas de IO");
        }
    }
}
