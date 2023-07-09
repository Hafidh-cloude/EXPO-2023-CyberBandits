package HalamanUtama.halamanPengepul.Pengiriman;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.net.URL;
import java.util.ResourceBundle;

import HalamanUtama.SampahB3.DataItem3;

public class page214 implements Initializable {

    ObservableList<DataItem4> data = FXCollections.observableArrayList();

    @FXML
    private TableView<DataItem4> Mpl;
    @FXML
    private TextField cumi1;
    @FXML
    private TextField cumi2;
    @FXML
    private TextField cumi3;
    @FXML
    private TableColumn<DataItem4, String> sgNama;
    @FXML
    private TableColumn<DataItem4, String> sgtanggalPengiriman;
    @FXML
    private TableColumn<DataItem4, String> sgBerat;

    @FXML
    private void tombolKebenaran(ActionEvent event) {
        String Temp1 = cumi1.getText();
        String Temp2 = cumi2.getText();
        String Temp3 = cumi3.getText();

        data.add(new DataItem4(Temp1, Temp2, Temp3, Temp3, Temp3, Temp3));
        cumi1.setText("");
        cumi2.setText("");
        cumi3.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sgNama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        sgtanggalPengiriman.setCellValueFactory(new PropertyValueFactory<>("tanggalPengiriman"));
        sgBerat.setCellValueFactory(new PropertyValueFactory<>("Berat"));
        Mpl.setItems(data);
    }

    // Metode untuk mendapatkan data dari TableView "Pengiriman"
    public ObservableList<DataItem4> getData() {
        return data;
    }

    public void updateTableViewData(ObservableList<DataItem3> data2) {
    }
}
