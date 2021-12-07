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
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 */
public class InsertController implements Initializable {
    @FXML
    private TextField stime;
    @FXML
    private TextField etime;
    @FXML
    private TextField suname;
    @FXML
    private TextField sname;
    @FXML
    private Label status;
    @FXML
    private TextField atd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onAdd(ActionEvent event) {
        try{
               String name = sname.getText();
               String subname = suname.getText();
               String sstime = stime.getText();
               String eetime = etime.getText();
               String aatd = atd.getText();
               int ppid=-1;
               int ssuid = 1;
               if(name.isEmpty()){
                    status.setText("Student Name cannot be empty");
               }
               else if(subname.isEmpty()){
                    status.setText("Subject Name cannot be empty");
               }
               else if(sstime.isEmpty()){
                    status.setText("Start Time cannot be empty");
               }
               else if(eetime.isEmpty()){
                    status.setText("End Time cannot be empty");
               }
               else if(aatd.isEmpty()){
                    status.setText("Attendance cannot be empty");
               }
               else{
               //Class.forName("com.mysql.jdbc.Driver");  
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attd_mng_sys","root","ekta");
                    Statement stmt=con.createStatement(); 
                    String sql1 = "select * from student where Name='"+name+"';";
                    System.out.println(sql1);
                    ResultSet rs1=stmt.executeQuery(sql1);  
                    while(rs1.next())  
                        ppid = rs1.getInt(1);
                    System.out.println(ppid);
                    String sql2 = "select * from subject where Name='"+subname+"';";
                    System.out.println(sql2);
                    ResultSet rs2=stmt.executeQuery(sql2);  
                    while(rs2.next()){
                        ssuid = rs2.getInt(1);
                    }
                    System.out.println(ssuid);
                    String query = "INSERT INTO attendance(`Stime`, `Etime`,`PID`,`Suid`,`Status`)" +
                        "VALUES ('%s','%s','%s','%s','%s')";
                    stmt.executeUpdate(String.format(query, sstime, eetime, ppid, ssuid, aatd));
                    status.setText("Attendance Added Successful");
                    con.close();
               }
           }
           catch(Exception e){ System.out.println(e);}
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
    private void onAddStu(ActionEvent event) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("StudentAdd.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void ondetails(ActionEvent event) {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("TeacherDisplay.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
