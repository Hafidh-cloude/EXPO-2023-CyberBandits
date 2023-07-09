package HalamanUtama.halamanPengepul.SampahB3;

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
import HalamanUtama.HalamanMasyarakat.JualB3.DataB3;

import DataBase.AlldataSampah;

public class page215 implements Initializable {

    private ObservableList<DataB3> data = FXCollections.observableArrayList();

    @FXML
    private TableView<DataB3> Mpl;
    @FXML
    private Button bt;
    @FXML
    private Button status;
    @FXML
    private TableColumn<DataB3, String> sgNama;
    @FXML
    private TableColumn<DataB3, String> sgJenisSampah;
    @FXML
    private TableColumn<DataB3, String> sgtanggalPengiriman;
    @FXML
    private TableColumn<DataB3, String> sgBerat;
    @FXML
    private TableColumn<DataB3, String> sgtotalHarga;
    @FXML
    private TableColumn<DataB3, String> sgstatus;

    private AlldataSampah dataAll = new AlldataSampah();

   private ArrayList<DataB3> readDataFromXML() {
    XStream xstream = new XStream(new StaxDriver());
    xstream.addPermission(AnyTypePermission.ANY);
    xstream.processAnnotations(DataB3.class);

    FileInputStream fileInputStream = null;
    try {
        fileInputStream = new FileInputStream("penyimpanansampah3.xml");
        return (ArrayList<DataB3>) xstream.fromXML(fileInputStream);
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


 private void saveDataToXML(ArrayList<DataB3> dataList) {
    XStream xstream = new XStream(new StaxDriver());
    xstream.addPermission(AnyTypePermission.ANY);
    xstream.processAnnotations(DataB3.class);

    FileOutputStream fileOutputStream = null;
    try {
       fileOutputStream = new FileOutputStream("penyimpanansampah3.xml");

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
        ArrayList<DataB3> dataItems = readDataFromXML();
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
private void tukarStatus(ActionEvent event) {
    DataB3 selectedData = Mpl.getSelectionModel().getSelectedItem();
    if (selectedData != null) {
        selectedData.setStatus("Selesai");
        Mpl.refresh();
        saveDataToXML(new ArrayList<>(data)); 
    }
}



}
