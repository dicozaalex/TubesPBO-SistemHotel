/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author stefa
 */
public class Customer extends User {

    private int idCustomer;
    private double saldoWallet;
    private EnumMember statusMember;
    private ArrayList<Reservation> listTransaksi;
    private ATMCard atmCard;

    public Customer(){

    }
    
    public Customer(String username, String firstname, String lastname, String password, String email, String telp,
            EnumStatusUser status, int idCustomer, double saldoWallet, EnumMember statusMember,
            ArrayList<Reservation> listTransaksi, ATMCard atmCard) {
        super(username, firstname, lastname, password, email, telp, status);
        this.idCustomer = idCustomer;
        this.saldoWallet = saldoWallet;
        this.statusMember = statusMember;
        this.listTransaksi = listTransaksi;
        this.atmCard = atmCard;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public double getSaldoWallet() {
        return saldoWallet;
    }

    public void setSaldoWallet(double saldoWallet) {
        this.saldoWallet = saldoWallet;
    }

    public EnumMember getStatusMember() {
        return statusMember;
    }

    public void setStatusMember(EnumMember statusMember) {
        this.statusMember = statusMember;
    }

    public ArrayList<Reservation> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(ArrayList<Reservation> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }

    public ATMCard getAtmCard() {
        return atmCard;
    }

    public void setAtmCard(ATMCard atmCard) {
        this.atmCard = atmCard;
    }

}
