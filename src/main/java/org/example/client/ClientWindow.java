package org.example.client;

import org.example.server.Server;

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
    private final Server server;

    private final JButton buttonSend =  new JButton("Send");
    private final JTextField sendMessageTextArea = new JTextField("Print your message");

    private final JTextField ipAddressArea = new JTextField("Address");
    private final JTextField portAddressArea = new JTextField("Port");

    private final JButton buttonLogin = new JButton("Login");
    private final JTextArea systemMessageMainMenu = new JTextArea();

    private final JTextField logingTextArea = new JTextField("User name");
    private  final JPasswordField passwordTextArea = new JPasswordField("pass");

    /**
     * Окно для пользователя
     * @param server - текущий сервер
     */
    public ClientWindow(Server server){
        this.server = server;
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
//        add(sendPanel(),BorderLayout.SOUTH);

    }

    /**
     * Логин панель отправляет в журнал дейсвия
     *
     */
    private JPanel LoginPanel(){
        JPanel loginpanel = new JPanel(new GridLayout(1,2));
        loginpanel.add(logingTextArea);
        loginpanel.add(passwordTextArea);
        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(server.isRunServer()){
                    setVisible(false);
                    new ClientWindowChat(server,logingTextArea.getText());
                }{
                    server.sendLogMessage("Попытка присоединиться к серверу " + ipAddressArea.getText());
                    systemMessageMainMenu.setText("Не удалось присоединиться к серверу");
                }


            }
        });

        loginpanel.add(buttonLogin);
        return loginpanel;
    }

    /**
     * Панель соединения
     *
     */
    private JPanel ConnectPanel(){
        JPanel connectPannel = new JPanel(new GridLayout(1,2));
        connectPannel.add(ipAddressArea);
        connectPannel.add(portAddressArea);
        return connectPannel;
    }

    public String getMessage() {
        return messageText;
    }


    /**
     * Нижняя панель  пока не знаю зачем она там..
     * TODO
     *
     */
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

    public String getLoginUser(){
      return   logingTextArea.getText();
    }

    /**
     * Получения будущего паролья
     * TODO
     * @return массив chars
     */
    public char[] getPasswordUser(){
        return passwordTextArea.getPassword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }



}
