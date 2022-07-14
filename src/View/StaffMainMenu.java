package View;

import Controller.CabangController;
import Controller.SingletonUser;
import Controller.StaffController;
import Model.CabangHotel;
import Model.Extra;
import Model.Voucher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StaffMainMenu {
    public StaffMainMenu() {
        JFrame frame = new JFrame("Staff Menu");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        JLabel welc = new JLabel("Welcome to Staff Menu");
        JButton manageVoucher = new JButton("Manage Voucher");
        JButton manageExtras = new JButton("Manage Extras");
        JButton logout = new JButton("LogOut");
        JButton exit = new JButton("Exit");
        logout.setBounds(60, 200, 275, 30);
        exit.setBounds(60, 240, 275, 30);
        logout.addActionListener(e -> {
            SingletonUser.getInstance().setCurrentUser(null);
            JOptionPane.showMessageDialog(null, "Logged Out!");
            new Login();
            frame.dispose();
        });
        exit.addActionListener(e -> System.exit(0));
        manageExtras.setHorizontalAlignment(SwingConstants.CENTER);
        manageExtras.setBounds(35, 120, 325, 30);
        manageVoucher.setHorizontalAlignment(SwingConstants.CENTER);
        manageVoucher.setBounds(35, 160, 325, 30);
        welc.setBounds(100, 20, 300, 20);
        welc.setFont(new Font("Arial", Font.ITALIC, 20));
        frame.setVisible(true);
        frame.add(welc);
        frame.add(manageExtras);
        frame.add(manageVoucher);
        frame.add(logout);
        frame.add(exit);

        JButton back = new JButton("Back to Staff Menu");
        back.setBounds(60, 240, 275, 30);
        JFrame frame2 = new JFrame("Manage Voucher");
        frame2.setLayout(null);
        JButton showVouchers = new JButton("Show Vouchers");
        JButton addVoucher = new JButton("Add Voucher");
        JButton deleteVoucher = new JButton("Delete Voucher");
        showVouchers.setBounds(35, 120, 325, 30);
        addVoucher.setBounds(35, 160, 325, 30);
        deleteVoucher.setBounds(35, 200, 325, 30);
        back.addActionListener(e -> {
            frame2.dispose();
            new StaffMainMenu();
        });
        frame2.add(showVouchers);
        frame2.add(addVoucher);
        frame2.add(deleteVoucher);
        frame2.add(back);

        JButton back2 = new JButton("Back to Staff Menu");
        back2.setBounds(60, 240, 275, 30);
        JFrame frame3 = new JFrame("Manage Extras");
        frame3.setLayout(null);
        JButton addExtra = new JButton("Add Extra");
        JButton deleteExtra = new JButton("Delete Extra");
        JButton showExtras = new JButton("Show Extras");
        showExtras.setBounds(35, 120, 325, 30);
        addExtra.setBounds(35, 160, 325, 30);
        deleteExtra.setBounds(35, 200, 325, 30);
        back2.addActionListener(e -> {
            frame3.dispose();
            new StaffMainMenu();
        });
        frame3.add(showExtras);
        frame3.add(addExtra);
        frame3.add(deleteExtra);
        frame3.add(back2);

        JFrame frameShowExtras = new JFrame("Show Extras");
        frameShowExtras.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel panelShowExtras = new JPanel();
        var dataTabel = StaffController.getAllExtras();
        if (!dataTabel.isEmpty()) {
            String[] columnNames = {"ID Extra", "ID Cabang", "Nama Extra", "Harga Extra"};
            String[][] data = new String[dataTabel.size()][dataTabel.get(0).size()];
            for (int i = 0; i < dataTabel.size(); i++) {
                for (int j = 0; j < dataTabel.get(i).size(); j++) {
                    data[i][j] = dataTabel.get(i).get(j);
                }
            }
            JTable tabelExtras = new JTable(data, columnNames);
            panelShowExtras.add(new JScrollPane(tabelExtras));
            tabelExtras.setVisible(true);
        } else {
            JLabel label = new JLabel("Extras Masih Kosong!");
            panelShowExtras.add(label);
        }
        frameShowExtras.add(panelShowExtras);
        frameShowExtras.pack();

        JFrame frameAddExtra = new JFrame("Add Extra");
        frameAddExtra.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        Extra extraBaru = new Extra();

        JLabel labelIdCabang = new JLabel("ID Cabang:");
        JLabel labelNamaExtra = new JLabel("Nama Extra:");
        JLabel labelHargaExtra = new JLabel("Harga Extra:");

        ArrayList<CabangHotel> cabangs = CabangController.getAllCabangs();
        JComboBox<String> idCabang = new JComboBox<>(StaffController.getIdCabang(cabangs));
        JTextField namaExtra = new JFormattedTextField();
        JTextField hargaExtra = new JFormattedTextField();
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            extraBaru.setHargaExtra(Double.parseDouble(hargaExtra.getText()));
            extraBaru.setNamaExtra(namaExtra.getText());
            extraBaru.setIdCabang(Integer.parseInt(String.valueOf(idCabang.getSelectedItem())));
            try {
                StaffController.addExtra(extraBaru);
                JOptionPane.showMessageDialog(null, "Insert Data Successful");
            } catch (HeadlessException ex) {
                throw new RuntimeException(ex);
            }
            frameAddExtra.dispose();
            new StaffMainMenu();
        });
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().addComponent(labelIdCabang).addComponent(labelNamaExtra).addComponent(labelHargaExtra).addComponent(submit));
        hGroup.addGroup(layout.createParallelGroup().addComponent(idCabang).addComponent(namaExtra).addComponent(hargaExtra));
        layout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelIdCabang).addComponent(idCabang));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelNamaExtra).addComponent(namaExtra));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelHargaExtra).addComponent(hargaExtra));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(submit));
        layout.setVerticalGroup(vGroup);
        frameAddExtra.add(panel);
        frameAddExtra.pack();

        JFrame frameDeleteExtras = new JFrame("Delete Extras");
        frameDeleteExtras.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel panelDeleteExtras = new JPanel();
        JLabel labelAja = new JLabel("Masukkan ID Extra yang ingin di delete:");
        JTextField idExtra = new JFormattedTextField();
        idExtra.setPreferredSize(new Dimension(300, 20));
        JButton submitDelete = new JButton("Submit");
        submitDelete.addActionListener(e -> {
            try {
                StaffController.deleteExtra(Integer.parseInt(idExtra.getText()));
                JOptionPane.showMessageDialog(null, "Delete Extra dengan ID " + idExtra.getText() + " berhasil !");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            frameDeleteExtras.dispose();
        });
        panelDeleteExtras.add(labelAja);
        panelDeleteExtras.add(idExtra);
        panelDeleteExtras.add(submitDelete);
        frameDeleteExtras.add(panelDeleteExtras);
        frameDeleteExtras.setSize(new Dimension(400, 300));

        JFrame frameShowVouchers = new JFrame("Show Vouchers");
        frameShowVouchers.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel panelShowVouchers = new JPanel();
        var dataTabelVoucher = StaffController.getAllVouchers();
        if (!dataTabelVoucher.isEmpty()) {
            String[] columnNames = {"ID Voucher", "Nama Voucher", "Persen Voucher"};
            String[][] data = new String[dataTabelVoucher.size()][dataTabelVoucher.get(0).size()];
            for (int i = 0; i < dataTabel.size(); i++) {
                for (int j = 0; j < dataTabel.get(i).size(); j++) {
                    data[i][j] = dataTabel.get(i).get(j);
                }
            }
            JTable tabelVouchers = new JTable(data, columnNames);
            panelShowVouchers.add(new JScrollPane(tabelVouchers));
            tabelVouchers.setVisible(true);
        } else {
            JLabel label = new JLabel("Tidak ada voucher!");
            panelShowVouchers.add(label);
        }
        frameShowVouchers.add(panelShowVouchers);
        frameShowVouchers.pack();

        JFrame frameAddVoucher = new JFrame("Add Voucher");
        JPanel panelAddVoucher = new JPanel();
        JLabel labelNamaVoucher = new JLabel("Nama Voucher:");
        JLabel labelPersenVoucher = new JLabel("Persen Voucher:");
        JTextField namaVoucher = new JFormattedTextField();
        JTextField persenVoucher = new JFormattedTextField();
        JButton submitAddVoucher = new JButton("Submit");

        GroupLayout layout2 = new GroupLayout(panelAddVoucher);
        panelAddVoucher.setLayout(layout2);
        layout2.setAutoCreateGaps(true);
        layout2.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup2 = layout2.createSequentialGroup();
        hGroup2.addGroup(layout2.createParallelGroup().addComponent(labelNamaVoucher).addComponent(labelPersenVoucher).addComponent(submitAddVoucher));
        hGroup2.addGroup(layout2.createParallelGroup().addComponent(namaVoucher).addComponent(persenVoucher));
        layout2.setHorizontalGroup(hGroup2);

        GroupLayout.SequentialGroup vGroup2 = layout2.createSequentialGroup();
        vGroup2.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelNamaVoucher).addComponent(namaVoucher));
        vGroup2.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(labelPersenVoucher).addComponent(persenVoucher));
        vGroup2.addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(submitAddVoucher));
        layout2.setVerticalGroup(vGroup2);
        submitAddVoucher.addActionListener(e -> {
            Voucher voucher = new Voucher();
            voucher.setNamaVoucher(namaVoucher.getText());
            voucher.setPersenVoucher(Double.parseDouble(persenVoucher.getText()));
            try {
                StaffController.addVoucher(voucher);
                JOptionPane.showMessageDialog(null, "Insert Voucher Baru Berhasil!");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
            frameAddVoucher.dispose();
        });
        frameAddVoucher.add(panelAddVoucher);
        frameAddVoucher.pack();

        JFrame frameDeleteVoucher = new JFrame("Delete Voucher");
        frameDeleteVoucher.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel panelDeleteVoucher = new JPanel();
        JLabel labelIdVoucher = new JLabel("ID Voucher");
        JTextField idVoucher = new JFormattedTextField();
        JButton submitDeleteVoucher = new JButton("Submit");
        submitDeleteVoucher.addActionListener(e -> {
            try {
                StaffController.deleteVoucher(Integer.parseInt(idVoucher.getText()));
                JOptionPane.showMessageDialog(null, "Delete Voucher dengan ID " + idVoucher.getText() + " berhasil!");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Gagal delete voucher! " + exception.getMessage());
            }
            frameDeleteVoucher.dispose();
        });
        idVoucher.setPreferredSize(new Dimension(300, 25));
        panelDeleteVoucher.add(labelIdVoucher);
        panelDeleteVoucher.add(idVoucher);
        panelDeleteVoucher.add(submitDeleteVoucher);
        frameDeleteVoucher.add(panelDeleteVoucher);

        manageExtras.addActionListener(e -> frame3.setVisible(true));
        manageVoucher.addActionListener(e -> {
            frame2.setVisible(true);
            frame.dispose();
        });
        addExtra.addActionListener(e -> frameAddExtra.setVisible(true));
        showExtras.addActionListener(e -> frameShowExtras.setVisible(true));
        deleteExtra.addActionListener(e -> frameDeleteExtras.setVisible(true));

        showVouchers.addActionListener(e -> frameShowVouchers.setVisible(true));
        addVoucher.addActionListener(e -> frameAddVoucher.setVisible(true));
        deleteVoucher.addActionListener(e -> frameDeleteVoucher.setVisible(true));

        frame.setSize(400, 400);
        frame2.setSize(400, 400);
        frame3.setSize(400, 400);
    }
}
