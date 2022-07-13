/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author stefa
 */
public class JenisRoom {

    private int idJenisRoom;
    private int idCabang;
    private String jenisRoom;
    private int maksimalOrang;
    private double hargaRoom;

    public JenisRoom() {
    }

    public JenisRoom(int idCabang, String jenisRoom, int maksimalOrang, double hargaRoom) {
        this.idCabang = idCabang;
        this.jenisRoom = jenisRoom;
        this.maksimalOrang = maksimalOrang;
        this.hargaRoom = hargaRoom;
    }

    public int getIdJenisRoom() {
        return idJenisRoom;
    }

    public void setIdJenisRoom(int idJenisRoom) {
        this.idJenisRoom = idJenisRoom;
    }

    public int getIdCabang() {
        return idCabang;
    }

    public void setIdCabang(int idCabang) {
        this.idCabang = idCabang;
    }

    public String getJenisRoom() {
        return jenisRoom;
    }

    public void setJenisRoom(String jenisRoom) {
        this.jenisRoom = jenisRoom;
    }

    public int getMaksimalOrang() {
        return maksimalOrang;
    }

    public void setMaksimalOrang(int maksimalOrang) {
        this.maksimalOrang = maksimalOrang;
    }

    public double getHargaRoom() {
        return hargaRoom;
    }

    public void setHargaRoom(double hargaRoom) {
        this.hargaRoom = hargaRoom;
    }
    
}
