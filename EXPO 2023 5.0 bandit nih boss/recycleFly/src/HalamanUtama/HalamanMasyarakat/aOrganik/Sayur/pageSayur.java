package HalamanUtama.HalamanMasyarakat.aOrganik.Sayur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class pageSayur{

     @FXML
    private Button buttonKembali;

    @FXML
    private Button jual;

    @FXML
    private void untukKembali(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/aOrganik/pOrganik.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
    private void keJual(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/JualOrganik/TabelOrganik.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }

}
