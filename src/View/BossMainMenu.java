/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Controller.*;
import Model.*;
import java.awt.Font;

public class BossMainMenu extends JFrame implements ActionListener {

    JFrame f = new JFrame("Menu Boss");
    BosController bosc = new BosController();
    Font judulFont = new Font("Serif", Font.BOLD, 36);
    JButton buttonPendapatan, buttonAddCabang,buttonExit;
    JLabel helo;

    BossMainMenu(String nama){
        
        helo = new JLabel("Hello, "+nama);
        helo.setFont(judulFont);
        buttonPendapatan = new JButton("View Pendapatan Total Cabang");
        buttonAddCabang = new JButton("Add Cabang Baru");
        buttonExit = new JButton("Exit");
        helo.setBounds(30,50,230,40);
        buttonPendapatan.setBounds(60,120,260,40);
        buttonAddCabang.setBounds(60,180,260,40);
        buttonExit.setBounds(60,240,260,40);
        buttonPendapatan.addActionListener(this);
        buttonAddCabang.addActionListener(this);
        buttonExit.addActionListener(this);
        
        f.add(helo);
        f.add(buttonPendapatan);
        f.add(buttonAddCabang);
        f.add(buttonExit);
        
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonPendapatan) {
            JOptionPane.showMessageDialog(null, bosc.viewPendapatanTotal());
        }
        if (e.getSource() == buttonAddCabang) {
            f.dispose();
            String[] arrayKosong = {"",""};
            new AddCabangBaru(arrayKosong);
        }
        if(e.getSource()==buttonExit){
            f.dispose();
        }
    }
}
