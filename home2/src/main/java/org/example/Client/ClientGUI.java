package org.example.Client;

import org.example.Server.ServerGUI;
import org.example.Server.ServerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame implements ClientView {
    private static final  int WIN_HEIGHT = 333;
    private static  final int WIN_WIDTH =   507;
    private static final int WINDOW_POSY = 100;
    private static final int WINDOW_POX = 512;
    private Client client;
    private ServerGUI serverGUI;
    private String messageText;
    private final JButton buttonSend =  new JButton("Send");
    private final JTextField sendMessageTextArea = new JTextField("Print your message");
    private final JTextField ipAddressArea = new JTextField("Address");
    private final JTextField portAddressArea = new JTextField("Port");
    private final JTextArea systemMessageMainMenu = new JTextArea();
    private final JButton buttonLogin = new JButton("Login");
    private final JTextField loginTextArea = new JTextField("User name");
    private  final JPasswordField passwordTextArea = new JPasswordField("pass");

    public ClientGUI(ServerGUI server){
        this.client = new Client(this,server);
        this.serverGUI = server;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POX,WINDOW_POSY);
        setSize(WIN_WIDTH,WIN_HEIGHT);
        setVisible(true);
        setTitle("Client window");
        JPanel mainPannel = new JPanel(new GridLayout(2,1));
        systemMessageMainMenu.setPreferredSize(new Dimension(100,240));
        mainPannel.add(LoginPanel());
        mainPannel.add(ConnectPanel());
        add(mainPannel,BorderLayout.NORTH);
        add(systemMessageMainMenu,BorderLayout.SOUTH);
        add(sendPanel(),BorderLayout.SOUTH);
    }
    private JPanel LoginPanel(){
        JPanel loginpanel = new JPanel(new GridLayout(1,2));
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(serverGUI.serverIsRun()){
                    serverGUI.sendMessage("Вы");
                }
            }
        });
        loginpanel.add(loginTextArea);
        loginpanel.add(passwordTextArea);
        loginpanel.add(buttonLogin);
    return loginpanel;
    }
    private JPanel ConnectPanel(){
        JPanel connectPannel = new JPanel(new GridLayout(1,2));
        connectPannel.add(ipAddressArea);
        connectPannel.add(portAddressArea);
        return connectPannel;
    }
    private JPanel sendPanel(){
        JPanel sendMessage = new JPanel(new GridLayout(1,2,10,10));
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageText  = sendMessageTextArea.getText();
            }
        });
        sendMessage.add(sendMessageTextArea);
        sendMessage.add(buttonSend);
        return sendMessage;
    }



    @Override
    public void showMessage(String text) {
        System.out.println(text);
    }

    @Override
    public void sendMessage(String text) {

    }
    @Override
    public String getName(){
       return client.getName();
    }
}
