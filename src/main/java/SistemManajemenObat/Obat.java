package SistemManajemenObat;

public class Obat {
    private String idObat;
    private String namaObat;
    private int stok;
    private double harga;
    private KategoriObat kategori;

    public Obat(String idObat, String namaObat, int stok, double harga, KategoriObat kategori) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        this.stok = stok;
        this.harga = harga;
        this.kategori = kategori;
    }

    public String getIdObat() {
        return idObat;
    }
    
    public String getNamaObat() {
        return namaObat;
    }

    public int getStok() {
        return stok;
    }
    
    public KategoriObat getKategori() {
        return kategori;
    }

    public double getHarga() {
        return harga;
    }

    public void setIdObat(String idObat) {
        this.idObat = idObat;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setKategori(KategoriObat kategori) {
        this.kategori = kategori;
    }
    
    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    public void tampilkanInfo() {
        System.out.printf("| %-8s | %-18s | %-15s | %-6d | Rp %-10.2f |", 
                idObat, namaObat, kategori.getNamaKategori(), stok, harga);
    }
    // Method Overloading
    public void tampilkanInfo(boolean ringkas){
        if (ringkas) {
            System.out.println(namaObat + " [" + idObat + "]");
        } else {
            tampilkanInfo();
        }
    }

}