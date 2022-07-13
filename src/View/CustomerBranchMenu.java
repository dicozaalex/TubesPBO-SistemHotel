package View;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import com.mysql.cj.xdevapi.SelectStatement;

import Controller.CabangController;
import Model.*;

public class CustomerBranchMenu {
    public CustomerBranchMenu(Customer customer) {
        JFrame f = new JFrame("Customer Main Menu");
        JLabel welcomeLabel = new JLabel("Please Select Your Branch");

        welcomeLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        welcomeLabel.setBounds(70, 20, 300, 20);
        f.add(welcomeLabel);

        JLabel branchLabel = new JLabel("Select Branch");
        branchLabel.setBounds(70, 80, 300, 20);
        f.add(branchLabel);

        CabangController cabangController = new CabangController();
        ArrayList<CabangHotel> cabangHotels = cabangController.getAllCabangs();

        String[] cabangHotel = new String[cabangHotels.size()];
        for (int i = 0; i < cabangHotels.size(); i++) {
            cabangHotel[i] = cabangHotels.get(i).getLokasiCabang();
        }

        JComboBox inputCabangHotel = new JComboBox(cabangHotel);
        JButton bookButton = new JButton("Book");

        inputCabangHotel.setBounds(70, 100, 250, 25);
        bookButton.setBounds(70, 130, 250, 30);

        inputCabangHotel.setFont(new Font("Arial", Font.BOLD, 12));
        bookButton.setFont(new Font("Arial", Font.ITALIC, 12));

        f.add(inputCabangHotel);
        f.add(bookButton);

        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedCabangHotel = inputCabangHotel.getSelectedIndex();
                new CustomerMainMenu(customer, selectedCabangHotel);
                f.dispose();
            }
        });

        f.setSize(400, 350);
        f.setLayout(null);
        f.setVisible(true);

    }
}
