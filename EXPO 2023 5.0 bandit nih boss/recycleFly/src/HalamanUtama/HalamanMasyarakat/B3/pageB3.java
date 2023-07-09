package HalamanUtama.HalamanMasyarakat.B3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class pageB3{

     @FXML
    private Button buttonKembali;

    @FXML
    private Button obat;

    @FXML
    private Button medis;

    @FXML
    private Button elektronik;

    @FXML
    private Button baterai;

    @FXML
    private Button buttonCatat;

    @FXML
    private void untukKembali(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/halamanMasyarakat.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }

    @FXML
    private void keBaterai(ActionEvent event) throws Exception {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/B3/Baterai/baterai.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
    private void keElektronik(ActionEvent event) throws Exception {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/B3/Elektronik/elektronik.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
        @FXML
    private void keMedis(ActionEvent event) throws Exception {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/B3/Medis/medis.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
    private void keObat(ActionEvent event) throws Exception {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/B3/Obat/obat.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
    private void keCatat(ActionEvent event) throws Exception {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/JualB3/TabelB3.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
}