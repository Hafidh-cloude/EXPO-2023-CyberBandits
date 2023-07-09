package HalamanUtama.HalamanMasyarakat.JualAnorganik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import DataBase.AlldataSampah;

public class page117 implements Initializable {

    private ObservableList<DataAnorganik> data = FXCollections.observableArrayList();

    @FXML
    private TableView<DataAnorganik> Mpl;
    @FXML
    private TextField cumi1;
    @FXML
    private TextField cumi2;
    @FXML
    private TextField cumi3;
    @FXML
    private TextField cumi4;
    @FXML
    private Button bt;
    @FXML
    private TextField cumi5;
    @FXML
    private TableColumn<DataAnorganik, String> sgNama;
    @FXML
    private TableColumn<DataAnorganik, String> sgJenisSampah;
    @FXML
    private TableColumn<DataAnorganik, String> sgtanggalPengiriman;
    @FXML
    private TableColumn<DataAnorganik, String> sgBerat;
    @FXML
    private TableColumn<DataAnorganik, String> sgtotalHarga;
    @FXML
    private TableColumn<DataAnorganik, String> sgstatus;

    private AlldataSampah dataAll = new AlldataSampah();

   private ArrayList<DataAnorganik> readDataFromXML() {
    XStream xstream = new XStream(new StaxDriver());
    xstream.addPermission(AnyTypePermission.ANY);
    xstream.processAnnotations(DataAnorganik.class);

    FileInputStream fileInputStream = null;
    try {
        fileInputStream = new FileInputStream("penyimpanansampah2.xml");
        return (ArrayList<DataAnorganik>) xstream.fromXML(fileInputStream);
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


 private void saveDataToXML(ArrayList<DataAnorganik> dataList) {
    XStream xstream = new XStream(new StaxDriver());
    xstream.addPermission(AnyTypePermission.ANY);
    xstream.processAnnotations(DataAnorganik.class);

    FileOutputStream fileOutputStream = null;
    try {
       fileOutputStream = new FileOutputStream("penyimpanansampah2.xml");

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


    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<DataAnorganik> dataItems = readDataFromXML();
        data.addAll(dataItems);

        Mpl.setItems(data);

        sgNama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        sgJenisSampah.setCellValueFactory(new PropertyValueFactory<>("JenisSampah"));
        sgtanggalPengiriman.setCellValueFactory(new PropertyValueFactory<>("tanggalPengiriman"));
        sgBerat.setCellValueFactory(new PropertyValueFactory<>("berat"));
        sgtotalHarga.setCellValueFactory(new PropertyValueFactory<>("TotalHarga"));
        sgstatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
    }

    @FXML
    private void tombolKebenaran(ActionEvent event) {
        String Nama = cumi1.getText();
        String JenisSampah = cumi2.getText();
        String tanggalPengiriman = cumi3.getText();
        String berat = cumi4.getText();
        String totalHarga = cumi5.getText();
        String status = "Dalam Proses...";

        DataAnorganik newItem = new DataAnorganik(Nama, JenisSampah, tanggalPengiriman, berat, totalHarga, status);
        data.add(newItem);

        saveDataToXML(new ArrayList<>(data));    
        // Mengosongkan TextField setelah menambahkan data
        cumi1.clear();
        cumi2.clear();
        cumi3.clear();
        cumi4.clear();
        cumi5.clear();
    }
        @FXML
    private void untukKembali(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/halamanMasyarakat.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
private void hapusData(ActionEvent event) {
    DataAnorganik selectedItem = Mpl.getSelectionModel().getSelectedItem();
    if (selectedItem != null) {
        data.remove(selectedItem);
        saveDataToXML(new ArrayList<>(data));
    }
}
@FXML
private void hapusSemuaData(ActionEvent event) {
    data.clear();
    saveDataToXML(new ArrayList<>(data));
}



}
