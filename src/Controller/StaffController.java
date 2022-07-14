package Controller;

import Model.CabangHotel;
import Model.Extra;
import Model.Voucher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                + "persenVoucher=" + voucher.getPersenVoucher() + " WHERE idVoucher=" + voucher.getIdVoucher();
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

    public static List<List<String>> getAllExtras() {
        List<List<String>> hasil = new ArrayList<>();
        List<String> extras = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM extra";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                extras.clear();
                extras.add(String.valueOf(resultSet.getInt("idExtra")));
                extras.add(resultSet.getString("namaExtra"));
                extras.add(String.valueOf(resultSet.getInt("idCabang")));
                extras.add(String.valueOf(resultSet.getDouble("hargaExtra")));
                hasil.add(extras);
            }
            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
        }
        return hasil;
    }

    public static boolean addExtra(Extra extra) {
        conn.connect();
        String query = "INSERT INTO extra (idCabang, namaExtra, hargaExtra) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, extra.getIdCabang());
            stmt.setString(2, extra.getNamaExtra());
            stmt.setDouble(3, extra.getHargaExtra());
            stmt.executeUpdate();
            conn.disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return false;
        }
    }

    public static boolean deleteExtra(int idExtra) {
        conn.connect();
        String query = "DELETE FROM extra WHERE idExtra=" + idExtra;
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

    public static boolean updateExtra(Extra extra) {
        conn.connect();
        String query = "UPDATE extra SET idCabang=" + extra.getIdCabang() + ", namaExtra='" + extra.getNamaExtra() + "', "
                + "hargaExtra=" + extra.getHargaExtra() + " WHERE idExtra=" + extra.getIdExtra();
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

    public static List<List<String>> getAllVouchers() {
        List<List<String>> hasil = new ArrayList<>();
        List<String> voucher = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM voucher";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                voucher.clear();
                voucher.add(String.valueOf(resultSet.getInt("idVoucher")));
                voucher.add(resultSet.getString("namaVoucher"));
                voucher.add(String.valueOf(resultSet.getDouble("persenVoucher")));
                hasil.add(voucher);
            }
            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
        }
        return hasil;
    }

    public static String[] getIdCabang(ArrayList<CabangHotel> cabangHotels) {
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < cabangHotels.size(); i++) {
            ids.add(cabangHotels.get(i).getIdCabang());
        }
        String[] allIdCabang = new String[ids.size()];
        for (int i = 0; i < allIdCabang.length; i++) {
            allIdCabang[i] = String.valueOf(ids.get(i));
        }
        return allIdCabang;
    }
}

