/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EnumRoom;
import Model.Reservation;
import Model.Room;
import Model.Staff;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class ManagerController {

    ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public ArrayList<Staff> viewDataStaff(int idCabang) { // bisa buat ngambil cabangnya langsung pas login pake DP kan (?)
        ArrayList<Staff> listStaff = new ArrayList<>();
        String query = "SELECT * FROM staff WHERE idCabang='" + idCabang + "'";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setCabang(rs.getInt("idCabang"));
                staff.setFirstname(rs.getString("firstName"));
                staff.setLastname(rs.getString("lastName"));
                staff.setUsername(rs.getString("userName"));
                staff.setTelp(rs.getString("telepon"));
                staff.setEmail(rs.getString("email"));
                staff.setGaji(rs.getDouble("gaji"));
                listStaff.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return listStaff;
    }

    public boolean addStaff(Staff staff) {
        String queryCek = "SELECT * FROM staff";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(queryCek);
            while (rs.next()) {
                if (staff.getUsername().equals(rs.getString("userName"))) {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "INSERT INTO staff VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, staff.getIdCabang());
            stmt.setString(2, staff.getFirstname());
            stmt.setString(3, staff.getLastname());
            stmt.setString(4, staff.getUsername());
            stmt.setString(5, staff.getPassword());
            stmt.setString(6, staff.getTelp());
            stmt.setString(7, staff.getEmail());
            stmt.setObject(8, staff.getStatus());
            stmt.setObject(9, staff.getGaji());
            stmt.executeUpdate();
            conn.disconnect();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return false;
        }
    }

    public boolean deleteStaff(int idStaff) {
        String query = "DELETE FROM staff WHERE idStaff='" + idStaff + "'";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public boolean viewGajiStaff(int idStaff) {
        String query = "SELECT * FROM staff WHERE idStaff='" + idStaff + "'";
        boolean done = false;
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setCabang(rs.getInt("idCabang"));
                staff.setFirstname(rs.getString("firstName"));
                staff.setLastname(rs.getString("lastName"));
                staff.setUsername(rs.getString("userName"));
                staff.setTelp(rs.getString("telepon"));
                staff.setEmail(rs.getString("email"));
                staff.setGaji(rs.getDouble("gaji"));
                done = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return done;
    }

    public boolean manageGajiStaff(int idStaff, double inputGaji) {
        String query = "UPDATE staff SET gaji='" + inputGaji + "' WHERE idStaff='" + idStaff + "'";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            conn.disconnect();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            conn.disconnect();
            return (false);
        }
    }
    public double viewPendapatanCabang(int idCabang){
//        ArrayList<Reservation>listReservation = new ArrayList<>();
        double total = 0;
        String query = "SELECT totalBayar FROM transaksi WHERE idCabang='"+idCabang+"'";
        conn.connect();
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
        return total;
    }
    public ArrayList<Room> viewRoomHotel(int idCabang){
        ArrayList<Room>listRoom = new ArrayList<>();
        String query = "SELECT * FROM room WHERE idCabang='"+idCabang+"'";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Room room = new Room();
                room.setIdCabang(rs.getInt("idCabang"));
                room.setIdJenisRoom(rs.getInt("idJenisRoom"));
                room.setNomorRoom(rs.getInt("nomorRoom"));
                room.setIdRoom(rs.getInt("idRoom"));
//                room.setStatusOccupied(rs.getObject("status", enumRoom));  ini gk bisa get enum dari databse, caranya gimana
                listRoom.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return listRoom;
    }
    public boolean addRoom(Room room){
        conn.connect();
        String query = "INSERT INTO room (idCabang, idJenisRoom, nomorRoom, status) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, room.getIdCabang());
            stmt.setInt(2, room.getIdJenisRoom());
            stmt.setInt(3, room.getNomorRoom());
            stmt.setObject(4, room.getStatusOccupied());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
