package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controller.*;

public class Register {
    public Register() {
        JFrame f = new JFrame("Register Here");
        JLabel username, firstname, lastname, password, confirmPass, email, phone;
        JTextField inputUserName, inputFirstname, inputLastname, inputEmail,
                inputPhone;
        JPasswordField inputPassword, inputConfirmPass;

        username = new JLabel("Username :");
        firstname = new JLabel("First Name :");
        lastname = new JLabel("Last Name :");
        password = new JLabel("Password :");
        confirmPass = new JLabel("Confirm Password :");
        email = new JLabel("Email :");
        phone = new JLabel("Phone :");

        inputUserName = new JTextField();
        inputFirstname = new JTextField();
        inputLastname = new JTextField();
        inputPassword = new JPasswordField();
        inputConfirmPass = new JPasswordField();
        inputEmail = new JTextField();
        inputPhone = new JTextField();

        username.setBounds(5, 20, 200, 20);
        firstname.setBounds(5, 40, 200, 20);
        lastname.setBounds(5, 60, 200, 20);
        password.setBounds(5, 80, 200, 20);
        confirmPass.setBounds(5, 100, 200, 20);
        email.setBounds(5, 120, 200, 20);
        phone.setBounds(5, 140, 200, 20);

        inputUserName.setBounds(150, 20, 200, 20);
        inputFirstname.setBounds(150, 40, 200, 20);
        inputLastname.setBounds(150, 60, 200, 20);
        inputPassword.setBounds(150, 80, 200, 20);
        inputConfirmPass.setBounds(150, 100, 200, 20);
        inputEmail.setBounds(150, 120, 200, 20);
        inputPhone.setBounds(150, 140, 200, 20);

        JButton registerButton = new JButton("Login");
        registerButton.setBounds(5, 50, 100, 20);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController c = new LoginController();

                String username = inputUserName.getText();
                boolean cekUsername = c.cekUsername(username);
                String firstname = inputFirstname.getText();
                String lastname = inputLastname.getText();
                String password = inputPassword.getText();
                String confirmPass = inputConfirmPass.getText();
                String email = inputEmail.getText();
                String phone = inputPhone.getText();
                if (cekUsername) {
                    if(username.equals("") || firstname.equals("") || lastname.equals("") || password.equals("") || confirmPass.equals("") || email.equals("") || phone.equals("")){
                        JOptionPane.showMessageDialog(null, "Please fill all the fields");
                    }
                    else if(!password.equals(confirmPass)){
                        JOptionPane.showMessageDialog(null, "Password does not match");
                    }
                    else{
                        c.register(username, firstname, lastname, password, email, phone);
                        f.dispose();
                        new MainMenu();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Username already exists");
                }
            }
        });

        f.add(username);
        f.add(inputUserName);
        f.add(firstname);
        f.add(inputFirstname);
        f.add(lastname);
        f.add(inputLastname);
        f.add(password);
        f.add(inputPassword);
        f.add(confirmPass);
        f.add(inputConfirmPass);
        f.add(email);
        f.add(inputEmail);
        f.add(phone);
        f.add(inputPhone);
        f.add(registerButton);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
}