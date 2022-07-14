package View;

import Controller.LoginController;
import javax.swing.*;
import java.awt.event.*;
import Model.Customer;
import java.awt.Font;

public class UpdateProfile {
    public UpdateProfile(Customer customer, int selectedCabangHotel) {

        JFrame f = new JFrame("Check Saldo");
        JLabel welcomeLabel = new JLabel("Welcome to Hotel");
        JLabel menuLabel = new JLabel("Please Select Your Menu");

        
        welcomeLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        welcomeLabel.setBounds(100, 20, 300, 20);
        f.add(welcomeLabel);

        menuLabel.setFont(new Font("Arial", Font.ITALIC, 15));
        menuLabel.setBounds(20, 50, 300, 20);
        f.add(menuLabel);

        JLabel username = new JLabel("Username");
        JLabel firstname = new JLabel("First Name");
        JLabel lastname = new JLabel("Last Name");
        JLabel newPassword = new JLabel("Password");
        JLabel email = new JLabel("Email");
        JLabel phone = new JLabel("Phone");

        JTextField inputUserName = new JTextField(customer.getUsername());
        JTextField inputFirstname = new JTextField(customer.getFirstname());
        JTextField inputLastname = new JTextField(customer.getLastname());
        JButton changePassButton = new JButton("Change Password");
        JTextField inputEmail = new JTextField(customer.getEmail());
        JTextField inputPhone = new JTextField(customer.getTelp());

        username.setBounds(35, 100, 200, 20);
        firstname.setBounds(35, 120, 200, 20);
        lastname.setBounds(35, 140, 200, 20);
        newPassword.setBounds(35, 160, 200, 20);
        email.setBounds(35, 180, 200, 20);
        phone.setBounds(35, 200, 200, 20);

        inputUserName.setBounds(150, 100, 200, 25);
        inputFirstname.setBounds(150, 120, 200, 25);
        inputLastname.setBounds(150, 140, 200, 25);
        changePassButton.setBounds(150, 160, 200, 23);
        inputEmail.setBounds(150, 180, 200, 25);
        inputPhone.setBounds(150, 200, 200, 25);

        f.add(username);
        f.add(firstname);
        f.add(lastname);
        f.add(newPassword);
        f.add(email);
        f.add(phone);
        f.add(inputUserName);
        f.add(inputFirstname);
        f.add(inputLastname);
        f.add(changePassButton);
        f.add(inputEmail);
        f.add(inputPhone);

        changePassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePass(customer);
            }
        });

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(35, 240, 200, 25);
        f.add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController loginController = new LoginController();
                String username = inputUserName.getText();
                String firstname = inputFirstname.getText();
                String lastname = inputLastname.getText();
                String email = inputEmail.getText();
                String phone = inputPhone.getText();
                boolean cekUpdate = loginController.updateProfile(username, firstname, lastname, email, phone,
                        customer);
                if (cekUpdate) {
                    JOptionPane.showMessageDialog(null, "Update Success");
                } else {
                    JOptionPane.showMessageDialog(null, "Update Failed");
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(35, 270, 200, 25);
        f.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerMainMenu(customer, selectedCabangHotel);
                f.dispose();
            }
        });

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void changePass(Customer customer) {
        JFrame f = new JFrame("Change Password");

        JLabel newPassLabel = new JLabel("New Password");
        JLabel confirmPassLabel = new JLabel("Confirm Password");
        JLabel oldPassLabel = new JLabel("Old Password");

        JPasswordField newPass = new JPasswordField();
        JPasswordField confirmPass = new JPasswordField();
        JPasswordField oldPass = new JPasswordField();

        newPassLabel.setBounds(35, 60, 200, 20);
        confirmPassLabel.setBounds(35, 80, 200, 20);
        oldPassLabel.setBounds(35, 100, 200, 20);

        newPass.setBounds(150, 60, 200, 25);
        confirmPass.setBounds(150, 80, 200, 25);
        oldPass.setBounds(150, 100, 200, 25);

        JButton changeButton = new JButton("Change");
        changeButton.setBounds(150, 150, 200, 25);
        f.add(changeButton);

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newPassword = newPass.getText();
                String confirmPassword = confirmPass.getText();
                String oldPassword = oldPass.getText();
                LoginController loginController = new LoginController();
                if (newPassword.equals(confirmPassword)) {
                    boolean cekPass = loginController.changePassword(oldPassword, newPassword, customer);
                    if (cekPass) {
                        JOptionPane.showMessageDialog(null, "Password Changed");
                    } else {
                        JOptionPane.showMessageDialog(null, "Password Not Match");
                    }
                    f.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Password Not Match");
                    f.dispose();
                }
            }
        });

        f.add(newPassLabel);
        f.add(confirmPassLabel);
        f.add(oldPassLabel);
        f.add(newPass);
        f.add(confirmPass);
        f.add(oldPass);

        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
    }
}
