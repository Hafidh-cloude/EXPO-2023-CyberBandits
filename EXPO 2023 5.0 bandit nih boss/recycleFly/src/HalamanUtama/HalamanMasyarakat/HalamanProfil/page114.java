package HalamanUtama.HalamanMasyarakat.HalamanProfil;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import modeldata.DataMasyarakat;
import modeldata.DataUser;

public class page114 implements Initializable {

    @FXML
    private Label usernameLabel;

    @FXML
    private Label namaLabel;

    @FXML
    private Label ttlLabel;

    @FXML
    private Label jkelaminLabel;

    @FXML
    private Label emailLabel;

    private DataMasyarakat userData;

    public void setUserData(DataMasyarakat userData) {
        this.userData = userData;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Menampilkan data pengguna di halaman profil
        if (userData != null) {
            usernameLabel.setText(userData.getUsername());
            namaLabel.setText(userData.getNama());
            ttlLabel.setText(userData.getTtl());
            jkelaminLabel.setText(userData.getJkelamin());
            emailLabel.setText(userData.getEmail());
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("DataMasyarakat.xml");
            XStream xstream = new XStream(new StaxDriver());
            xstream.addPermission(AnyTypePermission.ANY);
            ArrayList<DataMasyarakat> listUser = (ArrayList<DataMasyarakat>) xstream.fromXML(fileInputStream);

            for (DataUser user : listUser) {
                // Tampilkan data dari setiap objek DataUser
                namaLabel.setText(user.getUsername());
                // emailLabel.setText("Nama: " + user.getNama());
                ttlLabel.setText(user.getTtl());
                jkelaminLabel.setText(user.getJkelamin());
                emailLabel.setText(user.getEmail());
                //System.out.println("--------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
