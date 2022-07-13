/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author stefa
 */
public class Extra {

    private int idExtra;
    private int idCabang;
    private String namaExtra;
    private double hargaExtra;
    
    public Extra() {

    }

    public Extra(int idCabang, String namaExtra, double hargaExtra) {
        this.idCabang = idCabang;
        this.namaExtra = namaExtra;
        this.hargaExtra = hargaExtra;
    }

    public int getIdExtra() {
        return idExtra;
    }

    public void setIdExtra(int idExtra) {
        this.idExtra = idExtra;
    }

    public int getIdCabang() {
        return idCabang;
    }

    public void setIdCabang(int idCabang) {
        this.idCabang = idCabang;
    }

    public String getNamaExtra() {
        return namaExtra;
    }

    public void setNamaExtra(String namaExtra) {
        this.namaExtra = namaExtra;
    }

    public double getHargaExtra() {
        return hargaExtra;
    }

    public void setHargaExtra(double hargaExtra) {
        this.hargaExtra = hargaExtra;
    }
    
}
