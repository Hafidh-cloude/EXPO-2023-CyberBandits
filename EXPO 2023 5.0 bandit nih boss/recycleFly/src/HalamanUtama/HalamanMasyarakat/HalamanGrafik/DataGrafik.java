package HalamanUtama.HalamanMasyarakat.HalamanGrafik;

public class DataGrafik {
    private String jenisSampah;
    private String berat;

    public DataGrafik(String jenisSampah, String berat) {
        this.jenisSampah = jenisSampah;
        this.berat = berat;
    }

    public String getJenisSampah() {
        return jenisSampah;
    }

    public void setJenisSampah(String jenisSampah) {
        this.jenisSampah = jenisSampah;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }
}
