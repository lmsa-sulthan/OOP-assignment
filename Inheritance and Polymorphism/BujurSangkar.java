public class BujurSangkar extends Bentuk {
    private double sisi;

    public BujurSangkar(double sisi, String warna) {
        super(warna);
        this.sisi = sisi;
    }

    public double getSisi() {
        return this.sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    public double hitungLuas() {
        return this.sisi * this.sisi;
    }

    @Override
    public void printInfo() {
        System.out.println("BujurSangkar berwarna " + getWarna() + ", luas = " + hitungLuas());
    }
}