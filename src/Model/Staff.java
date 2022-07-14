/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author calvi
 */
public class Staff extends User implements InterfaceData {
    private int idStaff;
    private double gaji;
    private int idCabang;
    
    public Staff(){
    
    }
    public Staff(int idStaff, double gaji, int cabang, String username, String firstname, String lastname, String password, String email, String telp, EnumStatusUser status) {
        super(username, firstname, lastname, password, email, telp, status);
        this.gaji = gaji;
        this.idCabang = cabang;
        this.idStaff = idStaff;
    }
    
    public Staff(double gaji, int cabang, String username, String firstname, String lastname, String password, String email, String telp, EnumStatusUser status) {
        super(username, firstname, lastname, password, email, telp, status);
        this.gaji = gaji;
        this.idCabang = cabang;
    }


    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public int getIdCabang() {
        return idCabang;
    }

    public void setCabang(int cabang) {
        this.idCabang = cabang;
    }

    @Override
    public void dataCustomer() {
        System.out.println("Hello World!");
    }
}
