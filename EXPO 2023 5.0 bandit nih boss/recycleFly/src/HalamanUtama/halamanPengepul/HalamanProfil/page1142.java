package HalamanUtama.halamanPengepul.HalamanProfil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import modeldata.DataMasyarakat;
import modeldata.DataPengepul;
import modeldata.DataUser;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class page1142 implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label birthLabel;

    @FXML
    private Label ttlLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label jkLabel;

    @FXML
    private Label nameEmail;

    @FXML
    private Label usernameLabel;

    private DataPengepul userData;

    public void setUserData(DataPengepul userData) {
        this.userData = userData;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Menampilkan data pengguna di halaman profil
        if (userData != null) {
            usernameLabel.setText(userData.getUsername());
            nameLabel.setText(userData.getNama());
            ttlLabel.setText(userData.getTtl());
            jkLabel.setText(userData.getJkelamin());
            nameEmail.setText(userData.getEmail());
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("DataPengepul.xml");
            XStream xstream = new XStream(new StaxDriver());
            xstream.addPermission(AnyTypePermission.ANY);
            ArrayList<DataMasyarakat> listUser = (ArrayList<DataMasyarakat>) xstream.fromXML(fileInputStream);

            for (DataUser user : listUser) {
                // Tampilkan data dari setiap objek DataUser
                nameLabel.setText(user.getUsername());
                // emailLabel.setText("Nama: " + user.getNama());
                ttlLabel.setText(user.getTtl());
                jkLabel.setText(user.getJkelamin());
                nameEmail.setText(user.getEmail());
                //System.out.println("--------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

}

