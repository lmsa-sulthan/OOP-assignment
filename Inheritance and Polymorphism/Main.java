public class Main {
    public static void main(String[] args) {
        BujurSangkar persegi = new BujurSangkar(5.0, "Merah");
        persegi.printInfo();

        Lingkaran bulat = new Lingkaran(7.0, "Biru");
        bulat.printInfo();

        Silinder tabung = new Silinder(10.0, 7.0, "Hijau");
        tabung.printInfo();
    }
}