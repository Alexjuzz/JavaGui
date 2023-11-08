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
    private boolean runServer;
    private String logMessage = "";

    private JButton buttonStart = new JButton("Start");
    private JButton buttonStop = new JButton("Stop");
    private JTextArea mainArea = new JTextArea("");


    public ServerWindow(boolean start) {
        this.runServer  = start;
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

    public void setMainAreaText(String text) {
        mainArea.setText(text);
    }

    public String getLogMessage() {
        return logMessage;
    }

    private JButton startServer() {
            buttonStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonStart.setMnemonic(KeyEvent.VK_D);
                    buttonStart.setActionCommand("Enable");
                    buttonStart.setEnabled(false);
                    buttonStop.setEnabled(true);
                    printChat("Server start");
                    runServer = true;
                    System.out.println(runServer);
                }
            });

        return buttonStart;
    }

    private JButton stopServer() {
        System.out.println(runServer);

            buttonStop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonStop.setMnemonic(KeyEvent.VK_D);
                    buttonStop.setActionCommand("Enable");
                    buttonStop.setEnabled(false);
                    buttonStart.setEnabled(true);
                    printChat("Server stopped");
                    runServer = false;
                }
            });



        return buttonStop;
    }

    private void printChat(String s) {
        logMessage += s + "\n";
        mainArea.setText(logMessage);
    }
}
