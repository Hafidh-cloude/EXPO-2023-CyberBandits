package HalamanUtama;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NextPageController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private Button masyarakat;
    @FXML
    private Button pengepul;
    @FXML
    private String username;
    @FXML
    public void setUsername(String username) {
        this.username = username;
        welcomeLabel.setText("Welcome, " + username + "!");
    }

    @FXML
    private void keMasyarakat(ActionEvent event) throws Exception {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/halamanMasyarakat.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     
    }
    
    @FXML
    private void kePengepul(ActionEvent event) throws Exception {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/halamanPengepul/halamanPengepul.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
}
}
