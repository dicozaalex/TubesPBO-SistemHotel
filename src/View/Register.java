package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controller.*;

public class Register {
    public Register() {
        JFrame f = new JFrame("Register Your Account");
        JLabel titLabel = new JLabel("PLEASE FILL WITH YOUR DETAILS");

        titLabel.setFont(new Font("Arial", Font.ITALIC, 15));
        titLabel.setBounds(35, 20, 300, 20);
        f.add(titLabel);

        JLabel username, firstname, lastname, password, confirmPass, email, phone;
        JTextField inputUserName, inputFirstname, inputLastname, inputEmail,
                inputPhone;
        JPasswordField inputPassword, inputConfirmPass;

        username = new JLabel("Username");
        firstname = new JLabel("First Name");
        lastname = new JLabel("Last Name");
        password = new JLabel("Password");
        confirmPass = new JLabel("Confirm Password");
        email = new JLabel("Email");
        phone = new JLabel("Phone");

        inputUserName = new JTextField();
        inputFirstname = new JTextField();
        inputLastname = new JTextField();
        inputPassword = new JPasswordField();
        inputConfirmPass = new JPasswordField();
        inputEmail = new JTextField();
        inputPhone = new JTextField();

        username.setBounds(35, 60, 200, 20);
        firstname.setBounds(35, 80, 200, 20);
        lastname.setBounds(35, 100, 200, 20);
        password.setBounds(35, 120, 200, 20);
        confirmPass.setBounds(35, 140, 200, 20);
        email.setBounds(35, 160, 200, 20);
        phone.setBounds(35, 180, 200, 20);

        inputUserName.setBounds(150, 60, 200, 25);
        inputFirstname.setBounds(150, 80, 200, 25);
        inputLastname.setBounds(150, 100, 200, 25);
        inputPassword.setBounds(150, 120, 200, 25);
        inputConfirmPass.setBounds(150, 140, 200, 25);
        inputEmail.setBounds(150, 160, 200, 25);
        inputPhone.setBounds(150, 180, 200, 25);

        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(35, 230, 300, 30);

        registerButton.setFont(new Font("Arial", Font.ITALIC, 12));

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
                        new Login();
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