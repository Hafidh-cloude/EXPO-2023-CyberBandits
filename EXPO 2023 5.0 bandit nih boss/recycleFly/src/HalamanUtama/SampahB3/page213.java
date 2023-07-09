package HalamanUtama.SampahB3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import HalamanUtama.halamanPengepul.Pengiriman.page214;

public class page213 implements Initializable {

    private ObservableList<DataItem3> data = FXCollections.observableArrayList();
    private page214 page214Controller;

    @FXML
    private TableView<DataItem3> Mpl;
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
    private TableColumn<DataItem3, String> sgNama;
    @FXML
    private TableColumn<DataItem3, String> sgJenisSampah;
    @FXML
    private TableColumn<DataItem3, String> sgtanggalPengiriman;
    @FXML
    private TableColumn<DataItem3, String> sgBerat;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<DataItem3> dataItems = readDataFromXML();
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

        DataItem3 newItem = new DataItem3(Nama, JenisSampah, tanggalPengiriman, berat);
        data.add(newItem);

        saveDataToXML(new ArrayList<>(data));

        cumi1.setText("");
        cumi2.setText("");
        cumi3.setText("");
        cumi4.setText("");

        if (page214Controller != null) {
            page214Controller.updateTableViewData(data);
        }
    }

    @FXML
    private void tombolHapus(ActionEvent event) {
        DataItem3 selectedItem = Mpl.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            data.remove(selectedItem);
            saveDataToXML(new ArrayList<>(data));
        }
    }

    private ArrayList<DataItem3> readDataFromXML() {
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(DataItem3.class);

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("Bruhh/src/DataBase/penyimpanansampah.xml");
            return (ArrayList<DataItem3>) xstream.fromXML(fileInputStream);
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

    private void saveDataToXML(ArrayList<DataItem3> dataList) {
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(DataItem3.class);

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("Bruhh/src/DataBase/penyimpanansampah.xml");
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

    public ObservableList<DataItem3> getData() {
        return data;
    }

    public void setPage214Controller(page214 page214Controller) {
        this.page214Controller = page214Controller;
    }
}
