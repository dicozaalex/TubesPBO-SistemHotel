/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ManagerController;
import Model.Staff;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juand
 */
public class UpdateRoomHotel implements ActionListener{
    JFrame f = new JFrame("Update Room Hotel");
    JTable table;
    JButton addRoom, back;
    ManagerController control = new ManagerController();
    public UpdateRoomHotel(){
        int idCabang = 1;
        String[] column = {"idRoom", "jenisRoom", "maksOrang", "nomorRoom", "hargaRoom", "status"};
        String[][] data = control.viewRoomHotel(idCabang);
        DefaultTableModel model = new DefaultTableModel(data, column);
        table = new JTable(model);
        table.setShowGrid(true);
        JScrollPane pane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(pane);
        addRoom = new JButton("Add Room");
        addRoom.addActionListener(this);
        panel.add(addRoom);
        back = new JButton("BACK");
        back.addActionListener(this);
        panel.add(back);

        f.add(panel);
        f.setSize(1000, 550);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String com = evt.getActionCommand();
        switch (com) {
            case "BACK":
                f.dispose();
                new ManagerMainMenu();
                break;
            case "Add Room":
                f.dispose();
                new AddRoomHotel();
                break;
        }

    }
}
