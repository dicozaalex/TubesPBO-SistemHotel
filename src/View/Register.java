package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Register {
    public Register() {
        JFrame f = new JFrame("Register Here");
        // (String), first nama(String), last name(string), password (String), email
        // (String), no. telepon (String).
        JLabel username, firstname, lastname, password, confirmPass, email, phone;
        JTextField inputUserName, inputFirstname, inputLastname, inputPassword, inputConfirmPass, inputEmail, inputPhone;

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

        JButton login = new JButton("Login");
        login.setBounds(5, 50, 100, 20);

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

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }
    // JPanel panel;
    // JLabel user_label, password_label, message;
    // JTextField userName_text;
    // JPasswordField password_text;
    // JButton submit, cancel;

    // Register() {
    // // Username Label
    // user_label = new JLabel();
    // user_label.setText("User Name :");
    // userName_text = new JTextField();
    // // Password Label
    // password_label = new JLabel();
    // password_label.setText("Password :");
    // password_text = new JPasswordField();
    // // Submit
    // submit = new JButton("SUBMIT");
    // panel = new JPanel(new GridLayout(3, 1));
    // panel.add(user_label);
    // panel.add(userName_text);
    // panel.add(password_label);
    // panel.add(password_text);
    // message = new JLabel();
    // panel.add(message);
    // panel.add(submit);
    // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // // Adding the listeners to components..
    // submit.addActionListener(this);
    // add(panel, BorderLayout.CENTER);
    // setTitle("Please Register Here !");
    // setSize(450, 350);
    // setVisible(true);
    // }

    // public static void main(String[] args) {
    // new Register();
    // }

    // @Override
    // public void actionPerformed(ActionEvent ae) {
    // String userName = userName_text.getText();
    // String password = password_text.getText();
    // if (userName.trim().equals("admin") && password.trim().equals("admin")) {
    // message.setText(" Hello " + userName + "");
    // } else {
    // message.setText(" Invalid user.. ");
    // }
    // }
}