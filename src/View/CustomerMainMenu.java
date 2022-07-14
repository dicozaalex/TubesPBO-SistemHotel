package View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import Model.*;

public class CustomerMainMenu {
    public CustomerMainMenu(Customer customer, int selectedCabangHotel) {
        JFrame f = new JFrame("Main Menu");
        JLabel welcomeLabel = new JLabel("Welcome to Hotel");
        JLabel menuLabel = new JLabel("Please Select Your Menu");

        welcomeLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        welcomeLabel.setBounds(100, 20, 300, 20);
        f.add(welcomeLabel);

        menuLabel.setFont(new Font("Arial", Font.ITALIC, 15));
        menuLabel.setBounds(20, 50, 300, 20);
        f.add(menuLabel);

        JButton bookButton = new JButton("1. Book");
        JButton memberButton = new JButton("2. Join Member");
        JButton saldoButton = new JButton("3. Check Saldo");
        JButton updateButton = new JButton("4. Update your Profile");
        JButton backButton = new JButton("Back");
        JButton logoutButton = new JButton("Logout");

        bookButton.setHorizontalAlignment(SwingConstants.LEFT);
        memberButton.setHorizontalAlignment(SwingConstants.LEFT);
        saldoButton.setHorizontalAlignment(SwingConstants.LEFT);
        updateButton.setHorizontalAlignment(SwingConstants.LEFT);

        bookButton.setBounds(35, 120, 325, 30);
        memberButton.setBounds(35, 160, 325, 30);
        saldoButton.setBounds(35, 200, 325, 30);
        updateButton.setBounds(35, 240, 325, 30);
        backButton.setBounds(200, 280, 150, 30);
        logoutButton.setBounds(50, 280, 150, 30);

        f.add(bookButton);
        f.add(memberButton);
        f.add(saldoButton);
        f.add(updateButton);
        f.add(backButton);
        f.add(logoutButton);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Booking(customer, selectedCabangHotel);
                f.dispose();
            }
        });

        memberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JoinMember(customer, selectedCabangHotel);
                f.dispose();
            }
        });

        saldoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckSaldo(customer, selectedCabangHotel);
                f.dispose();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateProfile(customer, selectedCabangHotel);
                f.dispose();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerBranchMenu(customer);
                f.dispose();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                f.dispose();
            }
        });

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

    }
}
