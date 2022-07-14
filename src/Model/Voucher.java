package Model;

public class Voucher {
    private int idVoucher;
    private String namaVoucher;
    private double persenVoucher;

    public Voucher() {

    }

    public Voucher(String namaVoucher, double persenVoucher) {
        this.namaVoucher = namaVoucher;
        this.persenVoucher = persenVoucher;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public String getNamaVoucher() {
        return namaVoucher;
    }

    public void setNamaVoucher(String namaVoucher) {
        this.namaVoucher = namaVoucher;
    }

    public double getPersenVoucher() {
        return persenVoucher;
    }

    public void setPersenVoucher(double persenVoucher) {
        this.persenVoucher = persenVoucher;
    }
}
