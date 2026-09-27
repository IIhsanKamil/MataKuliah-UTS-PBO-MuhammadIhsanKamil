package SistemManajemenObat;

public class ObatBebas extends Obat {
    private String efekSamping;

    public ObatBebas(String idObat, String namaObat, int stok, double harga, KategoriObat kategori, String efekSamping) {
        super(idObat, namaObat, stok, harga, kategori);
        this.efekSamping = efekSamping;
    }
    // Method Override
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" %-22s |\n", "Efek: " + efekSamping);
    }
}