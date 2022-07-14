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

/**
 *
 * @author juand
 */
public class ManageGajiStaff2 implements ActionListener {

    JFrame f = new JFrame("Manage Gaji Staff");
    JLabel idStaff, inputIdStaff, firstName, lastName, userName, telepon, email, gaji;
    JButton submit;
    JTextField inputGaji;
    ManagerController control = new ManagerController();

    public ManageGajiStaff2(Staff staff) {
        idStaff = new JLabel("ID Staff: " + staff.getIdStaff());
        idStaff.setBounds(30, 50, 50, 30);
        f.add(idStaff);
        inputIdStaff = new JLabel("" + staff.getIdStaff());
        inputIdStaff.setBounds(80, 50, 50, 30);
        f.add(inputIdStaff);
        firstName = new JLabel("First Name: " + staff.getFirstname());
        firstName.setBounds(30, 100, 200, 30);
        f.add(firstName);
        lastName = new JLabel("Last Name: " + staff.getLastname());
        lastName.setBounds(30, 150, 200, 30);
        f.add(lastName);
        userName = new JLabel("Username: " + staff.getUsername());
        userName.setBounds(30, 200, 200, 30);
        f.add(userName);
        telepon = new JLabel("Telepon: " + staff.getTelp());
        telepon.setBounds(30, 250, 200, 30);
        f.add(telepon);
        email = new JLabel("Email: " + staff.getEmail());
        email.setBounds(30, 300, 200, 30);
        f.add(email);
        gaji = new JLabel("Gaji: ");
        gaji.setBounds(30, 350, 50, 30);
        f.add(gaji);
        inputGaji = new JTextField("" + staff.getGaji());
        inputGaji.setBounds(80, 350, 100, 30);
        f.add(inputGaji);
        submit = new JButton("SUBMIT GAJI");
        submit.setBounds(200, 350, 150, 50);
        submit.addActionListener(this);
        f.add(submit);
        f.setSize(800, 550);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        f.dispose();
        int id = Integer.parseInt(inputIdStaff.getText());
        double gajiStaff = Double.parseDouble(inputGaji.getText());
        boolean gantiGaji = control.manageGajiStaff(id, gajiStaff);
        if (gantiGaji) {
            JOptionPane.showMessageDialog(null, "Update Gaji Berhasil");
            new ManagerMainMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Update Gaji Gagal!", "ERROR", JOptionPane.ERROR_MESSAGE);
            new ManageGajiStaff();
        }
    }
}
