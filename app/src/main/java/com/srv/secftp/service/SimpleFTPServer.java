package com.srv.secftp.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFTPServer extends Thread {

    private ServerSocket serverSocket;
    private boolean running = false;
    private int port = 2121; // default FTP port is 21, but needs root for port <1024

    public SimpleFTPServer() {
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            running = true;
            while (running) {
                Socket client = serverSocket.accept();
                // TODO: Handle FTP commands here
                handleClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket client) {
        // Here you would read/write commands like USER, PASS, LIST, RETR, STOR, etc.
        // For now, just close it
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() {
        running = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

