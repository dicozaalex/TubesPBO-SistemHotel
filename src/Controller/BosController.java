/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author calvi
 */
import Model.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BosController {
    
    ConnectDatabase conn = SingletonDatabase.getConnectObject();
    public ArrayList<Double> viewPendapatanTotal(){
        ArrayList<Double> listTotalPerCabang = new ArrayList<>();
        int i = 1;
        CabangController cabang = new CabangController();
        int jumlahCabang = cabang.countCabang();
        while(i<jumlahCabang){
            String query = "SELECT totalBayar FROM transaksi WHERE idCabang="+i;
            conn.connect();
            try{
                Statement stmt = conn.con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                double total = 0;
                while(rs.next()){
                    total += rs.getDouble("totalBayar");
                }
                listTotalPerCabang.add(total);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        conn.disconnect();
        return listTotalPerCabang;
    }
    public String addCabang(){
        return "";
    }
}
