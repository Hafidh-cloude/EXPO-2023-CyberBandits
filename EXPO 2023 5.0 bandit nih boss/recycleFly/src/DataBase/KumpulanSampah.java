package DataBase;

public class KumpulanSampah {
    private String Nama;
    private String Jenis;
    private String TanggalPengiriman;
    private String Berat;
    private String TotalHarga;
    private String Status;

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String jenis) {
        Jenis = jenis;
    }
    public String getTanggalPengiriman() {
        return TanggalPengiriman;
    }

    public void setTanggalPengiriman(String tanggalPengiriman) {
        TanggalPengiriman = tanggalPengiriman;
    }

    public String getBerat() {
        return Berat;
    }

    public void setBerat(String berat) {
        Berat = berat;
    }
    public String getTotalHarga() {
        return TotalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        TotalHarga = totalHarga;
    }
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

}
