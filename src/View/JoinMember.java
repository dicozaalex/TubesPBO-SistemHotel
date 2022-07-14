package View;

import Controller.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Font;

import Model.*;

public class JoinMember {
    public JoinMember(Customer customer, int selectedCabangHotel) {
        StaffController staffController = new StaffController();
        LoginController loginController = new LoginController();
        JFrame f = new JFrame("Join Member");
        JLabel welcomeLabel = new JLabel("Welcome to Hotel");
        JLabel menuLabel = new JLabel("Please Select Your Menu");

        welcomeLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        welcomeLabel.setBounds(100, 20, 300, 20);
        f.add(welcomeLabel);

        menuLabel.setFont(new Font("Arial", Font.ITALIC, 15));
        menuLabel.setBounds(20, 50, 300, 20);
        f.add(menuLabel);

        boolean cekMember = loginController.cekMembership(customer.getUsername());
        if (!cekMember) {
            JLabel benefitLabel = new JLabel("Benefit Membership");
            benefitLabel.setBounds(20, 80, 300, 20);
            f.add(benefitLabel);

            ArrayList<Extra> benefit = staffController.getExtras(selectedCabangHotel);
            double price = 0;
            for (int i = 0; i < benefit.size(); i++) {
                JLabel benefitName = new JLabel(benefit.get(i).getNamaExtra());
                benefitName.setBounds(20, 120 + i * 15, 300, 20);
                f.add(benefitName);
                price += benefit.get(i).getHargaExtra();
            }

            final double finalPrice = price;

            JLabel benefitPrice = new JLabel("Price " + price);
            benefitPrice.setBounds(20,210, 300, 20);
            f.add(benefitPrice);

            JButton joinButton = new JButton("Join");
            joinButton.setBounds(150, 210, 200, 25);
            f.add(joinButton);

            joinButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (customer.getSaldoWallet() < finalPrice) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    } else {
                        boolean cekJoinMember = loginController.joinMembership(customer, finalPrice);
                        if (cekJoinMember) {
                            JOptionPane.showMessageDialog(null, "Join Membership Success");
                            f.dispose();
                            new CustomerMainMenu(customer, selectedCabangHotel);
                        } else {
                            JOptionPane.showMessageDialog(null, "Join Membership Failed");
                        }
                    }
                }
            });

        } else {
            JLabel benefitLabel = new JLabel("You are already a member");
            benefitLabel.setBounds(20, 200, 300, 20);
            f.add(benefitLabel);
            benefitLabel.setFont(new Font("Arial", Font.ITALIC, 12));

            JLabel listBenefitLabel = new JLabel("List Benefit");
            listBenefitLabel.setBounds(20, 120, 300, 20);
            f.add(listBenefitLabel);
            listBenefitLabel.setFont(new Font("Arial", Font.BOLD, 14));
            
            ArrayList<Extra> benefit = staffController.getExtras(selectedCabangHotel);
            for (int i = 0; i < benefit.size(); i++) {
                JLabel benefitName = new JLabel(benefit.get(i).getNamaExtra());
                benefitName.setBounds(20, 120 + i * 15, 300, 20);
                f.add(benefitName);
            }

        }
        JButton backButton = new JButton("Back");
        backButton.setBounds(45, 250, 300, 25);
        f.add(backButton);

        backButton.setFont(new java.awt.Font("ARIAL",Font.ITALIC, 12));

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerMainMenu(customer, selectedCabangHotel);
                f.dispose();
            }
        });

        f.setSize(400, 350);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
