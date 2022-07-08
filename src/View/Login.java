package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login  {
    public Login(){
        JFrame f = new JFrame("Login Here");
        JLabel username, password;
        JTextField inputUserName, inputPassword;

        username = new JLabel("Username :");
        password = new JLabel("Password :");
        inputUserName = new JTextField();
        inputPassword = new JPasswordField();

        username.setBounds(5, 20, 200, 20);
        inputUserName.setBounds(100, 20, 200, 20);
        password.setBounds(5, 40, 200, 20);
        inputPassword.setBounds(100, 40, 200, 20);


        JButton login = new JButton("Login");
        login.setBounds(5, 50, 100, 20);

        f.add(username);
        f.add(inputUserName);
        f.add(password);
        f.add(inputPassword);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

}