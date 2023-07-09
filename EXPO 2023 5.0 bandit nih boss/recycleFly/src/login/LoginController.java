package login;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.util.Duration;
import modeldata.DataMasyarakat;
import modeldata.DataPengepul;

public class LoginController implements Initializable {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Button login;

    @FXML
    private ToggleGroup jenisUser;

    @FXML
    private JFXRadioButton rButtonPengepul;

    @FXML
    private JFXRadioButton rButtonMasyarakat;

    @FXML
    private Button signUp;

    @FXML
    private Label labelNotif;

    String pilihanJenisUser = "";

    @FXML
    void handleButtonRadio(ActionEvent event) {
        if (rButtonMasyarakat.isSelected()) {
            pilihanJenisUser = "Penyetor";
        } else  {
            pilihanJenisUser = "Pengepul";
        }
    }

    @FXML
    void handleButtonLogin(ActionEvent event) {
        if (!usernameField.getText().equals("") && !passwordField.getText().equals("")) {
            String username = usernameField.getText();
            String pass = passwordField.getText();
            if (pilihanJenisUser.equals("Penyetor")) {

                XStream xstream = new XStream(new StaxDriver());
                xstream.addPermission(AnyTypePermission.ANY);
                FileInputStream data = null;
                try {
                    data = new FileInputStream("DataMasyarakat.xml");

                    int isi;
                    char c;
                    String stringnya = "";

                    while ((isi = data.read()) != -1) {
                        c = (char) isi;
                        stringnya += c;
                    }
                    ArrayList<DataMasyarakat> list = (ArrayList<DataMasyarakat>) xstream.fromXML(stringnya);
                    boolean flag = true;
                    for (int i = 0; i < list.size(); i++) {
                        if (username.equals(list.get(i).getUsername())
                                && pass.equals(list.get(i).getPassword())) {
                            flag = false;
                            PauseTransition pt = new PauseTransition();
                            pt.setDuration(Duration.seconds(1));
                            pt.setOnFinished(ev -> {
                                System.out.println("Login Succesfully");
                                login.getScene().getWindow().hide();
                                Stage login = new Stage();
                                Parent root;
                                try {
                                    root = FXMLLoader.load(getClass().getResource("/HalamanUtama/HalamanMasyarakat/halamanMasyarakat.fxml"));
                                    Scene scene = new Scene(root);
                                    login.setScene(scene);
                                    login.show();
                                    login.setResizable(false);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                            pt.play();
                            break;
                        }
                    }
                    if (!username.equals(list.get(0).getUsername()) && flag == true
                            || !pass.equals(list.get(0).getPassword()) && flag == true) {
                        labelNotif.setText("Ada yang salah!");
                    }
                } catch (Exception e) {
                    System.err.println("test: " + e.getMessage());
                } finally {
                    if (data != null) {
                        try {
                            data.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


            } else {
                XStream xstream = new XStream(new StaxDriver());
                xstream.addPermission(AnyTypePermission.ANY);
                FileInputStream data = null;
                try {
                    data = new FileInputStream("DataPengepul.xml");
                    int isi;
                    char c;
                    String stringnya = "";

                    while ((isi = data.read()) != -1) {
                        c = (char) isi;
                        stringnya += c;
                    }

                    ArrayList<DataPengepul> list = (ArrayList<DataPengepul>) xstream.fromXML(stringnya);
                    boolean flag = true;
                    for (int i = 0; i < list.size(); i++) {
                        if (username.equals(list.get(i).getUsername())
                                && pass.equals(list.get(i).getPassword())) {
                            flag = false;
                            PauseTransition pt = new PauseTransition();
                            pt.setDuration(Duration.seconds(1));
                            pt.setOnFinished(ev -> {
                                System.out.println("Login Succesfully");
                                login.getScene().getWindow().hide();
                                Stage login = new Stage();
                                Parent root;
                                try {
                                    root = FXMLLoader.load(getClass().getResource("/HalamanUtama/halamanPengepul/halamanPengepul.fxml"));
                                    Scene scene = new Scene(root);
                                    login.setScene(scene);
                                    login.show();
                                    login.setResizable(false);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                            pt.play();
                            break;
                        }
                    }
                    if (!username.equals(list.get(0).getUsername()) && flag == true
                            || !pass.equals(list.get(0).getPassword()) && flag == true) {
                        labelNotif.setText("Ada yang salah!");
                    }

                } catch (Exception e) {
                    System.err.println("test: " + e.getMessage());
                } finally {
                    if (data != null) {
                        try {
                            data.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @FXML
    void handleButtonSignUp(ActionEvent event) throws IOException {
        signUp.getScene().getWindow().hide();
        Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Daftar/JenisPendaftar.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
