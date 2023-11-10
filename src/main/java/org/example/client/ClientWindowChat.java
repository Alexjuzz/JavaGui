package org.example.client;

import org.example.server.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindowChat extends JFrame implements ActionListener {
    private static final int WIN_HEIGHT = 333;
    private static final int WIN_WIDTH = 507;
    private static final int WINDOW_POSY = 100;
    private static final int WINDOW_POX = 512;
    private final String userName;
    private final Server server;

    private String messageText;
    JButton buttonSend = new JButton("SEND ");
    private final JTextField sendMessageTextArea = new JTextField("Print your message");
    private final JTextArea chat = new JTextArea();

    public ClientWindowChat(Server server, String name) {
        this.userName = name;
        this.server = server;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POX, WINDOW_POSY);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setVisible(true);
        setTitle("Client window chat");
        chat.setPreferredSize(new Dimension(100, 245));
        add(chat, BorderLayout.NORTH);
        add(sendPanel(), BorderLayout.SOUTH);


    }

    /**
     * панель отправки сообщений
     *
     */
    private JPanel sendPanel() {
        JPanel sendMesage = new JPanel(new GridLayout(1, 2));

        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.sendMessage(userName + " " + sendMessageTextArea.getText());
                messageText = server.getChat();
                chat.setText(messageText);
            }
        });

        sendMesage.add(sendMessageTextArea);
        sendMesage.add(buttonSend);
        return sendMesage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
