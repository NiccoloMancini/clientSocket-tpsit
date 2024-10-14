package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        Socket s = new Socket("localhost", 5673);
        System.out.println("il client si è collegato");
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String stringaRicevuta;
        String stringaScritta;
        do {
            System.out.print("inserire la stringa (! per terminare la connesione): ");
            stringaScritta = scanner.nextLine();
            out.writeBytes(stringaScritta + "\n");
            if (!stringaScritta.equals("!")) {
                System.out.print("la stringa ricevuta: ");
            }
            stringaRicevuta = in.readLine();
            System.out.println(stringaRicevuta);
        } while (!stringaScritta.equals("!"));
        
        s.close();
        scanner.close();
    }
}