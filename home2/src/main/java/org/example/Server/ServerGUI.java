package org.example.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ServerGUI extends JFrame implements ServerView {
    private static final int WIN_HEIGHT = 333;
    private static final int WIN_WIDTH = 507;
    private static final int WINDOW_POSY = 100;
    private static final int WINDOW_POX = 512;
    private Server server;

    private final JButton buttonStart = new JButton("Start");
    private final JButton buttonStop = new JButton("Stop");
    private final JTextArea mainArea = new JTextArea("");
    private final JButton buttonClearChat = new JButton("CLear");

    public ServerGUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POX, WINDOW_POSY);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setVisible(true);
        setTitle("Server  window");
        JPanel mainPannel = new JPanel(new GridLayout(1, 1));
        setPreferredSize(new Dimension(100, 245));
        mainPannel.add(startButtonServer());
        mainPannel.add(stopButtonServer());
        mainPannel.add(clearChat());
        add(mainArea, BorderLayout.CENTER);
        add(mainPannel, BorderLayout.SOUTH);
        }



    public JButton startButtonServer() {
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonStart.setMnemonic(KeyEvent.VK_D);
                buttonStart.setActionCommand("Enable");
                buttonStart.setEnabled(false);
                buttonStop.setEnabled(true);

                startServer();
                sendMessage("Server is start");

            }
        });

        return buttonStart;
    }
    public JButton clearChat(){
       buttonClearChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.clearLog();
                showMessage();
            }
        });
       return buttonClearChat;
    }

    private JButton stopButtonServer() {

        buttonStop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttonStop.setMnemonic(KeyEvent.VK_D);
                buttonStop.setActionCommand("Enable");
                buttonStop.setEnabled(false);
                buttonStart.setEnabled(true);
                sendMessage("Server is stopped");
                stopServer();
            }
        });
        return buttonStop;
    }

    @Override
    public void startServer() {
        if (server == null) {
            this.server = new Server(this);
            server.start();
        }
    }

    public void stopServer() {
        if (server != null && server.isRun) {
            server.stop();
            server = null;
        }
    }

    @Override
    public boolean serverIsRun() {
        return  server.isRun();
    }

    @Override
    public void showLog() {

    }

    @Override
    public void sendMessage(String text) {
        mainArea.append(text + "\n");
        server.writeLog(text);
        showMessage();
    }

    @Override
    public void showMessage() {
        mainArea.setText(server.getLog());
    }


}
