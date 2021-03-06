package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.*;

public class CustomerController {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public CustomerController() {
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

    public static Customer getCustomer(String username) {
        conn.connect();
        String query = "SELECT * FROM customer WHERE userName='" + username + "'";
        Customer customer = new Customer();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                customer.setIdCustomer(rs.getInt("idCustomer"));
                customer.setFirstname(rs.getString("firstName"));
                customer.setLastname(rs.getString("lastName"));
                customer.setUsername(rs.getString("userName"));
                customer.setPassword(rs.getString("password"));
                customer.setEmail(rs.getString("email"));
                customer.setTelp(rs.getString("telepon"));
                customer.setSaldoWallet(rs.getDouble("saldoWallet"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (customer);
    }

    public static ArrayList<ATMCard> getAllATM() {
        ArrayList<ATMCard> atmCards = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM atm";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ATMCard atmCard = new ATMCard();
                atmCard.setCardNumber(rs.getString("cardNumber"));
                atmCard.setSaldo(rs.getDouble("saldo"));
                atmCard.setPin(rs.getInt("pin"));
                atmCards.add(atmCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (atmCards);
    }

    public boolean cekCardNumber(String cardNumber, String pin) {
        conn.connect();
        ArrayList<ATMCard> atmCards = getAllATM();
        for (int i = 0; i < atmCards.size(); i++) {
            if (atmCards.get(i).getCardNumber().equals(cardNumber)
                    && atmCards.get(i).getPin() == Integer.parseInt(pin)) {
                return true;
            }
        }
        return false;
    }

    public void setSaldoAtm(double saldo, String cardNumber) {
        double saldoAwal = 0;
        ArrayList<ATMCard> atmCards = getAllATM();
        for (int i = 0; i < atmCards.size(); i++) {
            if (atmCards.get(i).getCardNumber().equals(cardNumber)) {
                saldoAwal = atmCards.get(i).getSaldo();
                break;
            }
        }
        conn.connect();
        String query = "UPDATE atm SET saldo=? WHERE cardNumber=?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setDouble(1, saldoAwal - saldo);
            stmt.setString(2, cardNumber);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean topUp(double saldo, String username, double saldoAwal, String cardNumber) {
        conn.connect();
        String query = "UPDATE customer SET saldoWallet=? WHERE userName=?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setDouble(1, saldoAwal + saldo);
            stmt.setString(2, username);
            stmt.executeUpdate();
            getCustomer(username);
            setSaldoAtm(saldo, cardNumber);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean changePassword(String oldPass, String newPass, Customer customer) {
        if (oldPass.equals(customer.getPassword())) {
            conn.connect();
            String query = "UPDATE customer SET password=? WHERE userName=?";
            try {
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setString(1, newPass);
                stmt.setString(2, customer.getUsername());
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }
        } else {
            return false;
        }
    }

    public boolean updateProfile(String username, String firstname, String lastname, String email, String phone,
            Customer customer) {
        conn.connect();
        boolean cek = cekUsername(username);
        if (cek) {
            String query = "UPDATE customer SET userName=?, firstName=?, lastName=?, email=?, telepon=? WHERE userName=?";
            try {
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, firstname);
                stmt.setString(3, lastname);
                stmt.setString(4, email);
                stmt.setString(5, phone);
                stmt.setString(6, customer.getUsername());
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return (false);
            }
        } else {
            return false;
        }
    }

    public boolean cekMembership(String username) {
        conn.connect();
        String query = "SELECT * FROM customer WHERE userName='" + username + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                if (rs.getString("statusMember").equals("MEMBER")) {
                    return true;
                }
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean joinMembership(Customer customer, double price) {
        conn.connect();
        String query = "UPDATE customer SET statusMember=?, saldoWallet=? WHERE userName=?";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, "MEMBER");
            stmt.setDouble(2, customer.getSaldoWallet() - price);
            stmt.setString(3, customer.getUsername());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
