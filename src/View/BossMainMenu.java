/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BossMainMenu extends JFrame implements ActionListener {

    JFrame f = new JFrame();

    JButton buttonPendapatan, buttonAddCabang,buttonExit;

    BossMainMenu() {
        
        buttonPendapatan = new JButton("View Pendapatan Total Cabang");
        buttonAddCabang = new JButton("Add Cabang Baru");
        buttonExit = new JButton("Exit");
        buttonPendapatan.setBounds(60,120,260,40);
        buttonAddCabang.setBounds(60,180,260,40);
        buttonExit.setBounds(60,240,260,40);
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
            JOptionPane.showMessageDialog(null, "Hello!");
        }
        if (e.getSource() == buttonAddCabang) {
            f.dispose();
            new AddCabangBaru();
        }
        if(e.getSource()==buttonExit){
            
        }
    }
    public static void main(String[] args) {
        new BossMainMenu();
    }
}
