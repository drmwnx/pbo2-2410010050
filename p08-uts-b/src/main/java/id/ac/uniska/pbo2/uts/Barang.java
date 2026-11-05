// Nama: Dela Apriliyana
// NPM : 2410010050
package id.ac.uniska.pbo2.uts;

/**
 * Data satu barang belanja beserta perhitungan subtotalnya.
 */
public class Barang {

    private final String nama;
    private final Kategori kategori;
    private final int harga;
    private final int jumlah;

    public Barang(String nama, Kategori kategori, int harga, int jumlah) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public int getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    /** Subtotal = harga dikali jumlah (long agar tidak overflow). */
    public long getSubtotal() {
        return (long) harga * jumlah;
    }
}
