package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controller.*;

public class Login  {
    public Login(){
        JFrame f = new JFrame("Login Here");
        JLabel username, password;
        JTextField inputUserName;
        JPasswordField inputPassword;

        username = new JLabel("Username :");
        password = new JLabel("Password :");
        inputUserName = new JTextField();
        inputPassword = new JPasswordField();

        username.setBounds(5, 20, 200, 20);
        inputUserName.setBounds(100, 20, 200, 20);
        password.setBounds(5, 40, 200, 20);
        inputPassword.setBounds(100, 40, 200, 20);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(5, 50, 100, 20);
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController c = new LoginController();
                String cekUsername = inputUserName.getText();
                String cekPassword = inputPassword.getText();
                boolean cekLogin = c.login(cekUsername, cekPassword);
                if (cekLogin) {
                    JOptionPane.showMessageDialog(null, "Login Success");
                    f.dispose();
                    new CustomerMainMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Failed");
                }
            }
        });

        f.add(username);
        f.add(inputUserName);
        f.add(password);
        f.add(inputPassword);
        f.add(loginButton);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

}