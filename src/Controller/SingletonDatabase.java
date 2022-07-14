/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author juand
 */
public class SingletonDatabase {
    private static ConnectDatabase conn;
    public static ConnectDatabase getConnectObject(){
        if (conn == null) {
            conn = new ConnectDatabase();
        }
        return conn;
    }
}
