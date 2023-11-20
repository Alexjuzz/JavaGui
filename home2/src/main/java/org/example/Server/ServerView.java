package org.example.Server;

public interface ServerView {
    void showMessage();
    void startServer();
    void stopServer();
    boolean serverIsRun();

    void showLog();

    void sendMessage(String text);



}
