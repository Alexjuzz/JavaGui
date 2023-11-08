package org.example.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindowChat extends ClientWindow{
    private static final  int WIN_HEIGHT = 333;
    private static  final int WIN_WIDTH =   507;
    private static final int WINDOW_POSY = 100;
    private static final int WINDOW_POX = 512;

    private String messageText;
    JButton buttonSend = new JButton();
    private JTextField sendMesageTextArea = new JTextField("Print your message");
    public ClientWindowChat(){

            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocation(WINDOW_POX,WINDOW_POSY);
            setSize(WIN_WIDTH,WIN_HEIGHT);
            setVisible(true);
            setTitle("Client window");


        }
    private JPanel sendPanel(){
        JPanel sendMesage = new JPanel(new GridLayout(1,2));
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageText  = sendMesageTextArea.getText();
            }
        });
        sendMesage.add(sendMesageTextArea);
        sendMesage.add(buttonSend);
        return sendMesage;
    }

}
