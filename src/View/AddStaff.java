/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ManagerController;
import Model.EnumStatusUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import Model.Staff;

/**
 *
 * @author juand
 */
public class AddStaff implements ActionListener{

    JFrame f = new JFrame("Add Staff");
    JLabel judul, firstName, lastName, userName, password, telpon, email, gaji, cabang;
    JTextField inputFirstName, inputLastName, inputCabang, inputUserName, inputTelepon, inputEmail, inputGaji;
    JPasswordField inputPassword;
    JButton submit, back;
    ManagerController control = new ManagerController();

    public AddStaff() {
        int idCabang = 1;
        judul = new JLabel("Silahkan Input data dibawah ini...");
        judul.setBounds(200, 50, 300, 30);
        f.add(judul);
        cabang = new JLabel("Cabang: ");
        cabang.setBounds(400, 100, 100, 30);
        f.add(cabang);
        inputCabang = new JTextField(""+idCabang);
        inputCabang.setBounds(500, 100, 100, 30);
        inputCabang.disable();
        f.add(inputCabang);
        firstName = new JLabel("First Name: ");
        firstName.setBounds(30, 100, 100, 30);
        f.add(firstName);
        inputFirstName = new JTextField();
        inputFirstName.setBounds(150, 100, 200, 30);
        f.add(inputFirstName);
        lastName = new JLabel("Last Name: ");
        lastName.setBounds(30, 150, 100, 30);
        f.add(lastName);
        inputLastName = new JTextField();
        inputLastName.setBounds(150, 150, 200, 30);
        f.add(inputLastName);
        userName = new JLabel("UserName: ");
        userName.setBounds(30, 200, 100, 30);
        f.add(userName);
        inputUserName = new JTextField();
        inputUserName.setBounds(150, 200, 200, 30);
        f.add(inputUserName);
        password = new JLabel("Password: ");
        password.setBounds(30, 250, 100, 30);
        f.add(password);
        inputPassword = new JPasswordField();
        inputPassword.setBounds(150, 250, 200, 30);
        f.add(inputPassword);
        telpon = new JLabel("Telepon: ");
        telpon.setBounds(30, 300, 100, 30);
        f.add(telpon);
        inputTelepon = new JTextField();
        inputTelepon.setBounds(150, 300, 200, 30);
        f.add(inputTelepon);
        email = new JLabel("Email: ");
        email.setBounds(30, 350, 100, 30);
        f.add(email);
        inputEmail = new JTextField();
        inputEmail.setBounds(150, 350, 200, 30);
        f.add(inputEmail);
        gaji = new JLabel("Gaji: ");
        gaji.setBounds(30, 400, 100, 30);
        f.add(gaji);
        inputGaji = new JTextField();
        inputGaji.setBounds(150, 400, 200, 30);
        f.add(inputGaji);
        submit = new JButton("SUBMIT");
        submit.setBounds(150, 450, 100, 50);
        f.add(submit);
        submit.addActionListener(this);
        back = new JButton("BACK");
        back.setBounds(30, 450, 100, 50);
        f.add(back);
        back.addActionListener(this);
        f.setSize(800, 550);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String com = evt.getActionCommand();
        f.dispose();
        switch(com){
            case "SUBMIT":
                Staff staff = new Staff();
                int cabang = Integer.parseInt(inputCabang.getText());
                staff.setCabang(cabang);
                staff.setFirstname(inputFirstName.getText());
                staff.setLastname(inputLastName.getText());
                staff.setUsername(inputUserName.getText());
                staff.setPassword(inputPassword.getText());
                staff.setTelp(inputTelepon.getText());
                staff.setEmail(inputEmail.getText());
                double gajiStaff = Double.parseDouble(inputGaji.getText());
                staff.setGaji(gajiStaff);
                staff.setStatus(EnumStatusUser.STAFF);
                boolean done = control.addStaff(staff);
                if (done) {
                    JOptionPane.showMessageDialog(null, "Add Staff Berhasil...");
                    new ManagerMainMenu();
                }else{
                    JOptionPane.showMessageDialog(null, "Add Staff gagal, username sudah ada...", "ERROR", JOptionPane.ERROR_MESSAGE);
                    new AddStaff();
                }
                break;
            case "BACK":
                new ManagerMainMenu();
                break;
        }
    }
}
