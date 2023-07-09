package HalamanUtama.HalamanMasyarakat.HalamanNews;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;

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
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author
 */
public class page115 implements Initializable {

    @FXML
    private ImageView HomeBackground;

    @FXML
    private JFXTextArea Judul;

    @FXML
    private JFXTextArea Isi;

    @FXML
    private Button button;

    @FXML
    private Pagination pagination;
    private Timeline slideTimeline;

    private void setupSlideTimeline() {
        slideTimeline = new Timeline();
        slideTimeline.setCycleCount(Timeline.INDEFINITE);
        slideTimeline.getKeyFrames().add(
            new KeyFrame(Duration.seconds(5), event -> {
                int nextPage = (pagination.getCurrentPageIndex() + 1) % pagination.getPageCount();
                pagination.setCurrentPageIndex(nextPage);
                showImageForCurrentPage(); // Mengatur gambar saat halaman berubah
            })
        );
        slideTimeline.play();
    }
        @FXML
    private void handleBeranda(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/halamanMasyarakat.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }
        @FXML
    private void handleArtikel(ActionEvent event) throws Exception {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/HalamanUtama/HalamanMasyarakat/HalamanNews/HalamanArtikel/HalamanArtikel.fxml"));
        Parent root = loader.load();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        System.out.println();
    }

    private void showImageForCurrentPage() {
        int currentPageIndex = pagination.getCurrentPageIndex();
        String imagePath = ""; // Mengatur path gambar sesuai dengan halaman
        switch (currentPageIndex) {
        case 0:
            imagePath = "Image/SampahAnOrganik.png";
            Judul.setText("Sangat memprihatinkan\r\n" + //
                    "Tiap tahun, 1.000 penyu mati \r\n" + //
                    "Karena sampah plastik !");
            Isi.setText("Sampah-sampah itu menyumbat perut penyu sehingga ia mati kelaparan. \r\n" + //
                    "Bahkan mungkin polusi plastik akan membuat tingkat kematian penyu lebih besar lagi. \r\n" + //
                    "Itu karena para peneliti mengatakan bahwa jumlah 1.000 kematian . . . .");
            break;
        case 1:
            imagePath = "Image/SampahOrganik.jpg";
            Judul.setText("Bahaya sampah organik \r\n" + //
                    "Yang belum terkelola \r\n" + //
                    "Secara maksimal");
            Isi.setText("Bau busuk menyengat ke rongga hidung saat berada di belakang Pasar Induk Keramatjati, DKI Jakarta. \r\n" + //
                    "Pasalnya, tumpukan sampah yang didominasi oleh material organik dari berbagai macam \r\n" + //
                    "sayur-sayuran dan buah-buahan itu sudah membusuk dan warnanya menghitam. . . .");
            break;
        case 2:
            imagePath = "Image/SampahB3.jpg";
            Judul.setText("Berbahaya dan beracun ! \r\n" + //
                    "Kenali lebih lanjut tentang \r\n" + //
                    "Sampah B3");
            Isi.setText("Sampah B3 dihasilkan dari proses industri, dalam dalam berbagai bentuk, seperti cairan, gas padat atau lumpur. \r\n" + //
                    "Tapi tidak semua sampah yang berwujud cairan, gas padat dan lumpur adalah sampah berbahaya \r\n" + //
                    "Untuk mengetahui apakan sampah tersebut termasuk dalam jenis sampah B3 atau tidak, perlu dilakukan pengujian. . . .");
            break;
        }
        Image image = new Image(imagePath);
        HomeBackground.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int numPages = 3; // Jumlah halaman
        pagination.setPageCount(numPages);
        setupSlideTimeline();

    // Mengatur gambar awal saat aplikasi dimulai
        showImageForCurrentPage();
        
        Judul.setEditable(false);
        Isi.setEditable(false);
    }    
    
}

