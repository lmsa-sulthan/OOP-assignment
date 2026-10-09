public class Bentuk {
    public String warna; 

    public Bentuk(String warna) {
        this.warna = warna;
    }

    public String getWarna() {
        return this.warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void printInfo() {
        System.out.println("Bentuk berwarna " + this.warna);
    }
}