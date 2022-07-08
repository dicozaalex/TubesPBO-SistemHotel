/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author stefa
 */
public class Boss extends User {
    private int idBoss;

    public Boss() {

    }

    public Boss(String username, String firstname, String lastname, String password, String email, String telp, EnumStatusUser status) {
        super(username, firstname, lastname, password, email, telp, status);
    }

    public int getIdBoss() {
        return idBoss;
    }

    public void setIdBoss(int idBoss) {
        this.idBoss = idBoss;
    }
}
