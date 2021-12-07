/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atd_mn_sys;
import atd_mn_sys.Atd_Mn_Sys;
//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class LoginController implements Initializable {
    
    
    private Label label;
    @FXML
    private Label login;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginbutton;
    @FXML
    private Button registerbutton;
    @FXML
    private Label status;
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    @SuppressWarnings("null")
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
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM student WHERE" +
                        " PID  = '%s' AND Password = '%s'";

                boolean found = con.createStatement().executeQuery(String.format(query, u, p)).next();

                if(found){
                    status.setText("Logged in successfully");
                    try{
                        String query1 = "SELECT * FROM student WHERE" +" PID  = '%s'";
                        String uname = "Alm";
                        ResultSet rs = stmt.executeQuery(String.format(query1, u));
                        while(rs.next())
                        {
                            uname = rs.getString(2);
                        }
                        System.out.println(uname);
                        System.out.println(u);
                        Stage stage = new Stage();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("Display.fxml"));
                        loader.load();
//                        Parent roo = FXMLLoader.load(getClass().getResource("Display.fxml"));
                        DisplayController dspctrl = loader.<DisplayController>getController();
                        StudentInfo si = new StudentInfo(uname, u);
                        si.setNamee(uname);
                        si.setPidd(u);
                        System.out.println(dspctrl);
                        System.out.println(si.namee);
                        System.out.println(si.pidd);
                        dspctrl.Textint(si);
                        Parent roo = loader.getRoot();
                        stage.setScene(new Scene(roo));
                        stage.show();
////                        ssii.add(new StudentInfo(uname, u));
//                        StudentInfo ssii = new StudentInfo(setNamee(uname), setPidd(u));
////                        Stage stage = new Stage();
//////                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Diplay.fxml"));
////                        Parent root = FXMLLoader.load(getClass().getResource("Display.fxml"));
//////                        DisplayController dspctrlobj;
//                        System.out.println("Success1");
//////                        dspctrlobj = loader.<DisplayController>getController();
//////                        System.out.println(dspctrlobj);
//////                        dspctrlobj.Textint(ssii);
////                        stage.setScene(new Scene(root));
////                        stage.show();
//                        Stage stage = new Stage();
//                        System.out.println("Success2");
//                        Parent ro = FXMLLoader.load(getClass().getResource("Display.fxml"));
//                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Diplay.fxml"));
//                        DisplayController dspctrlobj = loader.<DisplayController>getController();
//                        dspctrlobj.Textint(ssii);
//                        System.out.println("Success3");
//                        stage.setScene(new Scene(ro));
//                        System.out.println("Success4");
//                        stage.show();
//                        System.out.println("Success5");
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
            Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
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
