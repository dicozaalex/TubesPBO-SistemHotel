package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controller.*;
import Model.*;

public class Login {
    public Login() {
        JFrame f = new JFrame("Login To Your Account");
        JLabel username, password;
        JTextField inputUserName;
        JPasswordField inputPassword;

        username = new JLabel("Username");
        password = new JLabel("Password");
        inputUserName = new JTextField();
        inputPassword = new JPasswordField();

        username.setFont(new Font("Arial", Font.ITALIC, 15));
        password.setFont(new Font("Arial", Font.ITALIC, 15));

        username.setBounds(35, 20, 300, 20);
        inputUserName.setBounds(35, 40, 300, 30);
        password.setBounds(35, 80, 300, 20);
        inputPassword.setBounds(35, 100, 300, 30);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(35, 150, 300, 40);

        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(35, 200, 300, 40);

        registerButton.setFont(new Font("Arial", Font.ITALIC, 12));
        loginButton.setFont(new Font("Arial", Font.ITALIC, 12));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController c = new LoginController();
                String cekUsername = inputUserName.getText();
                String cekPassword = inputPassword.getText();
                boolean cekLogin = c.login(cekUsername, cekPassword);
                if (cekLogin) {
                    Customer customer = c.getCustomer(cekUsername);
                    JOptionPane.showMessageDialog(null, "Login Success");
                    f.dispose();
                    new CustomerBranchMenu(customer);
                } else {
                    JOptionPane.showMessageDialog(null, "Login Failed");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Register();
            }
        });

        f.add(username);
        f.add(inputUserName);
        f.add(password);
        f.add(inputPassword);
        f.add(loginButton);
        f.add(registerButton);

        f.setSize(400, 350);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}