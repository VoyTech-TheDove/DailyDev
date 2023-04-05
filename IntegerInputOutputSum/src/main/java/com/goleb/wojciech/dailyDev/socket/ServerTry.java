package com.goleb.wojciech.dailyDev.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerTry {
    private java.net.ServerSocket serverTry;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverTry = new java.net.ServerSocket(port);
        clientSocket = serverTry.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("reading line...");
        boolean doStop = false;
        do {
            String clientsMessage = in.readLine();
            System.out.println("message from client:");
            System.out.println(clientsMessage);
            if ("hello server".equals(clientsMessage)) {
                out.println("hello client");
            } else if ("EXIT".equals(clientsMessage.toUpperCase())) {
                doStop = true;
            } else {
                out.println("unrecognised greeting");
            }
        } while (!doStop);
        stop();
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverTry.close();
    }

    public static void main(String[] args) {
        com.goleb.wojciech.dailyDev.socket.ServerSocket serverSocket = new com.goleb.wojciech.dailyDev.socket.ServerSocket();
        try {
            serverSocket.start(6666);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
