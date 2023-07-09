package Daftar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JenisPendaftarController implements Initializable {
    @FXML
    private Button pengepul;

    @FXML
    private Button masyarakat;


    @FXML
    void buatMasnyarakat(ActionEvent event) throws IOException {
        masyarakat.getScene().getWindow().hide();
        Stage signup2 = new Stage();
        Parent root2 = FXMLLoader.load(getClass().getResource("/Daftar/SignUpMasyarakat.fxml"));
        Scene scene2 = new Scene(root2);
        signup2.setScene(scene2);
        signup2.show();
        signup2.setResizable(false);
    }

    @FXML
    void buatPengepul(ActionEvent event) throws IOException {
        pengepul.getScene().getWindow().hide();
        Stage signup2 = new Stage();
        Parent root2 = FXMLLoader.load(getClass().getResource("/Daftar/SignUpPengepul.fxml"));
        Scene scene2 = new Scene(root2);
        signup2.setScene(scene2);
        signup2.show();
        signup2.setResizable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
