/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author juand
 */
public class ManagerMainMenu implements ActionListener{
    JFrame f = new JFrame("Manager Main Menu");
    JLabel judul;
    JButton manageGaji, updateRoom, viewDataStaff, viewPendapatanCabang, addStaff, deleteStaff;
    public ManagerMainMenu(){
        judul = new JLabel("Selamat Datang Manager");
        judul.setBounds(200, 20, 300, 30);
        f.add(judul);
        manageGaji = new JButton("Manage Gaji Staff");
        manageGaji.setBounds(35, 100, 200, 30);
        f.add(manageGaji);
        manageGaji.addActionListener(this);
        updateRoom = new JButton("Update Room Hotel");
        updateRoom.setBounds(35, 150, 200, 30);
        f.add(updateRoom);
        updateRoom.addActionListener(this);
        viewDataStaff = new JButton("View Data Staff");
        viewDataStaff.setBounds(35, 200, 200, 30);
        f.add(viewDataStaff);
        viewDataStaff.addActionListener(this);
        viewPendapatanCabang = new JButton("View Pendapatan Cabang");
        viewPendapatanCabang.setBounds(300, 100, 200, 30);
        f.add(viewPendapatanCabang);
        viewPendapatanCabang.addActionListener(this);
        addStaff = new JButton("Add Staff");
        addStaff.setBounds(300, 150, 200, 30);
        f.add(addStaff);
        addStaff.addActionListener(this);
        deleteStaff = new JButton("Delete Staff");
        deleteStaff.setBounds(300, 200, 200, 30);
        f.add(deleteStaff);
        deleteStaff.addActionListener(this);
        
        f.setSize(600, 350);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ManagerMainMenu();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String com = evt.getActionCommand();
        f.dispose();
        switch(com){
            case "Manage Gaji Staff":
                new ManageGajiStaff();
                break;
            case "Update Room Hotel":
                new UpdateRoomHotel();
                break;
            case "View Data Staff":
                new ViewDataStaff();
                break;
            case "View Pendapatan Cabang":
                new ViewPendapatanCabang();
                break;
            case "Add Staff":
                new AddStaff();
                break;
            case "Delete Staff":
                new DeleteStaff();
                break;
        }
    }
}
