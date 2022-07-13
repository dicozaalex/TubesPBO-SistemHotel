/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author calvi
 */
import Model.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BosController {

    ConnectDatabase conn = new ConnectDatabase();

    public ArrayList<Double> viewPendapatanTotal() {
        ArrayList<Double> listTotalPerCabang = new ArrayList<>();
        int i = 1;
        CabangController cabang = new CabangController();
        int jumlahCabang = cabang.countCabang();
        while (i < jumlahCabang) {
            String query = "SELECT totalBayar FROM transaksi WHERE idCabang=" + i;
            conn.connect();
            try {
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                double total = 0;
                while (rs.next()) {
                    total += rs.getDouble("totalBayar");
                }
                listTotalPerCabang.add(total);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        conn.disconnect();
        return listTotalPerCabang;
    }

    public String addCabang(String lokasiCabang, String alamatCabang, Manager manager) {
        String queryCabang = "INSERT INTO cabang(lokasiCabang,alamatCabang)"
                + "VALUES('" + lokasiCabang + "','" + alamatCabang + "')";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeQuery(queryCabang);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        int idCabang = 0;
        String queryGetIdCabang = "SELECT idCabang FROM cabang WHERE lokasiCabang="+lokasiCabang+" AND alamatCabang="+alamatCabang+")";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(queryGetIdCabang);
            idCabang = rs.getInt("idCabang");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String firstName = manager.getFirstname();
        String lastName = manager.getLastname();
        String username = manager.getUsername();
        String password = manager.getPassword();
        String telepon = manager.getTelp();
        String email = manager.getEmail();
        String queryManager = "INSERT INTO manager(idCabang, firstName, lastName, userName, password, telepon, email, statusUser)"
                + "VALUES('"+idCabang+"','"+firstName+"','"+lastName+"','"+username+"','"+password+"','"+telepon+"','"+email+"','MANAGER')";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeQuery(queryManager);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        int idJenisUser = 0;
        String queryGetIdJenisUser = "SELECT idJenisUser FROM manager WHERE userName="+username;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(queryGetIdJenisUser);
            idJenisUser = rs.getInt("idJenisUser");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String queryUser = "INSERT INTO users(idJenisUser,userName,password,statusUser)"
                + "VALUES('"+idJenisUser+"'+"+username+"','"+password+"','MANAGER')";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(queryUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
