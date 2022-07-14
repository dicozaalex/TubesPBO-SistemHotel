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

    public boolean addStaff(Staff staff) {
        int idStaff = 0;
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
        String query = "INSERT INTO staff (idCabang, firstName, lastName, userName, password, telepon, email, statusUser, gaji)"
                + " VALUES(?,?,?,?,?,?,?,'" + staff.getStatus() + "',?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, staff.getIdCabang());
            stmt.setString(2, staff.getFirstname());
            stmt.setString(3, staff.getLastname());
            stmt.setString(4, staff.getUsername());
            stmt.setString(5, staff.getPassword());
            stmt.setString(6, staff.getTelp());
            stmt.setString(7, staff.getEmail());
            stmt.setDouble(8, staff.getGaji());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        String queryCekId = "SELECT * FROM staff WHERE username='" + staff.getUsername() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(queryCekId);
            rs.next();
            idStaff = rs.getInt("idStaff");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String queryUser = "INSERT INTO users (idJenisUser, userName, password, statusUser)"
                + "VALUES(?,?,?,'" + staff.getStatus() + "')";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(queryUser);
            stmt.setInt(1, idStaff);
            stmt.setString(2, staff.getUsername());
            stmt.setString(3, staff.getPassword());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStaff(int idStaff) {
        String query = "DELETE FROM staff WHERE idStaff='" + idStaff + "'";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
        String deleteUsers = "DELETE FROM users WHERE idJenisUser='" + idStaff + "'&&statusUser='STAFF'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(deleteUsers);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public String[][] tableStaff(int idCabang) {
        String query = "SELECT * FROM staff WHERE idCabang='" + idCabang + "'";
        String[][] output = null;
        int i = 0;
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                i++;
            }
            output = new String[i][7];
            int i2 = 0;
            ResultSet rs2 = stmt.executeQuery(query);
            while (rs2.next()) {
                int id = rs2.getInt("idStaff");
                output[i2][0] = Integer.toString(id);
                output[i2][1] = rs2.getString("firstName");
                output[i2][2] = rs2.getString("lastName");
                output[i2][3] = rs2.getString("userName");
                output[i2][4] = rs2.getString("telepon");
                output[i2][5] = rs2.getString("email");
                double gaji = rs2.getDouble("gaji");
                output[i2][6] = Double.toString(gaji);
                i2++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    public Staff viewGajiStaff(int idStaff) {
        String query = "SELECT * FROM staff WHERE idStaff='" + idStaff + "'";
        conn.connect();
        Staff staff = new Staff();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                staff.setIdStaff(rs.getInt("idStaff"));
                staff.setCabang(rs.getInt("idCabang"));
                staff.setFirstname(rs.getString("firstName"));
                staff.setLastname(rs.getString("lastName"));
                staff.setUsername(rs.getString("userName"));
                staff.setTelp(rs.getString("telepon"));
                staff.setEmail(rs.getString("email"));
                staff.setGaji(rs.getDouble("gaji"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
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

    public double viewPendapatanCabang(int idCabang) {
        double total = 0;
        String query = "SELECT totalBayar FROM transaksi WHERE idCabang='" + idCabang + "'";
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

    static EnumRoom statusOccupied;

    public String[][] viewRoomHotel(int idCabang) {
        String query = "SELECT * FROM room WHERE idCabang='" + idCabang + "'";
        String[][] output = null;
        int i = 0;
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                i++;
            }
            output = new String[i][6];
            int i2 = 0;
            Statement stmt2 = conn.con.createStatement();
            ResultSet rs2 = stmt2.executeQuery(query);
            while (rs2.next()) {
                int id = rs2.getInt("idRoom");
                output[i2][0] = Integer.toString(id);
                int idJenis = rs2.getInt("idJenisRoom");
                String nomor = Integer.toString(rs2.getInt("nomorRoom"));
                output[i2][3] = nomor;
                output[i2][5] = rs2.getString("status");
                String queryJenisRoom = "SELECT * FROM jenisroom WHERE idJenisRoom='" + idJenis + "'";
                ResultSet rs3 = stmt.executeQuery(queryJenisRoom);
                while (rs3.next()) {
                    output[i2][1] = rs3.getString("jenisRoom");
                    String maks = Integer.toString(rs3.getInt("maksOrang"));
                    output[i2][2] = maks;
                    String harga = Double.toString(rs3.getDouble("harga"));
                    output[i2][4] = harga;
                }
                i2++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    public boolean addRoom(int noRoom, String jenis, int cabang) {
        int idJenis = 0;
        String queryJenis = "SELECT * FROM jenisRoom WHERE idCabang ='"+cabang+"'&&jenisRoom='"+jenis+"'";
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(queryJenis);
            while (rs.next()) {
                idJenis = rs.getInt("idJenisRoom");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Room room = new Room();
        room.setIdCabang(cabang);
        room.setIdJenisRoom(idJenis);
        room.setNomorRoom(noRoom);
        room.setStatusOccupied(statusOccupied.NOT_OCCUPIED);
        String query = "INSERT INTO room (idCabang, idJenisRoom, nomorRoom, status) VALUES(?,?,?,'"+room.getStatusOccupied()+"')";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, room.getIdCabang());
            stmt.setInt(2, room.getIdJenisRoom());
            stmt.setInt(3, room.getNomorRoom());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public String[] cekJenis(int idCabang){
        String query = "SELECT * FROM jenisRoom WHERE idCabang='"+idCabang+"'";
        conn.connect();
        String[]listJenis = null;
        int jmlIndex = 0;
        int temp = 0;
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                jmlIndex++;
            }
            listJenis = new String[jmlIndex];
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                listJenis[temp] = rs.getString("jenisRoom");
                temp++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return listJenis;
    }
}
