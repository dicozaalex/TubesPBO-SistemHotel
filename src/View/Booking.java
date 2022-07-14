package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Controller.DateLabelFormatter;
import Controller.CustomerController;
import Controller.ReservationController;
import Controller.StaffController;
import Model.Customer;
import Model.Extra;
import Model.JenisRoom;
import java.awt.Font;

public class Booking {
    JTextField inputLebih;
    ReservationController reservationController = new ReservationController();
    StaffController staffController = new StaffController();
    CustomerController loginController = new CustomerController();

    public Booking(Customer customer, int selectedCabangHotel) {
        JFrame f = new JFrame("Booking");
        JLabel welcomeLabel = new JLabel("Welcome to Hotel");
        JLabel menuLabel = new JLabel("Please Select Your Menu");

        welcomeLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        welcomeLabel.setBounds(100, 20, 300, 20);
        f.add(welcomeLabel);

        menuLabel.setFont(new Font("Arial", Font.ITALIC, 15));
        menuLabel.setBounds(20, 50, 300, 20);
        f.add(menuLabel);

        JLabel banyakOrangJLabel = new JLabel("Banyak Orang");
        banyakOrangJLabel.setBounds(20, 80, 200, 20);
        f.add(banyakOrangJLabel);

        String[] banyakOrang = { "1", "2", "3", "4+" };
        JComboBox inputBanyakOrang = new JComboBox(banyakOrang);

        inputBanyakOrang.setBounds(20, 100, 300, 30);
        f.add(inputBanyakOrang);

        JLabel jenisRoomJLabel = new JLabel("Jenis Room");
        jenisRoomJLabel.setBounds(20, 130, 200, 20);
        f.add(jenisRoomJLabel);

        inputBanyakOrang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (inputBanyakOrang.getSelectedItem().equals("4+")) {
                    inputLebih = new JTextField();
                    inputLebih.setBounds(330, 100, 25, 30);
                    f.add(inputLebih);
                }
            }
        });

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

        JFormattedTextField inputLamaInap = new JFormattedTextField();
        inputLamaInap.setBounds(20, 250, 300, 30);
        f.add(inputLamaInap);

        JButton pembayaranButton = new JButton("Pembayaran");
        pembayaranButton.setBounds(20, 300, 300, 30);
        f.add(pembayaranButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(20, 350, 300, 30);
        f.add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CustomerMainMenu(customer, selectedCabangHotel);
                f.dispose();
            }
        });

        pembayaranButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String banyakOrang = inputBanyakOrang.getSelectedItem().toString();
                if (banyakOrang.equals("4+")) {
                    banyakOrang = inputLebih.getText();
                }
                int banyakOrangInt = Integer.parseInt(banyakOrang);
                String jenisRoom = inputJenisRoom.getSelectedItem().toString();
                String tanggal = tanggalCheckIn.getModel().getValue().toString();
                int lamaInap = Integer.parseInt(inputLamaInap.getText());
                boolean cekRoom = reservationController.cekRoom(selectedCabangHotel, banyakOrangInt, jenisRoom);
                int takeRoom = reservationController.takeRoom(selectedCabangHotel, jenisRoom);
                int idRoom = reservationController.takeIdRoom(selectedCabangHotel, jenisRoom);
                reservationController.setStatusOccupied(selectedCabangHotel, jenisRoom, takeRoom);
                if (cekRoom) {
                    addReservation(customer, selectedCabangHotel, banyakOrangInt, jenisRoom, tanggal, lamaInap,
                            takeRoom, idRoom);
                    f.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Room Not Available");
                }
            }
        });

        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addReservation(Customer customer, int selectedCabangHotel, int banyakOrang, String jenisRoom,
            String tanggal, int lamaInap, int takeRoom, int idRoom) {

        JFrame f = new JFrame("Confirmation");
        JLabel welcomeLabel = new JLabel("Welcome to Hotel");

        welcomeLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        welcomeLabel.setBounds(100, 20, 300, 20);
        f.add(welcomeLabel);

        JLabel jenisRoomLabel = new JLabel("Jenis Room\n " + jenisRoom);
        JLabel banyakOrangLabel = new JLabel("Banyak Orang\n " + banyakOrang);
        JLabel tanggalLabel = new JLabel("Tanggal\n " + tanggal);
        JLabel lamaInapLabel = new JLabel("Lama Inap\n " + lamaInap);
        JLabel noRoomLabel = new JLabel("No Room\n " + takeRoom);

        jenisRoomLabel.setBounds(20, 80, 300, 20);
        f.add(jenisRoomLabel);
        banyakOrangLabel.setBounds(20, 110, 300, 20);

        f.add(banyakOrangLabel);
        tanggalLabel.setBounds(20, 140, 300, 20);
        f.add(tanggalLabel);

        lamaInapLabel.setBounds(20, 170, 300, 20);
        f.add(lamaInapLabel);

        noRoomLabel.setBounds(20, 200, 300, 20);
        f.add(noRoomLabel);

        JLabel addExtraLabel = new JLabel("Add Extra");
        addExtraLabel.setBounds(400, 80, 300, 20);
        f.add(addExtraLabel);

        ArrayList<Extra> extras = staffController.getExtras(selectedCabangHotel);
        JCheckBox addExtraCheckBox[] = new JCheckBox[extras.size()];

        boolean member = loginController.cekMembership(customer.getUsername());

        for (int i = 0; i < extras.size(); i++) {
            addExtraCheckBox[i] = new JCheckBox(extras.get(i).getNamaExtra());
            addExtraCheckBox[i].setBounds(470, 50 + i * 35, 300, 30);
            f.add(addExtraCheckBox[i]);
            if (member) {
                addExtraCheckBox[i].setEnabled(false);
                addExtraCheckBox[i].setSelected(true);
            }
        }
        JLabel voucherLabel = new JLabel("Voucher");
        voucherLabel.setBounds(20, 220, 250, 20);
        f.add(voucherLabel);

        JTextField voucherTextField = new JTextField();
        voucherTextField.setBounds(100, 220, 250, 30);
        f.add(voucherTextField);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(50, 260, 300, 30);
        f.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String voucher = voucherTextField.getText();
                boolean cekVoucher = staffController.cekVoucher(voucher);
                if (cekVoucher) {
                    JOptionPane.showMessageDialog(null, "Voucher Valid");
                } else {
                    JOptionPane.showMessageDialog(null, "Voucher Invalid");
                }
                double totalHargaRoom = reservationController.cekHarga(selectedCabangHotel, member, jenisRoom,
                        addExtraCheckBox, voucher, customer, extras, lamaInap);
                menuConfirmation(customer, totalHargaRoom, selectedCabangHotel, tanggal, lamaInap, banyakOrang, idRoom);
                f.dispose();
            }
        });

        f.setSize(600, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void menuConfirmation(Customer customer, double totalHargaRoom, int selectedCabangHotel, String tanggalCheckIn, int lamaInap, int banyakOrang, int idRoom) {
        JFrame f = new JFrame("Confirmation");
        JLabel totalHargaLabel = new JLabel("Total Harga\n " + totalHargaRoom);
        totalHargaLabel.setBounds(20, 50, 300, 20);
        f.add(totalHargaLabel);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(20, 80, 300, 30);
        f.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean cekSaldo = reservationController.cekSaldoBayar(customer, totalHargaRoom);
                if (cekSaldo) {
                    JOptionPane.showMessageDialog(null, "Pembayaran Berhasil");
                    reservationController.setTransaksi(customer, tanggalCheckIn, lamaInap, banyakOrang, idRoom, totalHargaRoom);
                } else {
                    JOptionPane.showMessageDialog(null, "Pembayaran Gagal");
                }
                f.dispose();
                new CustomerMainMenu(customer, selectedCabangHotel);
            }
        });

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
