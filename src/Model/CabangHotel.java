/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author calvi
 */
import java.util.ArrayList;
public class CabangHotel {
    private int idCabang;
    private String lokasiCabang;
    private String alamatCabang;
    private ArrayList<Room> listRoom;

    public CabangHotel(String lokasiCabang, String alamatCabang, ArrayList<Room> listRoom) {
        this.lokasiCabang = lokasiCabang;
        this.alamatCabang = alamatCabang;
        this.listRoom = listRoom;
    }
    
    public CabangHotel(){
        
    }

    public CabangHotel(String lokasiCabang2, String alamatCabang2, String string) {
    }

    public int getIdCabang() {
        return idCabang;
    }

    public void setIdCabang(int idCabang) {
        this.idCabang = idCabang;
    }

    public String getLokasiCabang() {
        return lokasiCabang;
    }

    public void setLokasiCabang(String lokasiCabang) {
        this.lokasiCabang = lokasiCabang;
    }

    public String getAlamatCabang() {
        return alamatCabang;
    }

    public void setAlamatCabang(String alamatCabang) {
        this.alamatCabang = alamatCabang;
    }

    public ArrayList<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(ArrayList<Room> listRoom) {
        this.listRoom = listRoom;
    }
    
    
}
