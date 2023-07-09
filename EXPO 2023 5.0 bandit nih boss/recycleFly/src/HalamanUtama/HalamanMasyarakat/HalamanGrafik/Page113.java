package HalamanUtama.HalamanMasyarakat.HalamanGrafik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Page113 implements Initializable {

    @FXML
    private TextField txtField1;

    @FXML
    private TextField txtField2;

    @FXML
    private TextField txtField3;

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private Button bttn1;

    @FXML
    private Button bttn2;

    private ObservableList<XYChart.Data<String, Integer>> jenis = FXCollections.observableArrayList();
    private ObservableList<DataGrafik> data = FXCollections.observableArrayList();

    @FXML
    private void tombolTambah(ActionEvent event) {
        String A = txtField1.getText();
        String B = txtField2.getText();
    
        // Validasi input
        if (A.isEmpty() || B.isEmpty()) {
            // Jika input kosong, tampilkan pesan kesalahan
            System.out.println("Mohon isi semua field!");
            return;
        }
    
        // Tambahkan data ke jenis
        XYChart.Data<String, Integer> newData = new XYChart.Data<>(A, Integer.valueOf(B));
        jenis.add(newData);
    
        // Mengatur ulang data jenis ke barChart
        XYChart.Series<String, Integer> series = new XYChart.Series<>("Data", jenis);
        barChart.getData().setAll(series);
    
        // Tambahkan data ke objek data
        data.add(new DataGrafik(A, B));
    
        // Menyimpan data ke dalam file XML
        saveDataToXML(new ArrayList<>(data));
    
        // Reset field input
        txtField1.clear();
        txtField2.clear();
    }
    

    @FXML
    private void tombolHapus(ActionEvent event) {
        String C =  txtField3.getText();
        int index = Integer.parseInt(C);

        // Validasi indeks
        if (index < 0 || index >= jenis.size()) {
            // Jika indeks tidak valid, tampilkan pesan kesalahan
            System.out.println("Indeks tidak valid!");
            return;
        }

        // Hapus data dari jenis dan objek data
        jenis.remove(index);
        data.remove(index);

        // Mengatur ulang data jenis ke barChart
        barChart.getData().setAll(new XYChart.Series<>("Data", jenis));

        // Menyimpan data ke dalam file XML
        saveDataToXML(new ArrayList<>(data));

        // Reset field input
        txtField3.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Membaca data dari file XML
        ArrayList<DataGrafik> savedData = readDataFromXML();

        // Mengisi jenis dan objek data dengan data yang dibaca
        for (DataGrafik data : savedData) {
            XYChart.Data<String, Integer> newData = new XYChart.Data<>(data.getJenisSampah(), Integer.valueOf(data.getBerat()));
            jenis.add(newData);
            this.data.add(data);
        }

        // Mengatur data jenis ke barChart
        barChart.getData().setAll(new XYChart.Series<>("Data", jenis));
    }

    private ArrayList<DataGrafik> readDataFromXML() {
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(DataGrafik.class);

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("data.xml");
            return (ArrayList<DataGrafik>) xstream.fromXML(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void saveDataToXML(ArrayList<DataGrafik> dataList) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(DataGrafik.class);

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("data.xml");
            xstream.toXML(dataList, fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
