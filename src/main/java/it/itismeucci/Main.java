package it.itismeucci;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Hello world!");
        Socket s = new Socket("localhost", 5673);
        System.out.println("il client si è collegato");
    }
}