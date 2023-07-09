package HalamanUtama.HalamanMasyarakat;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import modeldata.DataMasyarakat;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import HalamanUtama.HalamanMasyarakat.HalamanProfil.page114;

public class Page11 implements Initializable {

    @FXML
    private BorderPane rootPane;
    
    @FXML
    private AnchorPane utamaPane;

    @FXML
    private VBox leftPane;

    @FXML
    private Button berandaButton;

    @FXML
    private Button pencatatanButton;

    @FXML
    private Button grafikPenjualanButton;

    @FXML
    private Button tentangKamiButton;

    @FXML
    private Button buttonAnorganik;

    @FXML
    private Button buttonB3;

    @FXML
    private Button buttonKertas;

    @FXML
    private Button buttonBotol;

    @FXML
    private Label runningTextLabel1;

    private double initialTranslateX;
    private double textWidth;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    if (initialTranslateX == 0 && textWidth == 0) {
        initialTranslateX = runningTextLabel1.getTranslateX();

        runningTextLabel1.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {
            textWidth = newValue.getWidth();
        });
    } else {
        runningTextLabel1.setTranslateX(initialTranslateX);
    }

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, event -> {
                runningTextLabel1.setTranslateX(runningTextLabel1.getTranslateX() - 1);

                if (runningTextLabel1.getTranslateX() + textWidth <= 0) {
                    runningTextLabel1.setTranslateX(initialTranslateX + textWidth);
                }
            }),
            new KeyFrame(Duration.millis(10))
    );

    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
}

    @FXML
    private void handleBerandaButtonClick(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/halamanMasyarakat.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
    private void keNews(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/HalamanNews/HomePage.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
    private void handleKembali(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/login/login.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
@FXML
private void keProfil() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/HalamanProfil/HalamanProfil.fxml"));
        Parent newContent = loader.load();

        // Mengambil referensi ke kontroler halaman profil
        page114 profilController = loader.getController();

        // Melakukan pembacaan data dari file XML
        FileInputStream fileInputStream = new FileInputStream("DataMasyarakat.xml");
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        ArrayList<DataMasyarakat> listUser = (ArrayList<DataMasyarakat>) xstream.fromXML(fileInputStream);

        // Menggunakan data pengguna yang ditemukan dalam listUser
        // Misalnya, jika Anda ingin menggunakan data pertama dari listUser:
        DataMasyarakat userData = listUser.get(0);

        profilController.setUserData(userData);

        // Mengganti konten pane dengan halaman profil
        utamaPane.getChildren().setAll(newContent);
    } catch (IOException e) {
        e.printStackTrace();
    }
}



    
    @FXML
    private void handleGrafikPenjualanButtonClick() {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/HalamanGrafik/grafikPenjualan.fxml"));
        Parent newContent = loader.load();
        utamaPane.getChildren().setAll(newContent);
    } catch (IOException e) {
        e.printStackTrace();
       
    }

    }
    @FXML
    private void lanjutAnorganik(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/Anorganik/pAnorganik.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Nah gituu dongg...");
    }
    
    @FXML
    private void lanjutOrganik(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/aOrganik/pOrganik.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Nah gituu dongg...");
    }

    @FXML
    private void lanjutB3(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/B3/pB3.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println("Nah gituu dongg...");
    }

    @FXML
    private void handleTentangKamiButtonClick() {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/oKami.fxml"));
        Parent newContent = loader.load();
        utamaPane.getChildren().setAll(newContent);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}