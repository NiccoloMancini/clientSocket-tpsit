package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Hello world!");
        Socket s = new Socket("localhost", 5673);
        System.out.println("il client si è collegato");
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        out.writeBytes("ciaoo\n");
        String stringaRicevuta = in.readLine();
        System.out.println("la stringa ricevuta: " + stringaRicevuta);
        
        s.close();
    }
}