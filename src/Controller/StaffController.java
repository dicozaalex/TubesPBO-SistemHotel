package Controller;

import Model.Extra;
import Model.Voucher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StaffController {
    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public static Voucher getVoucher(String namaVoucher) {
        Voucher voucher = new Voucher();
        conn.connect();
        String query = "SELECT * FROM voucher WHERE namaVoucher=(?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, namaVoucher);
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getResultSet();
            while (resultSet.next()) {
                voucher.setIdVoucher(resultSet.getInt("idVoucher"));
                voucher.setNamaVoucher(resultSet.getString("namaVoucher"));
            }
            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
        }
        return voucher;
    }

    public static boolean addVoucher(Voucher voucher) {
        conn.connect();
        String namaVoucher = voucher.getNamaVoucher();
        double persenVoucher = voucher.getPersenVoucher();
        String query = "INSERT INTO voucher (namaVoucher, persenVoucher) VALUES (?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, namaVoucher);
            stmt.setDouble(2, persenVoucher);
            stmt.executeUpdate();
            conn.disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return false;
        }
    }

    public static boolean deleteVoucher(int idVoucher) {
        conn.connect();
        String query = "DELETE FROM voucher WHERE idVoucher=" + idVoucher;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeQuery(query);
            conn.disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return false;
        }
    }

    public static boolean updateVoucher(Voucher voucher) {
        conn.connect();
        String query = "UPDATE voucher SET namaVoucher='" + voucher.getNamaVoucher() + "', "
                + "persenVoucher=" + voucher.getPersenVoucher();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeQuery(query);
            conn.disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return false;
        }
    }

    public static ArrayList<Extra> getExtras(int idCabang) {
        ArrayList<Extra> extras = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM extra WHERE idCabang=" + idCabang;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                Extra extra = new Extra();
                extra.setIdExtra(resultSet.getInt("idExtra"));
                extra.setNamaExtra(resultSet.getString("namaExtra"));
                extra.setIdCabang(resultSet.getInt("idCabang"));
                extra.setHargaExtra(resultSet.getDouble("hargaExtra"));
                extras.add(extra);
            }
            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
        }
        return extras;
    }
}

