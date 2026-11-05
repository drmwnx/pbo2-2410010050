// Nama: Dela Apriliyana
// NPM : 2410010050
package id.ac.uniska.pbo2.uts;

/**
 * Daftar kategori barang. Urutan konstanta harus sama dengan urutan
 * item pada JComboBox cmbKategori di tab Design.
 */
public enum Kategori {
    ALAT_TULIS("Alat Tulis"),
    MAKANAN("Makanan"),
    MINUMAN("Minuman"),
    LAINNYA("Lainnya");

    private final String label;

    Kategori(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
