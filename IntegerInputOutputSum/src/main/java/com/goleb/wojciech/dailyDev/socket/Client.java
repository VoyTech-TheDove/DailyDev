package com.goleb.wojciech.dailyDev.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private static final Scanner SCANNER = new Scanner(System.in);

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message;
        boolean stop;
        do {
            System.out.println("write something...");
            message = getMessegeFromUser();
            System.out.println("you have written:");
            System.out.println(message);
            stop = stopConnectionIfExit(message);
            sendMessage(message);
            System.out.println("you have sent:");
            System.out.println(message);
        } while (!stop);
    }
    
    public boolean stopConnectionIfExit(String string) {
        if (string.toUpperCase().equals("EXIT")) {
            try {
                stopConnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }

    public static String getMessegeFromUser() {
        return SCANNER.nextLine();
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.startConnection("localhost", 6666);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

