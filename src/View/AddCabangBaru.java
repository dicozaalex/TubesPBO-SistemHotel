/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import java.awt.event.*;
import Model.*;
public class AddCabangBaru extends JFrame implements ActionListener{
    JFrame f = new JFrame("Add Cabang");
    JLabel labLokasi, labAlamat, errormessage;
    JTextField valueLokasi, valueAlamat;
    JButton buttonNext,buttonBack;
    String[] valueBawa = new String[2];
    AddCabangBaru(String[] valuePrev){
        
        labLokasi = new JLabel("Lokasi : ");
        labAlamat = new JLabel("Alamat : ");
        errormessage = new JLabel("Terdapat field kosong");
        valueLokasi = new JTextField(valuePrev[0]);
        valueAlamat = new JTextField(valuePrev[1]);
        buttonNext = new JButton("Next");
        buttonBack = new JButton("Back");
        
        labLokasi.setBounds(60,50,60,40);
        labAlamat.setBounds(60,100,60,40);
        valueLokasi.setBounds(120, 50, 200, 40);
        valueAlamat.setBounds(120, 100, 200, 40);
        buttonNext.setBounds(225, 150, 95, 40);
        buttonBack.setBounds(120, 150, 95, 40);
        errormessage.setBounds(200,200, 200, 40);
        
        errormessage.setVisible(false);
        
        f.add(labLokasi);
        f.add(labAlamat);
        f.add(valueLokasi);
        f.add(valueAlamat);
        f.add(buttonNext);
        f.add(buttonBack);
        f.add(errormessage);
        
        buttonNext.addActionListener(this);
        buttonBack.addActionListener(this);
        
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNext) {
            valueBawa[0] = valueLokasi.getText();
            valueBawa[1] = valueAlamat.getText();
            if(!valueBawa[0].equals("")&&!valueBawa[1].equals("")){
                f.dispose();
                new AddManagerBaru(valueBawa);
            }else{
                errormessage.setVisible(true);
            }
        }
        if(e.getSource() == buttonBack){
            f.dispose();
            Boss bos = new Boss();
            new BossMainMenu(bos.getUsername());
        }
    }
}
