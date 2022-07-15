/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import Controller.ManagerController;
import Model.Staff;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juand
 */
public class ManageGajiStaff implements ActionListener {

    JFrame f = new JFrame("Manage Gaji Staff");
    JLabel inputId;
    JTable table;
    JButton submit, back;
    JTextField inputIdStaff;
    ManagerController control = new ManagerController();

    public ManageGajiStaff() {
        int idCabang = 1;
        String[] column = {"idStaff", "firstName", "lastName", "userName", "telepon", "email", "gaji"};
        String[][] data = control.tableStaff(idCabang);
        DefaultTableModel model = new DefaultTableModel(data, column);
        table = new JTable(model);
        table.setShowGrid(true);
        JScrollPane pane = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(pane);
        inputId = new JLabel("Input ID Staff yang ingin diubah gajinya: ");
        inputId.setBounds(100, 500, 200, 50);
        panel.add(inputId);
        inputIdStaff = new JTextField("Input Here");
        panel.add(inputIdStaff);
        submit = new JButton("SUBMIT");
        submit.addActionListener(this);
        panel.add(submit);
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
            case "SUBMIT":
                if (!"Input Here".equals(inputIdStaff.getText())) {
                    f.dispose();
                    int idStaff = Integer.parseInt(inputIdStaff.getText());
                    Staff staff = control.viewGajiStaff(idStaff);
                    new ManageGajiStaff2(staff);
                } else {
                    JOptionPane.showMessageDialog(null, "Input ID Staff Tidak Valid!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }

    }
}
