package org.example.Client;

import org.example.client.ClientWindow;
import org.example.server.Server;

import java.awt.*;

public class Client {
    ClientWindow clientWin;
    Server server;
    private String name;
    private String password;
    private static int id = 1;

    public Client(Server server) {

        id++;
        this.server = server;
        clientWin = new ClientWindow(this.server);
    }

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }


    public static int getId() {
        return id;
    }


    public String getMessage() {
        return clientWin.getMessage();

    }

    private void addUser() {
        server.putPersonToDB(id, clientWin.getLoginUser());
    }

    private void sendMessageToChat() {

    }

}
