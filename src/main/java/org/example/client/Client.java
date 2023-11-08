package org.example.Client;

import org.example.client.ClientWindow;
import org.example.server.Server;

import java.awt.*;

public class Client {
    ClientWindow cw;
    Server server;
    private String name;
    private String password;
    private static int id = 1;

    public Client(Server server) {
        cw = new ClientWindow();
        id++;
        this.server = server;
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
        return cw.getMessage();

    }

}
