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
    private int hargaExtra;
    private JenisRoom jenis;
    
    public Extra() {

    }

    public Extra(int idExtra, int idCabang, String namaExtra, int hargaExtra, JenisRoom jenis) {
        this.idExtra = idExtra;
        this.idCabang = idCabang;
        this.namaExtra = namaExtra;
        this.hargaExtra = hargaExtra;
        this.jenis = jenis;
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

    public int getHargaExtra() {
        return hargaExtra;
    }

    public void setHargaExtra(int hargaExtra) {
        this.hargaExtra = hargaExtra;
    }

    public JenisRoom getJenis() {
        return jenis;
    }

    public void setJenis(JenisRoom jenis) {
        this.jenis = jenis;
    }
    
}
