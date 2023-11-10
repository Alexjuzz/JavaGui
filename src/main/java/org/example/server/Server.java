package org.example.server;

import java.util.HashMap;
import java.util.Map;

public class Server {

    Map<Integer, String> mapPersons;
    ServerWindow serverWindow;
    private boolean runServer = false;

    public Server() {
        mapPersons = new HashMap<>();
        serverWindow = new ServerWindow(this);

    }

    public void putPersonToDB(int id, String name)  {
        mapPersons.put(id, name);
    }

    public void sendMessage(String s) {
        serverWindow.printChat(s);
    }
    public void sendLogMessage (String s){
        serverWindow.addLogMessages(s);
    }

    public boolean isRunServer() {
        return runServer;
    }

    public void startServer() {
        runServer = true;
    }

    public void stopServer() {
        runServer = false;
    }
    public String getLogMessages(){
        return serverWindow.getLogMessage();
    }
    public String getChat(){
       return serverWindow.getChatLog();
    }
}
