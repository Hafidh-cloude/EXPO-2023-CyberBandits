package HalamanUtama.SampahOrganik;


public class DataItem {
    private String Nama;
    private String JenisSampah;
    private String tanggalPengiriman;
    private String berat;

    public DataItem(String nama, String jenisSampah, String tanggalPengiriman, String berat) {
        Nama = nama;
        JenisSampah = jenisSampah;
        this.tanggalPengiriman = tanggalPengiriman;
        this.berat = berat;
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
}

