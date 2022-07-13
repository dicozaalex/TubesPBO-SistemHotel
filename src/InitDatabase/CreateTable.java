/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InitDatabase;

import Controller.SingletonDatabase;
import Controller.ConnectDatabase;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juand
 */
public class CreateTable {

    static ConnectDatabase conn = SingletonDatabase.getConnectObject();

    public CreateTable() {
        String templateUser = "firstName VARCHAR(30),"
                + "lastName VARCHAR(30),"
                + "userName VARCHAR(20),"
                + "password VARCHAR(20),"
                + "telepon VARCHAR(20),"
                + "email VARCHAR(20),"
                + "statusUser ENUM('CUSTOMER', 'STAFF', 'MANAGER', 'BOSS')";

        String query1 = "CREATE TABLE users("
                + "idUser INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "idJenisUser INT NOT NULL,"
                + "userName VARCHAR(20),"
                + "password VARCHAR(20),"
                + "statusUser ENUM('CUSTOMER', 'STAFF', 'MANAGER', 'BOSS'))";
        connectQuery(query1);
        String query2 = "CREATE TABLE customer("
                + "idCustomer INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + templateUser
                + ",statusMember ENUM('MEMBER', 'NOT_MEMBER'),"
                + "saldoWallet DOUBLE)";
        connectQuery(query2);
        String query3 = "CREATE TABLE staff("
                + "idStaff INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "idCabang INT NOT NULL,"
                + templateUser
                + ",gaji DOUBLE)";
        connectQuery(query3);
        String query4 = "CREATE TABLE manager("
                + "idManager INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "idCabang INT NOT NULL,"
                + templateUser + ")";
        connectQuery(query4);
        String query5 = "CREATE TABLE boss("
                + "idBoss INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + templateUser + ")";
        connectQuery(query5);
        String query6 = "CREATE TABLE transaksi("
                + "idReservation INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "idCustomer INT,"
                + "idCabang INT,"
                + "tanggalCheckIn DATE,"
                + "tanggalCheckOut DATE,"
                + "berapaOrang INT,"
                + "idRoom INT,"
                + "totalBayar DOUBLE)";
        connectQuery(query6);
        String query7 = "CREATE TABLE Room("
                + "idRoom INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "idCabang INT,"
                + "idJenisRoom INT,"
                + "nomorRoom INT,"
                + "status ENUM('OCCUPIED','NOT_OCCUPIED','UNDER_MAINTENANCE'))";
        connectQuery(query7);
        String query8 = "CREATE TABLE jenisRoom("
                + "idJenisRoom INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "idCabang INT,"
                + "jenisRoom VARCHAR(20),"
                + "maksOrang INT,"
                + "harga DOUBLE)";
        connectQuery(query8);
        String query9 = "CREATE TABLE cabang("
                + "idCabang INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "lokasiCabang VARCHAR(20),"
                + "alamatCabang VARCHAR(50))";
        connectQuery(query9);
        String query10 = "CREATE TABLE ATM("
                + "idCard INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "cardNumber VARCHAR(10),"
                + "saldo DOUBLE,"
                + "pin VARCHAR(10))";
        connectQuery(query10);
        String query11 = "CREATE TABLE voucher("
                + "idVoucher INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "namaVoucher VARCHAR(20),"
                + "persenVoucher DOUBLE)";
        connectQuery(query11);
        String query12 = "CREATE TABLE extra("
                + "idExtra INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "idCabang INT,"
                + "namaExtra VARCHAR(20),"
                + "hargaExtra DOUBLE)";
        connectQuery(query12);

    }

    private void connectQuery(String query) {
        conn.connect();
        try {
            Statement stmt = conn.con.createStatement();
            stmt.execute(query);
            System.out.println("CREATE TABLE SUKSES");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
    }
    public static void main(String[] args) {
        new CreateTable();
    }
}
