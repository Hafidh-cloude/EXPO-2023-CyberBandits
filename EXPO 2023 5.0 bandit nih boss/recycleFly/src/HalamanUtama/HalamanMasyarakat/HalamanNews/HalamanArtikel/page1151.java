package HalamanUtama.HalamanMasyarakat.HalamanNews.HalamanArtikel;


import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author
 */

public class page1151 implements Initializable {
    @FXML
    JFXButton Article1;
    @FXML
    JFXButton Article2;
    @FXML
    JFXButton Article3;
    @FXML
    JFXButton Article4;
    @FXML
    JFXButton Article5;

    @FXML
    private void keHomePage (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/HalamanNews/HomePage.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
    private void keArtikel1 (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/HalamanNews/HalamanArtikel/ArtikelAnorganik/HalamanArtikel1.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
    private void keArtikel2 (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/HalamanNews/HalamanArtikel/ArtikelOrganik/HalamanArtikel2.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
    private void keArtikel3 (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/HalamanNews/HalamanArtikel/ArtikelB3/HalamanArtikel3.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
    private void keArtikel4 (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/HalamanNews/HalamanArtikel/ArtikelDaurUlang/HalamanArtikel4.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
    @FXML
    private void keArtikel5 (ActionEvent event) throws IOException{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/HalamanNews/HalamanArtikel/ArtikelBusana/HalamanArtikel5.fxml.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }

    @FXML
    private void keArticlePage (ActionEvent event){
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

