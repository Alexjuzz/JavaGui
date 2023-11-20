package org.example.Server;

public interface Logger {
    String getLog();
    void writeLog(String text);

    boolean clearLog();

}
