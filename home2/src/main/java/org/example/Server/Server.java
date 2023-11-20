package org.example.Server;

import org.example.Client.ClientView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Server implements Logger{
    private ServerView serverView;
    public boolean isRun;
    private final String path_to_log = "./log.txt";

    public Server(ServerView server){
        this.serverView = server;
    }


    @Override
    public String getLog() {
        StringBuilder  log = new StringBuilder();
        try (FileReader readLog = new FileReader(path_to_log)){
            int c;
            while ((c= readLog.read()) != -1){
                log.append((char) c);
            }
            return log.toString();
        }catch (Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void writeLog(String text) {
        try(FileWriter writerLog  = new FileWriter(path_to_log,true)){
            writerLog.write(text);
            writerLog.write("\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean clearLog() {
        try (FileWriter clearLog = new FileWriter(path_to_log, false)) {
            clearLog.write("");
            return true;
        } catch (FileNotFoundException e) {
            System.err.println("Log file not found: " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.println("Error clearing log file: " + e.getMessage());
            return false;
        }
    }

    public boolean isRun(){
        return isRun;
    }
    public void stop(){
        isRun = false;
    }
    public void start(){
        isRun = true;
    }

}
