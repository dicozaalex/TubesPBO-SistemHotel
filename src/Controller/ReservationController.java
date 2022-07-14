package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JCheckBox;

import Model.*;

public class ReservationController {
    static ConnectDatabase conn = new ConnectDatabase();

    public ReservationController() {
    }

    public static ArrayList<JenisRoom> getAllJenisRoom(int idCabang) {
        ArrayList<JenisRoom> jenisRooms = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM jenisRoom WHERE idCabang=" + idCabang;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                JenisRoom jenisRoom = new JenisRoom();
                jenisRoom.setIdJenisRoom(resultSet.getInt("idJenisRoom"));
                jenisRoom.setIdCabang(resultSet.getInt("idCabang"));
                jenisRoom.setJenisRoom(resultSet.getString("jenisRoom"));
                jenisRoom.setMaksimalOrang(resultSet.getInt("maksimalOrang"));
                jenisRoom.setHargaRoom(resultSet.getInt("harga"));
                jenisRooms.add(jenisRoom);
            }
            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
        }
        return jenisRooms;
    }

    static EnumRoom statusOccupied;

    public ArrayList<Room> getAllRoom(int idCabang) {
        ArrayList<Room> rooms = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM room WHERE idCabang=" + idCabang;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                Room room = new Room();
                room.setIdRoom(resultSet.getInt("idRoom"));
                room.setIdCabang(resultSet.getInt("idCabang"));
                room.setIdJenisRoom(resultSet.getInt("idJenisRoom"));
                room.setNomorRoom(resultSet.getInt("nomorRoom"));
                room.setStatusOccupied(statusOccupied.valueOf(resultSet.getString("status")));
                rooms.add(room);
            }
            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
        }
        return rooms;
    }

    public boolean cekRoom(int selectedCabangHotel, int banyakOrangInt, String jenisRoom) {
        ArrayList<JenisRoom> jenisRooms = getAllJenisRoom(selectedCabangHotel);
        for (int i = 0; i < jenisRooms.size(); i++) {
            if (jenisRooms.get(i).getJenisRoom().equals(jenisRoom)) {
                if (jenisRooms.get(i).getMaksimalOrang() >= banyakOrangInt) {
                    return true;
                }
            }
        }
        return false;
    }

    public double cekHarga(int selectedCabangHotel, boolean member, String jenisRoom, JCheckBox addExtraCheckBox[],
            String voucher, Customer customer, ArrayList<Extra> extras) {
        double hargaRoom = 0;
        ArrayList<JenisRoom> jenisRooms = getAllJenisRoom(selectedCabangHotel);
        for (int i = 0; i < jenisRooms.size(); i++) {
            if (jenisRooms.get(i).getJenisRoom().equals(jenisRoom)) {
                hargaRoom += jenisRooms.get(i).getHargaRoom();
            }
        }
        if (!member) {
            for (int i = 0; i < addExtraCheckBox.length; i++) {
                if (extras.get(i).getNamaExtra().equals(addExtraCheckBox[i].getText())) {
                    hargaRoom += extras.get(i).getHargaExtra();
                }
            }
        }
        ArrayList<Voucher> vouchers = StaffController.getAllVoucher();

        if (voucher != null) {
            for (int i = 0; i < vouchers.size(); i++) {
                if (vouchers.get(i).getNamaVoucher().equals(voucher)) {
                    hargaRoom = hargaRoom + (hargaRoom * vouchers.get(i).getPersenVoucher());
                }
            }
        }

        return hargaRoom;
    }

    public boolean cekSaldoBayar(Customer customer, double hargaRoom) {
        double saldo = customer.getSaldoWallet();
        String username = customer.getUsername();
        if (saldo >= hargaRoom) {
            conn.connect();
            String query = "UPDATE customer SET saldoWallet=? WHERE userName=?";
            try {
                PreparedStatement stmt = conn.con.prepareStatement(query);
                stmt.setDouble(1, saldo - hargaRoom);
                stmt.setString(2, username);
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
}
