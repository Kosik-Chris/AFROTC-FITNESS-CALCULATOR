/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder;

import java.awt.Desktop;
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
import java.io.File;  
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

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
    Button newReportBtn,importBtn,addCadetBtn, finishedBtn, getReportsBtn
            ,backBtn;
    //MenuButton asYearBtn;
    Label nameLabel, sexLabel, asYearLabel, schoolLabel, ageLabel, heightLabel, weightLabel, 
            abcircumLabel, pushupsLabel, situpsLabel, runtimeLabel;
    TextField nameText,sexText, asYearText, schoolText, ageText, heightText, weightText, abText,
            pushupsText, situpsText, runtimeText;
    public Scene mainScene, dataScene,reportScene;
    ArrayList<Cadet> cadets = new ArrayList<Cadet>();
    Cadet c;
    private int pushUps,sitUps,asYear,age,mins,sec,runTime;
    private double waist,weight,height,meters;
    public double bmi = 25;
    private String name,school;
    private boolean sex;
    private String[] time;
    @Override
    public void start(Stage primaryStage)throws Exception {
        mainWindow = primaryStage;
        primaryStage.setTitle("AFROTC Fitness Calculator v0.1");
        newReportBtn = new Button();
        newReportBtn.setText("New Report");
        newReportBtn.getStyleClass().add("dark-blue");
        importBtn = new Button();
        importBtn.setText("Import Report");
        importBtn.getStyleClass().add("rich-blue");
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
        FileChooser chooseFile = new FileChooser();
        newReportBtn.setOnAction(e -> mainWindow.setScene(dataScene));
        importBtn.setOnAction(e ->chooseFile.show());
        //Upon pressing add another cadet it creates cadet with the parameters
        //in the fields (non empty other checks etc. and adds to arraylist
        //InputAction call checks all the fields first then creates cadet
        //then it sets the scene again to this scene
        addCadetBtn.setOnAction(e -> {InputAction();
                newCadet();
                mainWindow.setScene(dataScene);
                });
        //finished button does same stuff as cadet and the returns to main menu
        finishedBtn.setOnAction(e -> mainWindow.setScene(reportScene));
        backBtn.setOnAction(e -> mainWindow.setScene(mainScene));
        getReportsBtn = new Button("Get Reports!");
        getReportsBtn.getStyleClass().add("dark-blue");
        getReportsBtn.setOnAction(e -> {
            try {
                printCadetList();
                printStatistics();
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidFormatException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Pane mainLayout = new Pane();
        newReportBtn.setLayoutX(150);
        newReportBtn.setLayoutY(670);
        importBtn.setLayoutX(330);
        importBtn.setLayoutY(670);
        mainLayout.getChildren().addAll(label1,newReportBtn,importBtn);
        
        Pane reportLayout = new Pane();
        getReportsBtn.setLayoutX(320);
        getReportsBtn.setLayoutY(450);
        reportLayout.getChildren().add(getReportsBtn);
        
        mainScene = new Scene(mainLayout, 1200, 775);
        mainScene.getStylesheets().add("mainStyleSheet.css");
        dataScene = new Scene(border,1200,775);
        dataScene.getStylesheets().add("dataStyleSheet.css");
        reportScene = new Scene(reportLayout,1200,775);
        reportScene.getStylesheets().add("reportStyleSheet.css");
        
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
        backBtn = new Button();
        backBtn.setText("Main Menu");
        backBtn.getStyleClass().add("dark-blue");
        
        addCadetBtn = new Button("Add another cadet");
        addCadetBtn.getStyleClass().add("dark-blue");
        finishedBtn = new Button("Finished entering cadets");
        finishedBtn.getStyleClass().add("dark-blue");
        
        nameLabel = new Label("Name:");
        nameLabel.setAccessibleHelp("Enter as: Last Name, First Name");
        nameText = new TextField();
        
        sexLabel = new Label("Sex:");
        sexLabel.setAccessibleHelp("Enter Sex as M or F (male or femlae)");
        sexText = new TextField();
        
        asYearLabel = new Label("AS Year:");
        asYearLabel.setAccessibleHelp("Select an AS Year from the drop down");
        asYearText = new TextField();
        
        schoolLabel = new Label("School:");
        schoolLabel.setAccessibleHelp("Select a supported school");
        schoolText = new TextField();
            
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
                asYearText, schoolLabel,schoolText
                ,ageLabel,ageText,heightLabel,
                heightText,weightLabel,weightText,abcircumLabel,abText,
                pushupsLabel,pushupsText,situpsLabel,situpsText,runtimeLabel,
                runtimeText);
        btnHolder = new HBox();
        btnHolder.setPadding(new Insets(15, 12, 15, 12));
        btnHolder.setSpacing(10);
        btnHolder.getChildren().addAll(addCadetBtn,finishedBtn,backBtn);
        
    }

    public void newCadet(){
        c =  new Cadet(pushUps,sitUps,asYear, school,age,runTime,name,
                        waist,weight,bmi,height,sex);
                cadets.add(c);
    }
    
    public void FileInputAction(String name,String sex,String asYear,
            String school,String age,String pushUps,
            String sitUps,String runTime,String waist,
            String height,String weight,String bmi){
        try{
        this.name = name;
        if(sex.toUpperCase().charAt(0) == 'M'){
            this.sex = true;
        }
        if(sex.toUpperCase().charAt(0) == 'F'){
            this.sex = false;
        }
        this.asYear = Integer.parseInt(asYear);
        if(school.toUpperCase().charAt(0) == 'W'){
            this.school = "WMU";
        }
        if(school.toUpperCase().charAt(0) == 'M'){
            this.school = "MSU";
        }
        if(school.toUpperCase().charAt(0) == 'C'){
            this.school = "CMU";
        }
        if(school.toUpperCase().charAt(0) == 'L'){
            this.school = "LCC";
        }
        this.age = Integer.parseInt(age);
        while(this.age >39){
           JOptionPane.showMessageDialog(null, "Maxmimum age currently supported"
                   + "is 39 years.");
           this.age = Integer.parseInt(JOptionPane.showInputDialog(null,
               "Enter cadet age"));
       }
        this.height = Double.parseDouble(height);
        this.weight = Double.parseDouble(weight);
        this.bmi = Integer.parseInt(bmi);
        this.waist = Double.parseDouble(waist);
        this.pushUps = Integer.parseInt(pushUps);
        this.sitUps = Integer.parseInt(sitUps);
        this.runTime = Integer.parseInt(runTime);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"ERROR WITH INPUT");
        }
        
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
        if(this.schoolText.getText().toUpperCase().charAt(0) == 'W'){
            school = "WMU";
        }
        if(this.schoolText.getText().toUpperCase().charAt(0) == 'M'){
            school = "MSU";
        }
        if(this.schoolText.getText().toUpperCase().charAt(0) == 'C'){
            school = "CMU";
        }
        if(this.schoolText.getText().toUpperCase().charAt(0) == 'L'){
            school = "LCC";
        }
        
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
    
    /**
     * 
     * @throws IOException
     * This method creates the CSV file of all collected cadet data
     */
    public void printCadetList() throws IOException{
        String userHomeFolder = System.getProperty("user.home");
        BufferedWriter write;
        File file = new File(userHomeFolder,"Cadet PFA numbers.csv");
        if (!file.exists()) {
	     file.createNewFile();
	  }
        
        FileWriter fw = new FileWriter(file);
	write = new BufferedWriter(fw);
        write.write("Name,Sex,AS Year,School,Age,Push ups,Push ups score,"
                + "Sit ups,Sit ups score,RunTime, RunTime score,Waist(inches),"
                + "Waist score,Height,Weight,BMI,Total Score, Fitness rating\r\n");
        for(int i = 0; i<cadets.size(); i++) {
            write.write(cadets.get(i).getName().toUpperCase()+",");
            write.write(cadets.get(i).getSex()+",");
            write.write(cadets.get(i).getAsYear()+",");
            write.write(cadets.get(i).getSchool()+",");
            write.write(cadets.get(i).getAge()+",");
            write.write(cadets.get(i).getPushUps()+",");
            write.write(cadets.get(i).pushUpScore(cadets.get(i).getNumPushUps(),
                    cadets.get(i).getNumAge(),
                    cadets.get(i).getBSex())+",");
            write.write(cadets.get(i).getSitUps()+",");
            write.write(cadets.get(i).sitUpScore(cadets.get(i).getNumSitUps(),
                    cadets.get(i).getNumAge(),
                    cadets.get(i).getBSex())+",");
            write.write(cadets.get(i).getRunTime()+",");
            write.write(cadets.get(i).runScore(cadets.get(i).getNumRunTime(),
                    cadets.get(i).getNumAge(),
                    cadets.get(i).getBSex())+",");
            write.write(cadets.get(i).getWaist()+",");
            write.write(cadets.get(i).waistScore(cadets.get(i).getNumWaist(),
                    cadets.get(i).getNumAge(),
                    cadets.get(i).getBSex())+",");
            write.write(cadets.get(i).getHeight()+",");
            write.write(cadets.get(i).getWeight()+",");
            write.write(cadets.get(i).getBMI()+",");
            cadets.get(i).calcScores();
            write.write(cadets.get(i).totalScoreString()+",");
            write.write(cadets.get(i).value(cadets.get(i).totalScore()));
            write.write("\r\n");
            }
        write.close();
        //Outputs pdf of file to documents
        if(Desktop.isDesktopSupported() == true){
        Desktop.getDesktop().print(file);
        }
        else{
            JOptionPane.showMessageDialog(null,"Output not supported by your"
                    + " Desktop.\n"
                    + "Check security settings.");
        }
    }
    /**
     * This method will create the statistics file!
     * Includes all relevant graphs etc.
     * @throws java.io.IOException
     */
    public void printStatistics() throws IOException, InvalidFormatException{
        Calculation calc = new Calculation(cadets);
        System.out.printf("%.2f\n",calc.averageScore());
        System.out.printf("%d", calc.countFails());
        List<String> lines = Arrays.asList("Hello","hi");
        
        WordDocGenerator doc = new WordDocGenerator(
        calc.numFails,calc.getNumPass(),calc.averageScore(),calc.averagePScore(),
        calc.averageSScore(),calc.averageRScore(),calc.averageWScore(),
        calc.standardDevTotScore(),calc.standardDevPScore(),calc.standardDevSScore(),
        calc.standardDevRScore(),calc.standardDevWScore()
        );
        //Create word document according to lines
        doc.createWord(lines);
    }
    
    public void failVsPassChart() throws FileNotFoundException, IOException{

    }
    

    
}
