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
public class Room {
    private int idRoom;
    private int idCabang;
    private int idJenisRoom;
    private int nomorRoom;
    private EnumRoom statusOccupied;
    
    public Room(){
        
    }

    public Room(int idCabang, int idJenisRoom, int nomorRoom, EnumRoom statusOccupied) {
        this.idCabang = idCabang;
        this.idJenisRoom = idJenisRoom;
        this.nomorRoom = nomorRoom;
        this.statusOccupied = statusOccupied;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdCabang() {
        return idCabang;
    }

    public void setIdCabang(int idCabang) {
        this.idCabang = idCabang;
    }

    public int getIdJenisRoom() {
        return idJenisRoom;
    }

    public void setIdJenisRoom(int idJenisRoom) {
        this.idJenisRoom = idJenisRoom;
    }

    public int getNomorRoom() {
        return nomorRoom;
    }

    public void setNomorRoom(int nomorRoom) {
        this.nomorRoom = nomorRoom;
    }

    public EnumRoom getStatusOccupied() {
        return statusOccupied;
    }

    public void setStatusOccupied(EnumRoom statusOccupied) {
        this.statusOccupied = statusOccupied;
    }
    
    
}
