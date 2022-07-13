package Controller;

import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.*;

public class LoginController {
    static ConnectDatabase conn=new ConnectDatabase();

    public LoginController() {
    }

    public boolean cekUsername(String username) {
        conn.connect();
        ArrayList<Customer> customers = getAllCustomers();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public boolean register(String username, String firstname, String lastname, String password, String email,
            String phone) {
        conn.connect();
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
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean login(String username, String password) {
        conn.connect();
        String query = "SELECT * FROM customer WHERE userName='" + username + "'&&password='" + password + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("userName").equals(username) && rs.getString("password").equals(password)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM customer";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setIdCustomer(rs.getInt("idCustomer"));
                customer.setFirstname(rs.getString("firstName"));
                customer.setLastname(rs.getString("lastName"));
                customer.setUsername(rs.getString("userName"));
                customer.setPassword(rs.getString("password"));
                customer.setEmail(rs.getString("email"));
                customer.setTelp(rs.getString("telepon"));
                customer.setSaldoWallet(rs.getDouble("saldoWallet"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (customers);
    }
}