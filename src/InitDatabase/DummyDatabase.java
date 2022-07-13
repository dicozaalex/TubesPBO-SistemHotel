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
    JenisRoom jenisRoom1 = new JenisRoom(1, "Single", 1, 500000);
    JenisRoom jenisRoom2 = new JenisRoom(1, "Twin", 2, 750000);
    JenisRoom jenisRoom3 = new JenisRoom(1, "Master", 3, 1000000);
    JenisRoom jenisRoom4 = new JenisRoom(1, "President", 6, 1500000);
    Room room1 = new Room(1, 1, 101, EnumRoom.NOT_OCCUPIED);
    Room room2 = new Room(1, 1, 101, EnumRoom.NOT_OCCUPIED);
    Room room3 = new Room(2, 3, 102, EnumRoom.NOT_OCCUPIED);
    Room room4 = new Room(2, 2, 103, EnumRoom.OCCUPIED);
    ArrayList<Room> listRoom1 = new ArrayList<>();
    CabangHotel cabang1 = new CabangHotel("Pasir Kaliki", "Pasir Kaliki no 24", listRoom1);
    CabangHotel cabang2 = new CabangHotel("Pasir Kaliki", "Pasir Kaliki no 24", listRoom1);
    CabangHotel cabang3 = new CabangHotel("Pasir Kaliki", "Pasir Kaliki no 24", listRoom1);
    Manager manager1 = new Manager(cabang1, "UdinWorld", "Udin", "Sedunia", "1234", "udinsworld@gmail.com", "085148117283", EnumStatusUser.MANAGER);
    Manager manager2 = new Manager(cabang1, "UdinWorld", "Udin", "Sedunia", "1234", "udinsworld@gmail.com", "085148117283", EnumStatusUser.MANAGER);
    Manager manager3 = new Manager(cabang1, "UdinWorld", "Udin", "Sedunia", "1234", "udinsworld@gmail.com", "085148117283", EnumStatusUser.MANAGER);

    
    public DummyDatabase() {
        listRoom1.add(room1);
        listRoom1.add(room2);
        listRoom1.add(room3);
    }

    public void insertRoom() {
        String query;

    }
}
