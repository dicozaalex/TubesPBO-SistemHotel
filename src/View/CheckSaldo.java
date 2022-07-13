package View;

import Controller.LoginController;
import javax.swing.*;
import java.awt.event.*;
import Model.Customer;


public class CheckSaldo {
    public CheckSaldo(Customer customer) {
        
        JFrame f = new JFrame("Check Saldo");
        JLabel welcomeLabel = new JLabel("Welcome to Hotel");
        JLabel menuLabel = new JLabel("Please Select Your Menu");

   
        welcomeLabel.setBounds(100, 20, 300, 20);
        f.add(welcomeLabel);

        menuLabel.setBounds(20, 90, 300, 20);
        f.add(menuLabel);

        JLabel saldoLabel = new JLabel("Saldo Anda: " + customer.getSaldoWallet());
        saldoLabel.setBounds(20, 140, 300, 20);
        f.add(saldoLabel);

        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 240, 150, 30);
        f.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CustomerMainMenu(customer);
                f.dispose();
            }
        });

        JButton isiButton = new JButton("Isi Saldo");
        isiButton.setBounds(35, 180, 325, 30);
        f.add(isiButton);

        isiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isiSaldo(customer);
                f.dispose();
            }
        });

        f.setSize(400, 350);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void isiSaldo(Customer customer) {
        JFrame f = new JFrame("Isi Saldo");
        JLabel welcomeLabel = new JLabel("Welcome to Hotel");
        JLabel menuLabel = new JLabel("Please Select Your Menu");
        
        welcomeLabel.setBounds(100, 20, 300, 20);
        f.add(welcomeLabel);

        menuLabel.setBounds(20, 90, 300, 20);
        f.add(menuLabel);

        JLabel cardLabel = new JLabel("Masukkan Nomor Kartu Anda");
        cardLabel.setBounds(35, 140, 300, 20);
        f.add(cardLabel);

        JTextField cardField = new JTextField();
        cardField.setBounds(35, 160, 300, 30);
        f.add(cardField);

        JLabel pinLabel = new JLabel("Masukkan PIN Anda");
        pinLabel.setBounds(35, 200, 300, 20);
        f.add(pinLabel);

        JTextField pinField = new JTextField();
        pinField.setBounds(35, 220, 300, 30);
        f.add(pinField);

        JLabel saldoLabel = new JLabel("Masukkan Saldo");
        saldoLabel.setBounds(35, 260, 300, 20);
        f.add(saldoLabel);

        JTextField saldoField = new JTextField();
        saldoField.setBounds(35, 280, 300, 30);
        f.add(saldoField);

        JButton topupButton = new JButton("Top Up");
        topupButton.setBounds(40, 320, 140, 30);
        f.add(topupButton);

        topupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String card = cardField.getText();
                String pin = pinField.getText();
                double saldo = Double.parseDouble(saldoField.getText());
                LoginController loginController = new LoginController();
                boolean cekTopUp = loginController.topUp(card, pin, saldo, customer.getUsername(), customer.getSaldoWallet());
                if (cekTopUp) {
                    JOptionPane.showMessageDialog(null, "Top Up Success");
                    f.dispose();
                    new CustomerMainMenu(customer);
                } else {
                    JOptionPane.showMessageDialog(null, "Top Up Failed");
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(180, 320, 140, 30);
        f.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CustomerMainMenu(customer);
                f.dispose();
            }
        });


        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
