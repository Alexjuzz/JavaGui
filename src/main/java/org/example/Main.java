package org.example;

import org.example.Client.Client;
import org.example.server.Server;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        new Client(server);
        new Client(server);
    }
}