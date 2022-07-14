package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Controller.*;
import Model.*;

public class Login extends JFrame implements ActionListener {

    JFrame f = new JFrame("Login To Your Account");
    JLabel username, password;
    JTextField inputUserName;
    JPasswordField inputPassword;
    JButton loginButton, registerButton;

    public Login() {

        username = new JLabel("Username");
        password = new JLabel("Password");
        inputUserName = new JTextField();
        inputPassword = new JPasswordField();
        loginButton = new JButton("LOGIN");
        registerButton = new JButton("REGISTER");

        username.setFont(new Font("Arial", Font.ITALIC, 15));
        password.setFont(new Font("Arial", Font.ITALIC, 15));

        username.setBounds(35, 20, 300, 20);
        inputUserName.setBounds(35, 40, 300, 30);
        password.setBounds(35, 80, 300, 20);
        inputPassword.setBounds(35, 100, 300, 30);

        loginButton.setBounds(35, 150, 300, 40);

        registerButton.setBounds(35, 200, 300, 40);

        registerButton.setFont(new Font("Arial", Font.ITALIC, 12));
        loginButton.setFont(new Font("Arial", Font.ITALIC, 12));

        loginButton.addActionListener(this);

        registerButton.addActionListener(this);

        f.add(username);
        f.add(inputUserName);
        f.add(password);
        f.add(inputPassword);
        f.add(loginButton);
        f.add(registerButton);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            LoginController logc = new LoginController();
            CustomerController cusc = new CustomerController();
            String cekUsername = inputUserName.getText();
            String cekPassword = inputPassword.getText();
            String[] valueReturn = logc.login(cekUsername, cekPassword);
            boolean berhasil = false;
            if (!valueReturn[0].equals("") && !valueReturn[1].equals("")) {
                berhasil = true;
            }
            if (berhasil) {
                JOptionPane.showMessageDialog(null, "Login Success");
                f.dispose();
                if (valueReturn[0].equals("customer")) {
                    Customer customer = cusc.getCustomer(cekUsername);
                    new CustomerBranchMenu(customer);
                }else if(valueReturn[0].equals("staff")){
//                    new StaffMainMenu();
                }else if(valueReturn[0].equals("manager")){
//                    new ManagerMainMenu();
                }else if(valueReturn[0].equals("boss")){
                    new BossMainMenu();
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed");
            }
        }
        if (e.getSource() == registerButton) {

            f.dispose();
            new Register();
        }

    }
}
