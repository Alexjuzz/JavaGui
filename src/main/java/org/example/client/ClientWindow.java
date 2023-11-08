package org.example.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindow extends JFrame implements ActionListener {
    private static final  int WIN_HEIGHT = 333;
    private static  final int WIN_WIDTH =   507;
    private static final int WINDOW_POSY = 100;
    private static final int WINDOW_POX = 512;

    private String messageText;

    private JButton buttonSend =  new JButton("Send");
    private JTextField sendMesageTextArea = new JTextField("Print your message");

    private JTextField ipAddressArea = new JTextField("Address");
    private JTextField portAddressArea = new JTextField("Port");

    private JButton buttonLoggin = new JButton("Login");

    private JTextField logingTextArea = new JTextField("User name");
    private JPasswordField passwordTextArea = new JPasswordField("pass");

    public ClientWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POX,WINDOW_POSY);
        setSize(WIN_WIDTH,WIN_HEIGHT);
        setVisible(true);
        setTitle("Client window");
        JPanel mainPannel = new JPanel(new GridLayout(2,1));
        mainPannel.add(LoginPanel());
        mainPannel.add(ConnectPanel());
        add(mainPannel,BorderLayout.NORTH);
        add(sendPanel(),BorderLayout.SOUTH);

    }

    private JPanel LoginPanel(){
        JPanel loginpanel = new JPanel(new GridLayout(1,2));
        loginpanel.add(logingTextArea);
        loginpanel.add(passwordTextArea);
        loginpanel.add(buttonLoggin);
        return loginpanel;
    }
    private JPanel ConnectPanel(){
        JPanel connectPannel = new JPanel(new GridLayout(1,2));
        connectPannel.add(ipAddressArea);
        connectPannel.add(portAddressArea);
        return connectPannel;
    }

    public String getMessage() {
        return messageText;
    }

    private JPanel sendPanel(){
        JPanel sendMesage = new JPanel(new GridLayout(1,2,10,10));
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

    public String getLoginUser(){
      return   logingTextArea.getText();
    }
    public char[] getPasswordUser(){
        return passwordTextArea.getPassword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
