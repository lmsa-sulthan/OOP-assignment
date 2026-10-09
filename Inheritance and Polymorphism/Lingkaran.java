public class Lingkaran extends Bentuk {
    private double radius;
    public static final double PHI = 3.14159;

    public Lingkaran(double radius, String warna) {
        super(warna);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double r) {
        this.radius = r;
    }

    public double hitungLuas() {
        return PHI * this.radius * this.radius;
    }

    @Override
    public void printInfo() {
        System.out.println("Lingkaran " + getWarna() + ", luas = " + hitungLuas());
    }
}