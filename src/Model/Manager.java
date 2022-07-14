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
public class Manager extends User{
    private int idManager;
    private CabangHotel cabang;

    public Manager(int idManager, CabangHotel cabang, String username, String firstname, String lastname, String password, String email, String telp, EnumStatusUser status) {
        super(username, firstname, lastname, password, email, telp, status);
        this.cabang = cabang;
        this.idManager = idManager;
    }
    
    public Manager(CabangHotel cabang, String username, String firstname, String lastname, String password, String email, String telp, EnumStatusUser status) {
        super(username, firstname, lastname, password, email, telp, status);
        this.cabang = cabang;
    }

    public Manager(){
        
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public CabangHotel getCabang() {
        return cabang;
    }

    public void setCabang(CabangHotel cabang) {
        this.cabang = cabang;
    }
    
}
