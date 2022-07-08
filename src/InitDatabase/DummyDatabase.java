/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InitDatabase;

import Controller.ConnectDatabase;
import Controller.SingletonDatabase;
import Model.*;
import java.util.ArrayList;

/**
 *
 * @author juand
 */
public class DummyDatabase {

    static ConnectDatabase conn = SingletonDatabase.getConnectObject();
    //manager
    Room room1 = new Room(1, 1, 1, 101, EnumRoom.NOT_OCCUPIED);
    Room room2 = new Room(2, 1, 3, 102, EnumRoom.NOT_OCCUPIED);
    Room room3 = new Room(3, 1, 2, 103, EnumRoom.OCCUPIED);
    ArrayList<Room> listRoom1 = new ArrayList<>();
    CabangHotel cabang1 = new CabangHotel(1, "Pasir Kaliki", "Pasir Kaliki no 24", listRoom1);
    Manager manager1 = new Manager(1, cabang1, "UdinWorld", "Udin", "Sedunia", "1234", "udinsworld@gmail.com", "085148117283", EnumStatusUser.MANAGER);

    public DummyDatabase() {
        listRoom1.add(room1);
        listRoom1.add(room2);
        listRoom1.add(room3);
    }

    public void insertRoom() {
        String query;

    }
}
