/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ManagerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juand
 */
public class ViewDataStaff implements ActionListener{

    JFrame f = new JFrame("View Data Staff");
    JLabel inputId;
    JTable table;
    JButton submit, back;
    JTextField inputIdStaff;
    ManagerController control = new ManagerController();

    public ViewDataStaff() {
        int idCabang = 1;
        String[] column = {"idStaff", "firstName", "lastName", "userName", "telepon", "email", "gaji"};
        String[][] data = control.tableStaff(idCabang);
        DefaultTableModel model = new DefaultTableModel(data, column);
        table = new JTable(model);
        table.setShowGrid(true);
        table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        JScrollPane pane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(pane);
        back = new JButton("BACK");
        back.addActionListener(this);
        panel.add(back);
        
        f.add(panel);
        f.setSize(1000, 550);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        f.dispose();
        new ManagerMainMenu();
    }
}
