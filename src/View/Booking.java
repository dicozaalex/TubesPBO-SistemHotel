package View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controller.ReservationController;
import Model.Customer;
import Model.JenisRoom;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.util.Properties;
import Controller.*;

public class Booking {
    public Booking(Customer customer, int selectedCabangHotel) {
        ReservationController reservationController = new ReservationController();
        JFrame f = new JFrame("Booking");
        JLabel welcomeLabel = new JLabel("Welcome to Hotel");
        JLabel menuLabel = new JLabel("Please Select Your Menu");

        welcomeLabel.setBounds(100, 20, 300, 20);
        f.add(welcomeLabel);

        menuLabel.setBounds(20, 50, 300, 20);
        f.add(menuLabel);
        JLabel banyakOrangJLabel = new JLabel("Banyak Orang");
        banyakOrangJLabel.setBounds(20, 80, 200, 20);
        f.add(banyakOrangJLabel);

        JComboBox<Integer> inputBanyakOrang = new JComboBox<>();

        inputBanyakOrang.addItem(1);
        inputBanyakOrang.addItem(2);
        inputBanyakOrang.addItem(4);
        inputBanyakOrang.addItem(6);

        inputBanyakOrang.setBounds(20, 100, 300, 30);
        f.add(inputBanyakOrang);

        JLabel jenisRoomJLabel = new JLabel("Jenis Room");
        jenisRoomJLabel.setBounds(20, 130, 200, 20);
        f.add(jenisRoomJLabel);

        ArrayList<JenisRoom> listReservation = reservationController.getAllJenisRoom(selectedCabangHotel);

        String[] jenisRoom = new String[listReservation.size()];
        for (int i = 0; i < listReservation.size(); i++) {
            jenisRoom[i] = listReservation.get(i).getJenisRoom();
        }
        JComboBox<String> inputJenisRoom = new JComboBox<>(jenisRoom);
        inputJenisRoom.setBounds(20, 150, 300, 30);
        f.add(inputJenisRoom);

        JLabel tanggalCheckInLabel = new JLabel("Check In");
        tanggalCheckInLabel.setBounds(20, 180, 300, 20);
        f.add(tanggalCheckInLabel);

        UtilDateModel model1 = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model1, p);
        JDatePickerImpl tanggalCheckIn = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        tanggalCheckIn.setBounds(20, 200, 300, 30);
        f.add(tanggalCheckIn);

        JLabel lamaInapLabel = new JLabel("Lama Inap");
        lamaInapLabel.setBounds(20, 230, 300, 20);
        f.add(lamaInapLabel);

        JFormattedTextField lamaInap = new JFormattedTextField();
        lamaInap.setBounds(20, 250, 300, 30);
        f.add(lamaInap);


        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
