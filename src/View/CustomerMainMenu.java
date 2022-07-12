package View;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import Controller.CabangController;
import Model.CabangHotel;


public class CustomerMainMenu {
    public CustomerMainMenu(){
        JFrame f = new JFrame("Customer Main Menu");
        ArrayList<CabangHotel> cabangHotel = new ArrayList<CabangHotel>();
        cabangHotel.add(new CabangHotel("Cabang 1", "Jl. Raya", "081234567890"));
        cabangHotel.add(new CabangHotel("Cabang 2", "Jl. Raya", "081234567890"));
        JComboBox inputCabangHotel = new JComboBox(cabangHotel.toArray());
        JButton bookButton = new JButton("Book");

        inputCabangHotel.setBounds(100, 100, 200, 20);
        bookButton.setBounds(100, 200, 100, 20);

        f.add(inputCabangHotel);
        f.add(bookButton);

        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu();;
                f.dispose();
            }
        });

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

    }
    public void mainMenu(){
        JFrame f = new JFrame("Main Menu");
        JLabel bookLabel = new JLabel("Booking");
        JLabel memberLabel = new JLabel("Member");
        JLabel saldoLabel = new JLabel("Saldo");

        JButton bookButton = new JButton("Book");
        JButton memberButton = new JButton("Member");
        JButton saldoButton = new JButton("Saldo");

        bookLabel.setBounds(5, 30, 200, 20);
        bookButton.setBounds(75, 30, 200, 20);
        memberLabel.setBounds(5, 50, 200, 20);
        memberButton.setBounds(75, 50, 200, 20);
        saldoLabel.setBounds(5, 70, 200, 20);
        saldoButton.setBounds(75, 70, 200, 20);

        f.add(bookLabel);
        f.add(bookButton);
        f.add(memberLabel);
        f.add(memberButton);
        f.add(saldoLabel);
        f.add(saldoButton);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

    }
}
