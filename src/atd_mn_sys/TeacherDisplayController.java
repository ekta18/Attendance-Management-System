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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class TeacherDisplayController implements Initializable {
    private Label perdip;
    private Label nmedip;
    private Label piddip;
    @FXML
    private TableView<Attendance> DisplayTable;
    @FXML
    private TableColumn<Attendance,String> stime;
    @FXML
    private TableColumn<Attendance,String> etime;
    @FXML
    private TableColumn<Attendance,String> sub;
    @FXML
    private TableColumn<Attendance,String> sname;
    @FXML
    private TableColumn<Attendance,String> atd;
    
    ObservableList<Attendance> aattdd = FXCollections.observableArrayList();
    
    private StudentInfo stuinfo;
    private String ppiidd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void Textint(StudentInfo stu){
        stuinfo = stu;
        System.out.println(stuinfo);
        nmedip.setText(stuinfo.getNamee());
        piddip.setText(stuinfo.getPidd());
        ppiidd = stuinfo.getPidd();
    } 

    @FXML
    private void onhome(ActionEvent event) {
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

    @FXML
    private void ondisplay(ActionEvent event) {
        System.out.println(ppiidd);
        stime.setCellValueFactory(new PropertyValueFactory<>("sstime"));
        etime.setCellValueFactory(new PropertyValueFactory<>("eetime"));
        sub.setCellValueFactory(new PropertyValueFactory<>("ssuid"));
        sname.setCellValueFactory(new PropertyValueFactory<>("ppid"));
        atd.setCellValueFactory(new PropertyValueFactory<>("sstatus"));
        float per = 0;
        
        try {
                int ext;
                int mat = 1;
                
                int pcount = 0;
                int acount = 0;
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attd_mng_sys","root","ekta"); 
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM attendance";

                ResultSet rs = stmt.executeQuery(String.format(query));
                while(rs.next())
                {
                    aattdd.add(new Attendance(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
                    ext = rs.getInt(6);
                    if(ext == mat){
                        pcount = pcount + 1;
                    }
                    else{
                        acount = acount + 1;
                    }
                }
                per = pcount * 100 / (pcount + acount);
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        String sper = Float.toString(per);
        DisplayTable.setItems(aattdd);
        perdip.setText(sper);
    }

    @FXML
    private void onlogout(ActionEvent event) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void onback(ActionEvent event) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
