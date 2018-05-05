/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher
 */
public class MainMenu extends Application {
    BorderPane border;
    FlowPane dataLayout;
    HBox btnHolder; 
    //VBox dataLayout;
    Stage mainWindow;
    Button btn,addCadetBtn, finishedBtn, getReportsBtn;
    //MenuButton asYearBtn;
    Label nameLabel, sexLabel, asYearLabel, ageLabel, heightLabel, weightLabel, 
            abcircumLabel, pushupsLabel, situpsLabel, runtimeLabel;
    TextField nameText,sexText, asYearText, ageText, heightText, weightText, abText,
            pushupsText, situpsText, runtimeText;
    Scene mainScene, dataScene,reportScene;
    ArrayList<Cadet> cadets = new ArrayList<Cadet>();
    Cadet c;
    private int pushUps,sitUps,asYear,age,mins,sec,runTime;
    private double waist,weight,height,meters;
    public double bmi = 25;
    private String name;
    private boolean sex;
    private String[] time;
    @Override
    public void start(Stage primaryStage)throws Exception {
        mainWindow = primaryStage;
        primaryStage.setTitle("AFROTC Fitness Calculator v0.1");
        btn = new Button();
        btn.setText("New Report");
        btn.getStyleClass().add("green");
        Label label1 = new Label("The AFROTC Fitness Calculator was created to\n"
                + " assist in obtaining detachment wide PT statistics.\n This "
                + "program generates a report for you\n after you have finished"
                + " entering in cadets PT results.");
        
        label1.setWrapText(true);
        label1.setLayoutX(0);
        label1.setLayoutY(375);
        DataInput();
        //**********************MAIN LAYOUT FOR DATA************************
        border = new BorderPane();

        border.setLeft(dataLayout);
        border.setBottom(btnHolder);
        //*********************END MAIN LAYOUT FOR DATA*********************
        btn.setOnAction(e -> mainWindow.setScene(dataScene));
        //Upon pressing add another cadet it creates cadet with the parameters
        //in the fields (non empty other checks etc. and adds to arraylist
        //InputAction call checks all the fields first then creates cadet
        //then it sets the scene again to this scene
        addCadetBtn.setOnAction(e -> {InputAction();
                System.out.println(name+bmi);
                c =  new Cadet(pushUps,sitUps,asYear,age,runTime,name,
                        waist,weight,bmi,height,sex);
                cadets.add(c);
                mainWindow.setScene(dataScene);
                });
        //finished button does same stuff as cadet and the returns to main menu
        finishedBtn.setOnAction(e -> mainWindow.setScene(reportScene));
        
        getReportsBtn = new Button("Get Reports!");
        getReportsBtn.getStyleClass().add("green");
        getReportsBtn.setOnAction(e -> {
            try {
                printCadetList();
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Pane mainLayout = new Pane();
        btn.setLayoutX(320);
        btn.setLayoutY(450);
        mainLayout.getChildren().addAll(label1,btn);
        
        Pane reportLayout = new Pane();
        getReportsBtn.setLayoutX(320);
        getReportsBtn.setLayoutY(450);
        reportLayout.getChildren().add(getReportsBtn);
        
        mainScene = new Scene(mainLayout, 1200, 775);
        mainScene.getStylesheets().add("Styles.css");
        dataScene = new Scene(border,1200,775);
        reportScene = new Scene(reportLayout,1200,775);
        
        //dataScene.getStylesheets().add("Styles.css");
        //Below code is a lambda expression! super nice! Basically it gets 
        //around having to implement EventHandler and using the handle method
        //it ties it directly to this button too! INCREDIBLE
        mainWindow.setScene(mainScene);
        mainWindow.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void DataInput(){
        
        
        addCadetBtn = new Button("Add another cadet");
        finishedBtn = new Button("Finished entering cadets");
        
        nameLabel = new Label("Name:");
        nameLabel.setAccessibleHelp("Enter as: Last Name, First Name");
        nameText = new TextField();
        
        sexLabel = new Label("Sex:");
        sexLabel.setAccessibleHelp("Enter Sex as M or F (male or femlae)");
        sexText = new TextField();
        
        asYearLabel = new Label("AS Year:");
        asYearLabel.setAccessibleHelp("Select an AS Year from the drop down");
        asYearText = new TextField();
            
        
        ageLabel = new Label("Age:");
        ageLabel.setAccessibleHelp("Enter users age as a whole Integer");
        ageText = new TextField();
        
        heightLabel = new Label("Height:");
        heightLabel.setAccessibleHelp("Enter the Height in INCHES");
        heightText = new TextField();
        
        weightLabel = new Label("Weight:");
        weightLabel.setAccessibleHelp("Enter weight in LBS");
        weightText = new TextField();
        
        abcircumLabel = new Label("Abdominal Circumfrence:");
        abcircumLabel.setAccessibleHelp("Enter AB circumfrence in INCHES");
        abText = new TextField();
        
        pushupsLabel = new Label("Push ups:");
        pushupsLabel.setAccessibleHelp("Enter # push ups");
        pushupsText = new TextField();
        
        situpsLabel = new Label("Sit ups:");
        situpsLabel.setAccessibleHelp("Enter # sit ups");
        situpsText = new TextField();
        
        runtimeLabel = new Label("1.5 mile run time:");
        runtimeLabel.setAccessibleHelp("Enter the time as a colon seperated value\n"
                + "E.G 11:15");
        runtimeText = new TextField();
        
        dataLayout = new FlowPane();
        dataLayout.setPadding(new Insets(5, 0, 5, 0));
        dataLayout.setVgap(4);
        dataLayout.setHgap(4);
        dataLayout.setPrefWrapLength(170); // preferred width allows for two columns
        
        dataLayout.getChildren().addAll(nameLabel,nameText,sexLabel,sexText,
                asYearLabel,
                asYearText
                ,ageLabel,ageText,heightLabel,
                heightText,weightLabel,weightText,abcircumLabel,abText,
                pushupsLabel,pushupsText,situpsLabel,situpsText,runtimeLabel,
                runtimeText);
        btnHolder = new HBox();
        btnHolder.setPadding(new Insets(15, 12, 15, 12));
        btnHolder.setSpacing(10);
        btnHolder.getChildren().addAll(addCadetBtn,finishedBtn);
        
    }

    public void InputAction(){
        //TODO work on exceptions and user interface aspects
        try{
        name = this.nameText.getText();
        if(this.sexText.getText().toUpperCase().charAt(0) == 'M'){
            sex = true;
        }
        if(this.sexText.getText().toUpperCase().charAt(0) == 'F'){
            sex = false;
        }
        asYear = Integer.parseInt(this.asYearText.getText());
        age = Integer.parseInt(this.ageText.getText());
        while(age >39){
           JOptionPane.showMessageDialog(null, "Maxmimum age currently supported"
                   + "is 39 years.");
           age = Integer.parseInt(JOptionPane.showInputDialog(null,
               "Enter cadet age"));
       }
        height = Double.parseDouble(this.heightText.getText());
        weight = Double.parseDouble(this.weightText.getText());
        waist = Double.parseDouble(this.abText.getText());
        pushUps = Integer.parseInt(this.pushupsText.getText());
        sitUps = Integer.parseInt(this.situpsText.getText());
        time = this.runtimeText.getText().split(":");
        mins = Integer.parseInt(time[0]);
        sec = Integer.parseInt(time[1]);
        runTime = sec + (mins*60);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"ERROR WITH INPUT");
        }
        
    }
    
    
    public void printCadetList() throws IOException{
        BufferedWriter write;
        File file = new File("Cadet PFA numbers.csv");
        if (!file.exists()) {
	     file.createNewFile();
	  }
        FileWriter fw = new FileWriter(file);
	write = new BufferedWriter(fw);
        write.write("Name,Sex,Age,AS Year,Push ups,"
                + "Sit ups,RunTime,Waist(inches),BMI,Result\r\n");
        for(int i = 0; i<cadets.size(); i++) {
            write.write(cadets.get(i).getName()+",");
            write.write(cadets.get(i).getSex()+",");
            write.write(cadets.get(i).getAge()+",");
            write.write(cadets.get(i).getAsYear()+",");
            write.write(cadets.get(i).getPushUps()+",");
            write.write(cadets.get(i).getSitUps()+",");
            write.write(cadets.get(i).getRunTime()+",");
            write.write(cadets.get(i).getWaist()+",");
            write.write(cadets.get(i).getBMI()+",");
            cadets.get(i).calcScores();
            write.write(cadets.get(i).value(cadets.get(i).totalScore()));
            write.write("\r\n");
            }
        write.close();
        
    }
    
    public void doStatistics(){
        Calculation calc = new Calculation(cadets);
    }
    
}