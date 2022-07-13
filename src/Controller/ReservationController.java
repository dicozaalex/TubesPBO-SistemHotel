package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
}
