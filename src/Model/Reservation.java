/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author stefa
 */
public class Reservation {

    private int idReservation;
    private Room room;
    private int pilihanIdCabang;
    private String pilihanJenisCabang;
    private ArrayList<Extra> extra;
    private Date tanggalCheckIn;
    private Date tanggalCheckOut;
    private int jumOrang;
    private double totalBayar;

    public Reservation() {

    }

    public Reservation(int idReservation, Room room, int pilihanIdCabang, String pilihanJenisCabang, ArrayList<Extra> extra, Date tanggalCheckIn, Date tanggalCheckOut, int jumOrang, double totalBayar) {
        this.idReservation = idReservation;
        this.room = room;
        this.pilihanIdCabang = pilihanIdCabang;
        this.pilihanJenisCabang = pilihanJenisCabang;
        this.extra = extra;
        this.tanggalCheckIn = tanggalCheckIn;
        this.tanggalCheckOut = tanggalCheckOut;
        this.jumOrang = jumOrang;
        this.totalBayar = totalBayar;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getPilihanIdCabang() {
        return pilihanIdCabang;
    }

    public void setPilihanIdCabang(int pilihanIdCabang) {
        this.pilihanIdCabang = pilihanIdCabang;
    }

    public String getPilihanJenisCabang() {
        return pilihanJenisCabang;
    }

    public void setPilihanJenisCabang(String pilihanJenisCabang) {
        this.pilihanJenisCabang = pilihanJenisCabang;
    }

    public ArrayList<Extra> getExtra() {
        return extra;
    }

    public void setExtra(ArrayList<Extra> extra) {
        this.extra = extra;
    }

    public Date getTanggalCheckIn() {
        return tanggalCheckIn;
    }

    public void setTanggalCheckIn(Date tanggalCheckIn) {
        this.tanggalCheckIn = tanggalCheckIn;
    }

    public Date getTanggalCheckOut() {
        return tanggalCheckOut;
    }

    public void setTanggalCheckOut(Date tanggalCheckOut) {
        this.tanggalCheckOut = tanggalCheckOut;
    }

    public int getJumOrang() {
        return jumOrang;
    }

    public void setJumOrang(int jumOrang) {
        this.jumOrang = jumOrang;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }
}
