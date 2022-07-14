/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author calvi
 */
public class Login2Controller {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public boolean cekUsername(String username) {
        conn.connect();
        String[] users = getAllUsername();
        for (int i = 0; i < users.length; i++) {
            if (users.equals(username)) {
                return false;
            }
        }
        return true;
    }

    public boolean register(String username, String firstname, String lastname, String password, String email,
            String phone) {
        conn.connect();
        int berhasil=0,idLastCustomer = 0;
        String query = "INSERT INTO customer (firstName, lastName,userName, password, telepon, email, statusUser, statusMember, saldoWallet) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, username);
            stmt.setString(4, password);
            stmt.setString(5, phone);
            stmt.setString(6, email);
            stmt.setString(7, "CUSTOMER");
            stmt.setString(8, "NOT_MEMBER");
            stmt.setDouble(9, 0);
            stmt.executeUpdate();
            berhasil++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query2 = "SELECT idCustomer FROM customer WHERE userName=?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query2);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                idLastCustomer = rs.getInt("idCustomer");
            }
            berhasil++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String query3 = "INSERT INTO users (idJenisUser,userName, password,statusUser) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query3);
            stmt.setInt(1, idLastCustomer);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, "CUSTOMER");
            stmt.executeUpdate();
            berhasil++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(berhasil==3){
            return true;
        }else{
            return false;
        }
    }

    public String[] login(String username, String password) {
        conn.connect();
        int urutanUser = 0;
        String jenisUser = "";
        String[] returnValue = new String[2];
        String query = "SELECT * FROM users WHERE userName='" + username + "'&&password='" + password + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
               urutanUser = rs.getInt("idJenisUser");
               jenisUser = rs.getString("statusUser");
            }
            jenisUser = jenisUser.toLowerCase();
            String stringUrutan = String.valueOf(urutanUser);
            returnValue[0] = jenisUser;
            returnValue[1] = stringUrutan;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    
    public static String[] getAllUsername() {
        int count = 0;
        String query = "SELECT * FROM users";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String[] listUsername = new String[count];
        conn.connect();
        String query2 = "SELECT userName FROM users";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query2);
            int i = 0;
            while (rs.next()) {
                listUsername[i] = rs.getString("userName");
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsername;
    }
}
