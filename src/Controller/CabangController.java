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

public class CabangController {
    
    ConnectDatabase conn = new ConnectDatabase();
    
    public int countCabang(){
        int count = 0;
        String query = "SELECT idCabang FROM cabang";
        conn.connect();
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                count++;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        conn.disconnect();
        return count;
    }
    
}
