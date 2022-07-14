/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import Controller.ManagerController;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import Controller.ManagerController;
import Model.EnumRoom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juand
 */
public class AddRoomHotel implements ActionListener{

    JFrame f = new JFrame("Add R0om Hotel");
    JLabel judul, lNomorRoom, lStatus, lJenis;
    JTextField nomorRoom, cabang;
    JButton submit;
    JComboBox jenisRoom;
    ManagerController control = new ManagerController();

    public AddRoomHotel() {
        int idCabang = 1;
        judul = new JLabel("Input data-data dibawah");
        judul.setBounds(200, 50, 300, 30);
        f.add(judul);
        lNomorRoom = new JLabel("Nomor room: ");
        lNomorRoom.setBounds(30, 100, 100, 30);
        f.add(lNomorRoom);
        nomorRoom = new JTextField();
        nomorRoom.setBounds(150, 100, 100, 30);
        f.add(nomorRoom);
        lStatus = new JLabel("Cabang: ");
        lStatus.setBounds(30, 150, 100, 30);
        f.add(lStatus);
        cabang = new JTextField(""+idCabang);
        cabang.setBounds(150, 150, 100, 30);
        cabang.disable();
        f.add(cabang);
        lJenis = new JLabel("Input jenis room: ");
        lJenis.setBounds(30, 200, 100, 30);
        f.add(lJenis);
        String[] arrJenis = control.cekJenis(idCabang);
        jenisRoom = new JComboBox(arrJenis);
        jenisRoom.setBounds(150, 200, 100, 30);
        f.add(jenisRoom);
        submit = new JButton("SUBMIT");
        submit.setBounds(150, 250, 100, 50);
        f.add(submit);
        submit.addActionListener(this);
        f.setSize(800, 550);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int noRoom = Integer.parseInt(nomorRoom.getText());
        int inputCabang = Integer.parseInt(cabang.getText());
        String jenis = jenisRoom.getSelectedItem().toString();
        boolean done = control.addRoom(noRoom,jenis,inputCabang);
        if (done) {
            JOptionPane.showMessageDialog(null, "Tambah Room Berhasil...");
            f.dispose();
            new ManagerMainMenu();
        }else{
            JOptionPane.showMessageDialog(null, "Input Room GAGAL...", "ERROR", JOptionPane.ERROR_MESSAGE);
            new ManagerMainMenu();
        }
    }
}
