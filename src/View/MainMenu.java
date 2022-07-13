/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author juand
 */
public class MainMenu {
    public MainMenu() {
        JFrame f = new JFrame("Login Register");
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 100, 100, 40);
        f.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 200, 100, 40);
        f.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
                f.dispose();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Register();
                f.dispose();
            }
        });

        f.setSize(300, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
