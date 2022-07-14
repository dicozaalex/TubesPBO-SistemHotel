/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InitDatabase;

import Controller.ConnectDatabase;
import Controller.SingletonDatabase;
import Model.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class DummyDatabase {

    static ConnectDatabase conn = SingletonDatabase.getConnectObject();
    //manager
    JenisRoom jenisRoom1 = new JenisRoom(1, "Single", 1, 500000);
    JenisRoom jenisRoom2 = new JenisRoom(1, "Twin", 2, 750000);
    JenisRoom jenisRoom3 = new JenisRoom(2, "Master", 3, 1000000);
    JenisRoom jenisRoom4 = new JenisRoom(2, "President", 6, 1500000);
    Room room1 = new Room(1, 1, 101, EnumRoom.NOT_OCCUPIED);
    Room room2 = new Room(1, 1, 101, EnumRoom.NOT_OCCUPIED);
    Room room3 = new Room(2, 3, 102, EnumRoom.NOT_OCCUPIED);
    Room room4 = new Room(2, 2, 103, EnumRoom.OCCUPIED);
    ArrayList<Room> listRoom1 = new ArrayList<>();
    ArrayList<Room> listRoom2 = new ArrayList<>();
    CabangHotel cabang1 = new CabangHotel(1, "Pasir Kaliki", "Pasir Kaliki no 24", listRoom1);
    CabangHotel cabang2 = new CabangHotel(2, "Jakarta", "Jalan Jakarta no 2", listRoom2);
    Manager manager1 = new Manager(1, cabang1, "UdinWorld", "Udin", "Sedunia", "1234", "udinsworld@gmail.com", "085148117283", EnumStatusUser.MANAGER);
    Manager manager2 = new Manager(2, cabang2, "asep123", "asep", "Sedunia", "1212", "asep@gmail.com", "08380021", EnumStatusUser.MANAGER);
    ArrayList<Reservation> listTransaksi1 = new ArrayList<>();
    ArrayList<Reservation> listTransaksi2 = new ArrayList<>();
    ATMCard atm1 = new ATMCard("1121", 1000000, 11231);
    ATMCard atm2 = new ATMCard("222", 1500000, 1231);
    Customer customer1 = new Customer(1, "Customer1", "Budi", "Idub", "123", "budi@gmail.com", "0838", EnumStatusUser.CUSTOMER, 100000, EnumMember.NOT_MEMBER, listTransaksi1, atm1);
    Customer customer2 = new Customer(2, "Customer2", "agus", "suga", "234", "agus@gmail.com", "0838", EnumStatusUser.CUSTOMER, 150000, EnumMember.NOT_MEMBER, listTransaksi2, atm2);
    Boss boss1 = new Boss(1, "Boss1", "boss", "ssob", "123", "boss@gmail.com", "0838", EnumStatusUser.BOSS);
    Boss boss2 = new Boss(2, "Boss2", "boss2", "ssob2", "234", "boss2@gmail.com", "0838", EnumStatusUser.BOSS);
    Extra extra1 = new Extra(1, "Gym Pass", 200000);
    Extra extra2 = new Extra(1, "Sauna Pass", 100000);
    Extra extra3 = new Extra(1, "Extra Bed", 10000);
    Extra extra4 = new Extra(1, "Golf Pass", 250000);
    Extra extra5 = new Extra(2, "Extra Bed", 100000);
    Extra extra6 = new Extra(2, "Gym Pass", 150000);
    Staff staff1 = new Staff(1, 3000000, 1, "Staff1", "staff", "ffats", "123", "Staff@gmail.com", "0838", EnumStatusUser.STAFF);
    Staff staff2 = new Staff(2, 4000000, 1, "Staff2", "staff2", "ffats2", "234", "Staff2@gmail.com", "0838", EnumStatusUser.STAFF);
    Staff staff3 = new Staff(3, 3000000, 2, "Staff3", "staff3", "ffats3", "345", "Staff3@gmail.com", "0838", EnumStatusUser.STAFF);
    Staff staff4 = new Staff(4, 4000000, 2, "Staff4", "staff4", "ffats4", "456", "Staff4@gmail.com", "0838", EnumStatusUser.STAFF);
    Voucher voucher1 = new Voucher("Diskon 50%", 50);
    Voucher voucher2 = new Voucher("Diskon 25%", 25);

    
    public DummyDatabase() {
        conn.connect();
        listRoom1.add(room1);
        listRoom1.add(room2);
        listRoom2.add(room3);
        listRoom2.add(room4);
//        insertATM();
//        insertBoss();
//        insertCabang();
//        insertCustomer();
//        insertExtra();
//        insertJenisRoom();
//        insertManager();
//        insertRoom();
//        insertStaff();
        insertUsers();
//        insertVoucher();
        conn.disconnect();
    }

    public void insertATM() {
        String query = "INSERT INTO atm (cardNumber, saldo, pin) VALUES(?,?,?), (?,?,?);";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, atm1.getCardNumber());
            stmt.setDouble(2, atm1.getSaldo());
            stmt.setInt(3, atm1.getPin());
            stmt.setString(4, atm2.getCardNumber());
            stmt.setDouble(5, atm2.getSaldo());
            stmt.setInt(6, atm2.getPin());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertBoss() {
        String query = "INSERT INTO boss (firstName, lastName, userName, password, telepon, email, statusUser) "
                + "VALUES(?,?,?,?,?,?,'"+boss1.getStatus()+"'), (?,?,?,?,?,?,'"+boss2.getStatus()+"');";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, boss1.getFirstname());
            stmt.setString(2, boss1.getLastname());
            stmt.setString(3, boss1.getUsername());
            stmt.setString(4, boss1.getPassword());
            stmt.setString(5, boss1.getTelp());
            stmt.setString(6, boss1.getEmail());
            stmt.setString(7, boss2.getFirstname());
            stmt.setString(8, boss2.getLastname());
            stmt.setString(9, boss2.getUsername());
            stmt.setString(10, boss2.getPassword());
            stmt.setString(11, boss2.getTelp());
            stmt.setString(12, boss2.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertCabang() {
        String query = "INSERT INTO cabang (lokasiCabang, alamatCabang) VALUES(?,?), (?,?);";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, cabang1.getLokasiCabang());
            stmt.setString(2, cabang1.getAlamatCabang());
            stmt.setString(3, cabang2.getLokasiCabang());
            stmt.setString(4, cabang2.getAlamatCabang());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertCustomer() {
        String query = "INSERT INTO customer (firstName, lastName, userName, password, telepon, email, statusUser, statusMember, saldoWallet) "
                + "VALUES(?,?,?,?,?,?,'"+customer1.getStatus()+"','"+customer1.getStatusMember()+"',?), (?,?,?,?,?,?,'"+customer2.getStatus()+"','"+customer2.getStatusMember()+"',?);";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, customer1.getFirstname());
            stmt.setString(2, customer1.getLastname());
            stmt.setString(3, customer1.getUsername());
            stmt.setString(4, customer1.getPassword());
            stmt.setString(5, customer1.getTelp());
            stmt.setString(6, customer1.getEmail());
            stmt.setObject(7, customer1.getSaldoWallet());
            stmt.setString(8, customer2.getFirstname());
            stmt.setString(9, customer2.getLastname());
            stmt.setString(10, customer2.getUsername());
            stmt.setString(11, customer2.getPassword());
            stmt.setString(12, customer2.getTelp());
            stmt.setString(13, customer2.getEmail());
            stmt.setObject(14, customer2.getSaldoWallet());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertExtra() {
        String query = "INSERT INTO extra (idCabang, namaExtra, hargaExtra) "
                + "VALUES(?,?,?), (?,?,?), (?,?,?), (?,?,?), (?,?,?), (?,?,?);";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, extra1.getIdCabang());
            stmt.setString(2, extra1.getNamaExtra());
            stmt.setDouble(3, extra1.getHargaExtra());
            stmt.setInt(4, extra2.getIdCabang());
            stmt.setString(5, extra2.getNamaExtra());
            stmt.setDouble(6, extra2.getHargaExtra());
            stmt.setInt(7, extra3.getIdCabang());
            stmt.setString(8, extra3.getNamaExtra());
            stmt.setDouble(9, extra3.getHargaExtra());
            stmt.setInt(10, extra4.getIdCabang());
            stmt.setString(11, extra4.getNamaExtra());
            stmt.setDouble(12, extra4.getHargaExtra());
            stmt.setInt(13, extra5.getIdCabang());
            stmt.setString(14, extra5.getNamaExtra());
            stmt.setDouble(15, extra5.getHargaExtra());
            stmt.setInt(16, extra6.getIdCabang());
            stmt.setString(17, extra6.getNamaExtra());
            stmt.setDouble(18, extra6.getHargaExtra());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertJenisRoom() {
        String query = "INSERT INTO jenisRoom (idCabang, jenisRoom, maksOrang, harga) "
                + "VALUES(?,?,?,?), (?,?,?,?), (?,?,?,?), (?,?,?,?);";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, jenisRoom1.getIdCabang());
            stmt.setString(2, jenisRoom1.getJenisRoom());
            stmt.setInt(3, jenisRoom1.getMaksimalOrang());
            stmt.setDouble(4, jenisRoom1.getHargaRoom());
            stmt.setInt(5, jenisRoom2.getIdCabang());
            stmt.setString(6, jenisRoom2.getJenisRoom());
            stmt.setInt(7, jenisRoom2.getMaksimalOrang());
            stmt.setDouble(8, jenisRoom2.getHargaRoom());
            stmt.setInt(9, jenisRoom3.getIdCabang());
            stmt.setString(10, jenisRoom3.getJenisRoom());
            stmt.setInt(11, jenisRoom3.getMaksimalOrang());
            stmt.setDouble(12, jenisRoom3.getHargaRoom());
            stmt.setInt(13, jenisRoom4.getIdCabang());
            stmt.setString(14, jenisRoom4.getJenisRoom());
            stmt.setInt(15, jenisRoom4.getMaksimalOrang());
            stmt.setDouble(16, jenisRoom4.getHargaRoom());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertManager() {
        String query = "INSERT INTO manager (idCabang, firstName, lastName, userName, password, telepon, email, statusUser) "
                + "VALUES(?,?,?,?,?,?,?,'"+manager1.getStatus()+"'), (?,?,?,?,?,?,?,'"+manager2.getStatus()+"');";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, manager1.getCabang().getIdCabang());
            stmt.setString(2, manager1.getFirstname());
            stmt.setString(3, manager1.getLastname());
            stmt.setString(4, manager1.getUsername());
            stmt.setString(5, manager1.getPassword());
            stmt.setString(6, manager1.getTelp());
            stmt.setString(7, manager1.getEmail());
            stmt.setInt(8, manager2.getCabang().getIdCabang());
            stmt.setString(9, manager2.getFirstname());
            stmt.setString(10, manager2.getLastname());
            stmt.setString(11, manager2.getUsername());
            stmt.setString(12, manager2.getPassword());
            stmt.setString(13, manager2.getTelp());
            stmt.setString(14, manager2.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertRoom() {
        String query = "INSERT INTO room (idCabang, idJenisRoom, nomorRoom, status) "
                + "VALUES(?,?,?,'"+room1.getStatusOccupied()+"'), (?,?,?,'"+room2.getStatusOccupied()+"'), (?,?,?,'"+room3.getStatusOccupied()+"'), (?,?,?,'"+room4.getStatusOccupied()+"');";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, room1.getIdCabang());
            stmt.setInt(2, room1.getIdJenisRoom());
            stmt.setInt(3, room1.getNomorRoom());
            stmt.setInt(4, room2.getIdCabang());
            stmt.setInt(5, room2.getIdJenisRoom());
            stmt.setInt(6, room2.getNomorRoom());
            stmt.setInt(7, room3.getIdCabang());
            stmt.setInt(8, room3.getIdJenisRoom());
            stmt.setInt(9, room3.getNomorRoom());
            stmt.setInt(10, room4.getIdCabang());
            stmt.setInt(11, room4.getIdJenisRoom());
            stmt.setInt(12, room4.getNomorRoom());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertStaff() {
        String query = "INSERT INTO staff (idCabang, firstName, lastName, userName, password, telepon, email, statusUser, gaji) "
                + "VALUES(?,?,?,?,?,?,?,'"+staff1.getStatus()+"',?), (?,?,?,?,?,?,?,'"+staff2.getStatus()+"',?), (?,?,?,?,?,?,?,'"+staff3.getStatus()+"',?), (?,?,?,?,?,?,?,'"+staff4.getStatus()+"',?);";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, staff1.getIdCabang());
            stmt.setString(2, staff1.getFirstname());
            stmt.setString(3, staff1.getLastname());
            stmt.setString(4, staff1.getUsername());
            stmt.setString(5, staff1.getPassword());
            stmt.setString(6, staff1.getTelp());
            stmt.setString(7, staff1.getEmail());
            stmt.setDouble(8, staff1.getGaji());
            stmt.setInt(9, staff2.getIdCabang());
            stmt.setString(10, staff2.getFirstname());
            stmt.setString(11, staff2.getLastname());
            stmt.setString(12, staff2.getUsername());
            stmt.setString(13, staff2.getPassword());
            stmt.setString(14, staff2.getTelp());
            stmt.setString(15, staff2.getEmail());
            stmt.setDouble(16, staff2.getGaji());
            stmt.setInt(17, staff3.getIdCabang());
            stmt.setString(18, staff3.getFirstname());
            stmt.setString(19, staff3.getLastname());
            stmt.setString(20, staff3.getUsername());
            stmt.setString(21, staff3.getPassword());
            stmt.setString(22, staff3.getTelp());
            stmt.setString(23, staff3.getEmail());
            stmt.setDouble(24, staff3.getGaji());
            stmt.setInt(25, staff4.getIdCabang());
            stmt.setString(26, staff4.getFirstname());
            stmt.setString(27, staff4.getLastname());
            stmt.setString(28, staff4.getUsername());
            stmt.setString(29, staff4.getPassword());
            stmt.setString(30, staff4.getTelp());
            stmt.setString(31, staff4.getEmail());
            stmt.setDouble(32, staff4.getGaji());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertUsers() {
        String query = "INSERT INTO users (idJenisUser, userName, password, statusUser) "
                + "VALUES(?,?,?,'"+boss1.getStatus()+"'), (?,?,?,'"+boss2.getStatus()+"'), "
                + "(?,?,?,'"+manager1.getStatus()+"'), (?,?,?,'"+manager2.getStatus()+"'), "
                + "(?,?,?,'"+staff1.getStatus()+"'), (?,?,?,'"+staff2.getStatus()+"')"
                + ", (?,?,?,'"+staff3.getStatus()+"'), (?,?,?,'"+staff4.getStatus()+"'), "
                + "(?,?,?,'"+ customer1.getStatus()+"'), (?,?,?,'"+ customer2.getStatus()+"');";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, boss1.getIdBoss());
            stmt.setString(2, boss1.getUsername());
            stmt.setString(3, boss1.getPassword());
            stmt.setInt(4, boss2.getIdBoss());
            stmt.setString(5, boss2.getUsername());
            stmt.setString(6, boss2.getPassword());
            stmt.setInt(7, manager1.getIdManager());
            stmt.setString(8, manager1.getUsername());
            stmt.setString(9, manager1.getPassword());
            stmt.setInt(10, manager2.getIdManager());
            stmt.setString(11, manager2.getUsername());
            stmt.setString(12, manager2.getPassword());
            stmt.setInt(13, staff1.getIdStaff());
            stmt.setString(14, staff1.getUsername());
            stmt.setString(15, staff1.getPassword());
            stmt.setInt(16, staff2.getIdStaff());
            stmt.setString(17, staff2.getUsername());
            stmt.setString(18, staff2.getPassword());
            stmt.setInt(19, staff3.getIdStaff());
            stmt.setString(20, staff3.getUsername());
            stmt.setString(21, staff3.getPassword());
            stmt.setInt(22, staff4.getIdStaff());
            stmt.setString(23, staff4.getUsername());
            stmt.setString(24, staff4.getPassword());
            stmt.setInt(25, customer1.getIdCustomer());
            stmt.setString(26, customer1.getUsername());
            stmt.setString(27, customer1.getPassword());
            stmt.setInt(28, customer2.getIdCustomer());
            stmt.setString(29, customer2.getUsername());
            stmt.setString(30, customer2.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertVoucher() {
        String query = "INSERT INTO voucher (namaVoucher, persenVoucher) VALUES(?,?), (?,?);";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, voucher1.getNamaVoucher());
            stmt.setDouble(2, voucher1.getPersenVoucher());
            stmt.setString(3, voucher2.getNamaVoucher());
            stmt.setDouble(4, voucher2.getPersenVoucher());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new DummyDatabase();
    }
}
