package HalamanUtama.SampahOrganik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class Page211 implements Initializable {

    private ObservableList<DataItem> data = FXCollections.observableArrayList();

    @FXML
    private TableView<DataItem> Mpl;
    @FXML
    private TextField cumi1;
    @FXML
    private TextField cumi2;
    @FXML
    private TextField cumi3;
    @FXML
    private Button bt;
    @FXML
    private TextField cumi4;
    @FXML
    private TableColumn<DataItem, String> sgNama;
    @FXML
    private TableColumn<DataItem, String> sgJenisSampah;
    @FXML
    private TableColumn<DataItem, String> sgtanggalPengiriman;
    @FXML
    private TableColumn<DataItem, String> sgBerat;

    private AlldataSampah dataAll = new AlldataSampah();

   private ArrayList<DataItem> readDataFromXML() {
    XStream xstream = new XStream(new StaxDriver());
    xstream.addPermission(AnyTypePermission.ANY);
    xstream.processAnnotations(DataItem.class);

    FileInputStream fileInputStream = null;
    try {
        fileInputStream = new FileInputStream("Bruhh/src/DataBase/penyimpanansampah2.xml");
        return (ArrayList<DataItem>) xstream.fromXML(fileInputStream);
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


 private void saveDataToXML(ArrayList<DataItem> dataList) {
    XStream xstream = new XStream(new StaxDriver());
    xstream.addPermission(AnyTypePermission.ANY);
    xstream.processAnnotations(DataItem.class);

    FileOutputStream fileOutputStream = null;
    try {
        fileOutputStream = new FileOutputStream("Bruhh/src/DataBase/penyimpanansampah2.xml");
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
        ArrayList<DataItem> dataItems = readDataFromXML();
        data.addAll(dataItems);

        Mpl.setItems(data);

        sgNama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        sgJenisSampah.setCellValueFactory(new PropertyValueFactory<>("JenisSampah"));
        sgtanggalPengiriman.setCellValueFactory(new PropertyValueFactory<>("tanggalPengiriman"));
        sgBerat.setCellValueFactory(new PropertyValueFactory<>("berat"));
    }

    @FXML
    private void tombolKebenaran(ActionEvent event) {
        String Nama = cumi1.getText();
        String JenisSampah = cumi2.getText();
        String tanggalPengiriman = cumi3.getText();
        String berat = cumi4.getText();

        DataItem newItem = new DataItem(Nama, JenisSampah, tanggalPengiriman, berat);
        data.add(newItem);

        saveDataToXML(new ArrayList<>(data));
    }


}
