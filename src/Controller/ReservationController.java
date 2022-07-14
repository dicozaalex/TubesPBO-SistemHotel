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
                jenisRoom.setMaksimalOrang(resultSet.getInt("maksOrang"));
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

    public int takeRoom(int selectedCabangHotel, String jenisRoom){
        ArrayList<Room> rooms = getAllRoom(selectedCabangHotel);
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getIdJenisRoom() == getIdJenisRoom(selectedCabangHotel, jenisRoom)) {
                if (rooms.get(i).getStatusOccupied() == EnumRoom.NOT_OCCUPIED) {
                    return rooms.get(i).getNomorRoom();
                }
            }
        }
        return 0;
    }

    public int takeIdRoom(int selectedCabangHotel, String jenisRoom){
        ArrayList<Room> rooms = getAllRoom(selectedCabangHotel);
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getIdJenisRoom() == getIdJenisRoom(selectedCabangHotel, jenisRoom)) {
                if (rooms.get(i).getStatusOccupied() == EnumRoom.NOT_OCCUPIED) {
                    return rooms.get(i).getIdRoom();
                }
            }
        }
        return 0;
    }

    public void setStatusOccupied(int selectedCabangHotel, String jenisRoom, int nomorRoom) {
        conn.connect();
        String query = "UPDATE room SET status='" + EnumRoom.OCCUPIED + "' WHERE idCabang=" + selectedCabangHotel + " AND idJenisRoom=" + getIdJenisRoom(selectedCabangHotel, jenisRoom) + " AND nomorRoom=" + nomorRoom;
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
        }
    }


    public int getIdJenisRoom(int selectedCabangHotel, String jenisRoom) {
        ArrayList<JenisRoom> jenisRooms = getAllJenisRoom(selectedCabangHotel);
        for (int i = 0; i < jenisRooms.size(); i++) {
            if (jenisRooms.get(i).getJenisRoom().equals(jenisRoom)) {
                return jenisRooms.get(i).getIdJenisRoom();
            }
        }
        return 0;
    }

    

    public double cekHarga(int selectedCabangHotel, boolean member, String jenisRoom, JCheckBox addExtraCheckBox[],
            String voucher, Customer customer, ArrayList<Extra> extras, int lamaInap) {
        double hargaRoom = 0;
        ArrayList<JenisRoom> jenisRooms = getAllJenisRoom(selectedCabangHotel);
        for (int i = 0; i < jenisRooms.size(); i++) {
            if (jenisRooms.get(i).getJenisRoom().equals(jenisRoom)) {
                hargaRoom = jenisRooms.get(i).getHargaRoom() * lamaInap;
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

    public void setTransaksi(Customer customer, String tanggalCheckIn, String tanggalCheckOut, int banyakOrang, int idRoom, double totalHarga) {
        conn.connect();
        String query = "INSERT INTO transaksi (idCustomer, tanggalCheckIn, tanggalCheckOut, banyakOrang, idRoom, totalHarga) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, customer.getIdCustomer());
            stmt.setString(2, tanggalCheckIn);
            stmt.setString(3, tanggalCheckOut);
            stmt.setInt(4, banyakOrang);
            stmt.setInt(5, idRoom);
            stmt.setDouble(6, totalHarga);
            stmt.executeUpdate();
            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
        }
    }
}
