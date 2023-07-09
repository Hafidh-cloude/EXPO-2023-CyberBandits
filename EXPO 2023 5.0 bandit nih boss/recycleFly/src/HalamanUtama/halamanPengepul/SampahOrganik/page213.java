package HalamanUtama.halamanPengepul.SampahOrganik;

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
import HalamanUtama.HalamanMasyarakat.JualOrganik.DataOrganik;

import DataBase.AlldataSampah;

public class page213 implements Initializable {

    private ObservableList<DataOrganik> data = FXCollections.observableArrayList();

    @FXML
    private TableView<DataOrganik> Mpl;
    @FXML
    private Button status;

    @FXML
    private TableColumn<DataOrganik, String> sgNama;
    @FXML
    private TableColumn<DataOrganik, String> sgJenisSampah;
    @FXML
    private TableColumn<DataOrganik, String> sgtanggalPengiriman;
    @FXML
    private TableColumn<DataOrganik, String> sgBerat;
    @FXML
    private TableColumn<DataOrganik, String> sgtotalHarga;
    @FXML
    private TableColumn<DataOrganik, String> sgstatus;

    private AlldataSampah dataAll = new AlldataSampah();

   private ArrayList<DataOrganik> readDataFromXML() {
    XStream xstream = new XStream(new StaxDriver());
    xstream.addPermission(AnyTypePermission.ANY);
    xstream.processAnnotations(DataOrganik.class);

    FileInputStream fileInputStream = null;
    try {
        fileInputStream = new FileInputStream("penyimpanansampah.xml");
        return (ArrayList<DataOrganik>) xstream.fromXML(fileInputStream);
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


 private void saveDataToXML(ArrayList<DataOrganik> dataList) {
    XStream xstream = new XStream(new StaxDriver());
    xstream.addPermission(AnyTypePermission.ANY);
    xstream.processAnnotations(DataOrganik.class);

    FileOutputStream fileOutputStream = null;
    try {
       fileOutputStream = new FileOutputStream("penyimpanansampah.xml");

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

@Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<DataOrganik> dataItems = readDataFromXML();
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
        DataOrganik selectedData = Mpl.getSelectionModel().getSelectedItem();
        if (selectedData != null) {
            selectedData.setStatus("Selesai");
            Mpl.refresh();
            saveDataToXML(new ArrayList<>(data)); 
        }
    }
    
}
