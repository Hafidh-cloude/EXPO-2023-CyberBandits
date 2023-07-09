package HalamanUtama.halamanPengepul;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class page21 implements Initializable {

    @FXML
    private Button berandaButton;
    @FXML
    private BorderPane RootPane;
    @FXML
    private AnchorPane utamaPane;
    
    @FXML
    private Button tentangKamiButton;
    @FXML
    private Button ButtonRiwayatButton1;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }

 @FXML
private void handleBerandaButtonClick(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/halamanPengepul/halamanPengepul.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

@FXML
private void handleKembali(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/login.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    } catch (IOException e) {
        e.printStackTrace();
    }
}


@FXML
private void keOrganik() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/halamanPengepul/SampahOrganik/TabelOrganik.fxml"));
        Parent newContent = loader.load();
        utamaPane.getChildren().setAll(newContent);
    } catch (IOException e) {
        e.printStackTrace();
       
    }
}
@FXML
private void keAnorganik() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/halamanPengepul/SampahAnorganik/TabelAnorganik.fxml"));
        Parent newContent = loader.load();
        utamaPane.getChildren().setAll(newContent);
    } catch (IOException e) {
        e.printStackTrace();
       
    }
}
@FXML
private void keB3() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/halamanPengepul/SampahB3/TabelB3.fxml"));
        Parent newContent = loader.load();
        utamaPane.getChildren().setAll(newContent);
    } catch (IOException e) {
        e.printStackTrace();
       
    }
}
@FXML
private void kePengiriman() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/halamanPengepul/Pengiriman/HalamanPengiriman.fxml"));
        Parent newContent = loader.load();
        utamaPane.getChildren().setAll(newContent);
    } catch (IOException e) {
        e.printStackTrace();
       
    }
}
    @FXML
    private void handleTentangKamiButtonClick() {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/halamanPengepul/pKami.fxml"));
        Parent newContent = loader.load();
        utamaPane.getChildren().setAll(newContent);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @FXML
    private void keProfil(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/halamanPengepul/HalamanProfil/HalamanProfil.fxml"));
        Parent newContent = loader.load();
        utamaPane.getChildren().setAll(newContent);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @FXML
    private void handleRiwayatButtonClick(ActionEvent event) {
        // Kode yang akan dijalankan ketika tombol Pencatatan diklik
    }

    @FXML
    private void handleGrafikPenjualanButtonClick(ActionEvent event) {
        // Kode yang akan dijalankan ketika tombol Grafik Penjualan diklik
    }
}

