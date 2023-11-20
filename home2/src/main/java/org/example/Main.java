package org.example;

import org.example.Client.Client;
import org.example.Client.ClientGUI;
import org.example.Client.ClientView;
import org.example.Server.Server;
import org.example.Server.ServerGUI;
import org.example.Server.ServerView;

public class Main {
    public static void main(String[] args) {

    new ClientGUI(new ServerGUI());
    }
}