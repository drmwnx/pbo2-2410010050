// Nama: Dela Apriliyana
// NPM : 2410010050
package id.ac.uniska.pbo2.uts;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabel daftar belanja. Selain menyimpan data baris, kelas ini
 * menghitung total, diskon, dan jumlah bayar.
 */
public class BarangTableModel extends AbstractTableModel {

    private static final String[] NAMA_KOLOM
            = {"Nama Barang", "Kategori", "Harga", "Jumlah", "Subtotal"};
    private static final long BATAS_DISKON = 100000;

    private final List<Barang> daftarBarang = new ArrayList<>();

    public void tambah(Barang barang) {
        daftarBarang.add(barang);
        int baris = daftarBarang.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    /** Cek nama ganda tanpa membedakan huruf besar dan kecil. */
    public boolean sudahAda(String nama) {
        for (Barang barang : daftarBarang) {
            if (barang.getNama().equalsIgnoreCase(nama.trim())) {
                return true;
            }
        }
        return false;
    }

    public long getTotal() {
        long total = 0;
        for (Barang barang : daftarBarang) {
            total += barang.getSubtotal();
        }
        return total;
    }

    /** Diskon 10 persen (dibulatkan ke bawah) jika total minimal Rp100.000. */
    public long getDiskon() {
        long total = getTotal();
        return total >= BATAS_DISKON ? total / 10 : 0;
    }

    public long getBayar() {
        return getTotal() - getDiskon();
    }

    /** Ubah angka menjadi format rupiah, misalnya 125000 menjadi Rp125.000. */
    public static String formatRupiah(long nilai) {
        DecimalFormatSymbols simbol = new DecimalFormatSymbols();
        simbol.setGroupingSeparator('.');
        return "Rp" + new DecimalFormat("#,##0", simbol).format(nilai);
    }

    @Override
    public int getRowCount() {
        return daftarBarang.size();
    }

    @Override
    public int getColumnCount() {
        return NAMA_KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return NAMA_KOLOM[kolom];
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Barang barang = daftarBarang.get(baris);
        switch (kolom) {
            case 0:
                return barang.getNama();
            case 1:
                return barang.getKategori().toString();
            case 2:
                return formatRupiah(barang.getHarga());
            case 3:
                return barang.getJumlah();
            case 4:
                return formatRupiah(barang.getSubtotal());
            default:
                return "";
        }
    }
}
