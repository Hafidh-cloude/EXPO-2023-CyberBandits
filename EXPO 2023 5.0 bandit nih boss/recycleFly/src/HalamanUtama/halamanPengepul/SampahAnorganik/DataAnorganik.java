package HalamanUtama.halamanPengepul.SampahAnorganik;


public class DataAnorganik {
    private String Nama;
    private String JenisSampah;
    private String tanggalPengiriman;
    private String berat;
    private String totalHarga;
    private String status;

    public DataAnorganik(String nama, String jenisSampah, String tanggalPengiriman, String berat, String totalHarga, String status) {
        Nama = nama;
        JenisSampah = jenisSampah;
        this.tanggalPengiriman = tanggalPengiriman;
        this.berat = berat;
        this.totalHarga = totalHarga;
        this.status = status;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getJenisSampah() {
        return JenisSampah;
    }

    public void setJenisSampah(String jenisSampah) {
        JenisSampah = jenisSampah;
    }

    public String getTanggalPengiriman() {
        return tanggalPengiriman;
    }

    public void setTanggalPengiriman(String tanggalPengiriman) {
        this.tanggalPengiriman = tanggalPengiriman;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }
    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
