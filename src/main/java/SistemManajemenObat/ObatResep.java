package SistemManajemenObat;

public class ObatResep extends Obat {
    private String namaDokter;

    public ObatResep(String idObat, String namaObat, int stok, double harga, KategoriObat kategori, String namaDokter) {
        super(idObat, namaObat, stok, harga, kategori);
        this.namaDokter = namaDokter;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" %-22s |\n", "Dokter: " + namaDokter);
    }
}