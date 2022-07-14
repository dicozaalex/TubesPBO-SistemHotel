/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;
import Controller.ManagerController;
public class ViewPendapatanCabang {
    ManagerController control = new ManagerController();
    public ViewPendapatanCabang() {
        int idCabang = 1;
        double total = control.viewPendapatanCabang(idCabang);
        JOptionPane.showMessageDialog(null, "Pendapatan cabang "+idCabang+" adalah: "+total);
        new ManagerMainMenu();
    }
}
