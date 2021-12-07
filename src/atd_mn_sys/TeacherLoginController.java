/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atd_mn_sys;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class TeacherLoginController implements Initializable {
    @FXML
    private GridPane root;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button registerbutton;
    @FXML
    private Label status;
    @FXML
    private Label login;
    @FXML
    private Button loginbutton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onLogin(ActionEvent event) {
        String u = username.getText();
        String p = password.getText();
        if(u.isEmpty()){
            status.setText("Username cannot be empty");
        }else if(p.isEmpty()){
            status.setText("Password cannot be empty");
        }else {
            try {
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attd_mng_sys","root","ekta"); 
                String query = "SELECT * FROM teacher WHERE" +
                        " PID  = '%s' AND Password = '%s'";

                boolean found = con.createStatement().executeQuery(String.format(query, u, p)).next();
                if(found){
                    status.setText("Logged in successfully");
                    try{
                        Stage stage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("Insert.fxml"));
                        stage.setScene(new Scene(root));
                        stage.show();
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                }
                }else{
                    status.setText("Incorrect username/password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    private void onRegister(ActionEvent event) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("TeacherRegister.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void onBack(ActionEvent event) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Loginas.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    
    
}
