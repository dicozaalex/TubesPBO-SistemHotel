/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Controller.*;
import Model.*;

public class AddManagerBaru extends JFrame implements ActionListener {

    String[] valuePrev;
    JFrame f = new JFrame("Add Manager");
    JTextField firstName, lastName, username, password, telepon, email;
    JLabel labFirstName, labLastName, labUsername, labPassword, labTelepon, labEmail, errormessage;
    JButton buttonNext, buttonBack;
    BosController bosc = new BosController();
    Manager manager = new Manager();

    public AddManagerBaru(String[] valueSebelum) {
        valuePrev = valueSebelum;

        labFirstName = new JLabel("Firstname :");
        labLastName = new JLabel("Lastname :");
        labUsername = new JLabel("Username :");
        labPassword = new JLabel("Password :");
        labTelepon = new JLabel("Telepon :");
        labEmail = new JLabel("Email :");
        buttonNext = new JButton("Finish");
        buttonBack = new JButton("Back");
        errormessage = new JLabel("Terdapat field kosong");
        firstName = new JTextField();
        lastName = new JTextField();
        username = new JTextField();
        password = new JTextField();
        telepon = new JTextField();
        email = new JTextField();

        labFirstName.setBounds(20, 20, 100, 40);
        labLastName.setBounds(20, 70, 100, 40);
        labUsername.setBounds(20, 120, 100, 40);
        labPassword.setBounds(20, 170, 100, 40);
        labTelepon.setBounds(20, 220, 100, 40);
        labEmail.setBounds(20, 270, 100, 40);

        firstName.setBounds(120, 20, 240, 40);
        lastName.setBounds(120, 70, 240, 40);
        username.setBounds(120, 120, 240, 40);
        password.setBounds(120, 170, 240, 40);
        telepon.setBounds(120, 220, 240, 40);
        email.setBounds(120, 270, 240, 40);

        errormessage.setBounds(40, 315, 200, 30);
        buttonNext.setBounds(285, 315, 75, 30);
        buttonBack.setBounds(200, 315, 75, 30);

        errormessage.setVisible(false);

        f.add(errormessage);
        f.add(labFirstName);
        f.add(labLastName);
        f.add(labUsername);
        f.add(labPassword);
        f.add(labTelepon);
        f.add(labEmail);
        f.add(firstName);
        f.add(lastName);
        f.add(username);
        f.add(password);
        f.add(telepon);
        f.add(email);
        f.add(buttonNext);
        f.add(buttonBack);

        buttonNext.addActionListener(this);
        buttonBack.addActionListener(this);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNext) {
            int kosong = 0;
            if (firstName.getText().equals("")) {
                kosong++;
            }
            if (lastName.getText().equals("")) {
                kosong++;
            }
            if (username.getText().equals("")) {
                kosong++;
            }
            if (password.getText().equals("")) {
                kosong++;
            }
            if (telepon.getText().equals("")) {
                kosong++;
            }
            if (email.getText().equals("")) {
                kosong++;
            }
            if (kosong == 0) {
                manager.setFirstname(firstName.getText());
                manager.setLastname(lastName.getText());
                manager.setUsername(username.getText());
                manager.setPassword(password.getText());
                manager.setTelp(telepon.getText());
                manager.setEmail(email.getText());
                bosc.addCabang(valuePrev[0], valuePrev[1], manager);
                f.dispose();
                new BossMainMenu();
            } else {
                errormessage.setVisible(true);
            }
        }
        
        if (e.getSource() == buttonBack) {
            f.dispose();
            new AddCabangBaru(valuePrev);
        }
    }
}
