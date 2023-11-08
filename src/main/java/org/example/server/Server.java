package org.example.server;

import java.util.HashMap;
import java.util.Map;

public class Server {

    Map<Integer,String> mapPersons;
    ServerWindow serverWindow;
    private boolean runServer = false;
    public Server(){
        mapPersons = new HashMap<>();
        serverWindow = new ServerWindow(false);

    }
}
