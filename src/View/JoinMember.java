package View;

import Controller.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import Model.*;

public class JoinMember {
    public JoinMember(Customer customer, int selectedCabangHotel) {
        StaffController staffController = new StaffController();
        LoginController loginController = new LoginController();
        JFrame f = new JFrame("Join Member");
        JLabel welcomeLabel = new JLabel("Welcome to Hotel");
        JLabel menuLabel = new JLabel("Please Select Your Menu");

        welcomeLabel.setBounds(100, 20, 300, 20);
        f.add(welcomeLabel);

        menuLabel.setBounds(20, 50, 300, 20);
        f.add(menuLabel);
        boolean cekMember = loginController.cekMembership(customer.getUsername());
        if (!cekMember) {
            JLabel benefitLabel = new JLabel("Benefit Membership");
            benefitLabel.setBounds(20, 120, 300, 20);
            f.add(benefitLabel);
            ArrayList<Extra> benefit = staffController.getExtras(selectedCabangHotel);
            double price = 0;
            for (int i = 0; i < benefit.size(); i++) {
                JLabel benefitName = new JLabel(benefit.get(i).getNamaExtra());
                benefitName.setBounds(20, 150 + i * 30, 300, 20);
                f.add(benefitName);
                price += benefit.get(i).getHargaExtra();
            }

            final double finalPrice = price;

            JLabel benefitPrice = new JLabel("Price" + price);
            benefitPrice.setBounds(20, 150 + benefit.size() * 30, 300, 20);
            f.add(benefitPrice);

            JButton joinButton = new JButton("Join");
            joinButton.setBounds(150, 150 + benefit.size() * 30, 200, 25);
            f.add(joinButton);

            joinButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean cekJoinMember = loginController.joinMembership(customer, finalPrice);
                    if (cekJoinMember) {
                        JOptionPane.showMessageDialog(null, "Join Membership Success");
                        f.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Join Membership Failed");
                    }
                }
            });

        } else {
            JLabel benefitLabel = new JLabel("You are already a member");
            benefitLabel.setBounds(20, 120, 300, 20);
            f.add(benefitLabel);
            
            JLabel listBenefitLabel = new JLabel("List Benefit");
            listBenefitLabel.setBounds(20, 120, 300, 20);
            f.add(listBenefitLabel);
            
            ArrayList<Extra> benefit = staffController.getExtras(selectedCabangHotel);
            for (int i = 0; i < benefit.size(); i++) {
                JLabel benefitName = new JLabel(benefit.get(i).getNamaExtra());
                benefitName.setBounds(20, 150 + i * 30, 300, 20);
                f.add(benefitName);
            }

        }
        JButton backButton = new JButton("Back");
        backButton.setBounds(35, 250, 200, 25);
        f.add(backButton);

        f.setSize(400, 350);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
