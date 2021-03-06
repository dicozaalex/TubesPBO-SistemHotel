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

public class BosController {

    ConnectDatabase conn = new ConnectDatabase();

    public String viewPendapatanTotal() {
        String query = "SELECT totalBayar FROM transaksi";
        conn.connect();
        double total = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                total += rs.getDouble("totalBayar");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        conn.disconnect();
        return "Total Pendapatan Seluruh Cabang : " + total;
    }

    public String addCabang(String lokasiCabang, String alamatCabang, Manager manager) {
        String queryCabang = "INSERT INTO cabang(lokasiCabang,alamatCabang)"
                + "VALUES('" + lokasiCabang + "','" + alamatCabang + "')";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(queryCabang);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        int idCabang = 0;
        String queryGetIdCabang = "SELECT idCabang FROM cabang WHERE lokasiCabang='" + lokasiCabang + "' AND alamatCabang='" + alamatCabang+ "'";
        
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(queryGetIdCabang);
            while (rs.next()) {
                idCabang = rs.getInt("idCabang");
            }
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
                + "VALUES('" + idCabang + "','" + firstName + "','" + lastName + "','" + username + "','" + password + "','" + telepon + "','" + email + "','MANAGER')";
        
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(queryManager);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int idJenisUser = 0;
        String queryGetIdJenisUser = "SELECT idManager FROM manager WHERE userName='" + username+"'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(queryGetIdJenisUser);
            while (rs.next()) {
                idJenisUser = rs.getInt("idManager");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String queryUser = "INSERT INTO users(idJenisUser,userName,password,statusUser)"
                + "VALUES('" + idJenisUser + "','" + username + "','" + password + "','MANAGER')";
        
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(queryUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return "";
    }
}
