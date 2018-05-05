/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Christopher
 */
public class Calculation {
   private  int pushUps,sitUps,asYear,age,runTime;
   private  String name;
   private  double waist,totalScore,pScore,sScore,rScore,wScore,weight,bmi
           ,height;
   private  boolean sex, passOrFail;
   private  String scoreValue;
   ArrayList<Cadet> cadetStats;
   
   public Calculation(ArrayList<Cadet> cadets){
       this.cadetStats = cadets;
   }
   
   public void main(String[] args) throws IOException{
       //TODO make cool stuff
        
    }
   
}
