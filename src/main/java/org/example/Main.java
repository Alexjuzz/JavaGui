package org.example;

import org.example.Client.Client;
import org.example.server.Server;
import org.example.server.ServerWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new Client(new Server());
    }
}