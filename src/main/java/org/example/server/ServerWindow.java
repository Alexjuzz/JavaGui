package org.example.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ServerWindow extends JFrame {
    private static final int WIN_HEIGHT = 333;
    private static final int WIN_WIDTH = 507;
    private static final int WINDOW_POSY = 100;
    private static final int WINDOW_POX = 512;
    private String logMessage = "";
    private String chatLog = "";
    private final Server server;

    private final JButton buttonStart = new JButton("Start");
    private  final JButton buttonStop = new JButton("Stop");
    private  final JTextArea mainArea = new JTextArea("");


    public ServerWindow(Server server) {
        this.server = server;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POX, WINDOW_POSY);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setVisible(true);
        setTitle("Server  window");
        JPanel mainPannel = new JPanel(new GridLayout(1, 1));
        mainArea.setPreferredSize(new Dimension(100, 245));
        mainPannel.add(startServer());
        mainPannel.add(stopServer());
        add(mainArea, BorderLayout.NORTH);
        add(mainPannel, BorderLayout.SOUTH);


    }

    public String getLogMessage() {
        return logMessage;
    }
    public String getChatLog(){
        return chatLog;
    }

    /**
     * Кнопка-триггер запуска сервера
     *
     */
    private JButton startServer() {
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonStart.setMnemonic(KeyEvent.VK_D);
                buttonStart.setActionCommand("Enable");
                buttonStart.setEnabled(false);
                buttonStop.setEnabled(true);
                addLogMessages("Server start");
                server.startServer();
            }
        });

        return buttonStart;
    }

    /**
     * Кнопка-тригер отсновки сервера
     *
     */
    private JButton stopServer() {

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonStop.setMnemonic(KeyEvent.VK_D);
                buttonStop.setActionCommand("Enable");
                buttonStop.setEnabled(false);
                buttonStart.setEnabled(true);
                addLogMessages("Server stopped");
                server.stopServer();
            }
        });


        return buttonStop;
    }

    /**
     * Добавление действий в будущий журнал
     * @param s - текст сообщения
     */
    public void addLogMessages(String s){
        logMessage += s + "\n";
        mainArea.setText(logMessage);
    }

    /**
     * отправление сообщения в чат
     * @param s текст сообщения
     */
    public void printChat(String s) {
        if (server.isRunServer()) {
            chatLog += s + "\n" ;
            mainArea.setText(chatLog);
        }
    }

}
