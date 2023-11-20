package org.example.Client;

import org.example.Server.ServerGUI;
import org.example.Server.ServerView;

public class Client {
    private String name;
    private ClientView clientView;
    private ServerGUI serverView;
    private boolean connected;

    public Client(ClientView clientView,ServerGUI server){
        this.clientView = clientView;
        this.serverView = server;
    }

    public String getName() {
        return name;
    }
}
