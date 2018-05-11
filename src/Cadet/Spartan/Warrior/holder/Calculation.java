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
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.math.NumberUtils;
import java.lang.Integer;
/**
 *
 * @author Christopher
 */
public class Calculation {
   ArrayList<Cadet> cadetStats;
   List<Integer> duplicateFind;
   int numFails,numZeroP,numZeroS,numZeroR,numZeroW,asYear;
   private Boolean Sex;
   public Calculation(ArrayList<Cadet> cadets){
       this.cadetStats = cadets;
   }
   
   public void main(String[] args) throws IOException{
       //TODO make cool stuff
        
    }
   
   public int countFails(){
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).value(cadetStats.get(i).totalScore()).equals("UNSAT")){
               numFails++;
           }
       }
       return numFails;
   }
   
   public int getNumPass(){
       int numPass = (cadetStats.size()-numFails);
       return numPass;
   }
   
   public String topFailedExercise(){
       String message = "";
        for(int i = 0;i < cadetStats.size();i++){
            if(cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                    cadetStats.get(i).getNumAge(),
                    cadetStats.get(i).getBSex()) == 0){
                numZeroP++;
            }
            if(cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                    cadetStats.get(i).getNumAge(),
                    cadetStats.get(i).getBSex()) == 0){
                numZeroS++;
            }
            if(cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                    cadetStats.get(i).getNumAge(),
                    cadetStats.get(i).getBSex()) == 0){
                numZeroR++;
            }
            if(cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                    cadetStats.get(i).getNumAge(),
                    cadetStats.get(i).getBSex()) == 0){
                numZeroW++;
            }
        }
        
        //compare #zero score values to find top failed
        //check to see if any are identical
        //add to list and call method for functionality
        duplicateFind.add(numZeroP);
        duplicateFind.add(numZeroS);
        duplicateFind.add(numZeroR);
        duplicateFind.add(numZeroW);
        findDuplicates(duplicateFind);
//        int result = NumberUtils.max(zeroFind);
        if(findDuplicates(duplicateFind) == null){
            int [] maxFailed = new int[]{numZeroP,numZeroS,numZeroR,numZeroW};
            int result = NumberUtils.max(maxFailed);
            if(result == numZeroP){
                message = "Top Failed Exercise was Push ups: "
                        +result+" number of fails.";
            }
            if(result == numZeroS){
                message = "Top Failed Exercise was Situps: "+result+
                        " number of fails.";
            }
            if(result == numZeroR){
                message = "Top Failed Exercise was 1.5 mile run: "+result+" "
                        + "number of fails.";
            }
            if(result == numZeroW){
                message = "Top Failed Exercise was waist measurement: "+result+" "
                        + "number of fails.";
            }
        }
        if(findDuplicates(duplicateFind) != null){
            message = findDuplicates(duplicateFind).toString();
        }
            
        return message;
   }
   
   public Set<Integer> findDuplicates(List<Integer> listContainingDuplicates)
{ 
    final Set<Integer> duplicates = new HashSet(); 
    final Set<Integer> uniques = new HashSet();

        for (Integer myInt : listContainingDuplicates)
    { 
        if (!uniques.add(myInt))
        {
        duplicates.add(myInt);
        }
    }
        return duplicates;
}
 
   public double averageScore(){
       double allScores = 0;
       double averageScore;
       for(int i = 0;i < cadetStats.size();i++){
           allScores += cadetStats.get(i).totalScore();
       }
       averageScore = allScores/(cadetStats.size());
       return averageScore;
   }
   
   public double averagePScore(){
       double allScores = 0;
       double averagePScore;
       for(int i = 0;i < cadetStats.size();i++){
           allScores += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                   cadetStats.get(i).getNumAge(),
                   cadetStats.get(i).getBSex());
       }
       averagePScore = allScores/(cadetStats.size());
       return averagePScore;
   }
   
   public double averageSScore(){
       double allScores = 0;
       double averageSScore;
       for(int i = 0;i < cadetStats.size();i++){
           allScores += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                   cadetStats.get(i).getNumAge(),
                   cadetStats.get(i).getBSex());
       }
       averageSScore = allScores/(cadetStats.size());
       return averageSScore;
   }
   
   public double averageRScore(){
       double allScores = 0;
       double averageRScore;
       for(int i = 0;i < cadetStats.size();i++){
           allScores += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                   cadetStats.get(i).getNumAge(),
                   cadetStats.get(i).getBSex());
       }
       averageRScore = allScores/(cadetStats.size());
       return averageRScore;
   }
   
   public double averageWScore(){
       double allScores = 0;
       double averageWScore;
       for(int i = 0;i < cadetStats.size();i++){
           allScores += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                   cadetStats.get(i).getNumAge(),
                   cadetStats.get(i).getBSex());
       }
       averageWScore = allScores/(cadetStats.size());
       return averageWScore;
   }
   
   public double standardDevPScore(){
       double avgP = averagePScore();
       double squareDiff = 0;
       double answer;
       for(int i = 0; i< cadetStats.size(); i++){
           double temp = cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps()
                   ,cadetStats.get(i).getNumAge(),
                   cadetStats.get(i).getBSex());
           double hold = (temp - avgP);
           double holdSqr = hold*hold;
           squareDiff += holdSqr;
       }
      answer = (squareDiff/cadetStats.size());
      return answer;
   }
   
   public double standardDevSScore(){
       double avgS = averageSScore();
       double squareDiff = 0;
       double answer;
       for(int i = 0; i< cadetStats.size(); i++){
           double temp = cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps()
                   ,cadetStats.get(i).getNumAge(),
                   cadetStats.get(i).getBSex());
           double hold = (temp - avgS);
           double holdSqr = hold*hold;
           squareDiff += holdSqr;
       }
      answer = (squareDiff/cadetStats.size());
      return answer;
   }
   
   public double standardDevRScore(){
       double avgR = averageRScore();
       double squareDiff = 0;
       double answer;
       for(int i = 0; i< cadetStats.size(); i++){
           double temp = cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime()
                   ,cadetStats.get(i).getNumAge(),
                   cadetStats.get(i).getBSex());
           double hold = (temp - avgR);
           double holdSqr = hold*hold;
           squareDiff += holdSqr;
       }
      answer = (squareDiff/cadetStats.size());
      return answer;
   }
   
   public double standardDevWScore(){
       double avgW = averageWScore();
       double squareDiff = 0;
       double answer;
       for(int i = 0; i< cadetStats.size(); i++){
           double temp = cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist()
                   ,cadetStats.get(i).getNumAge(),
                   cadetStats.get(i).getBSex());
           double hold = (temp - avgW);
           double holdSqr = hold*hold;
           squareDiff += holdSqr;
       }
      answer = (squareDiff/cadetStats.size());
      return answer;
   }
   
   /**
    * 
    * @return standard deviation of all scores 
    */
   public double standardDevTotScore(){
       double avg = averageScore();
       double squareDiff = 0;
       double answer;
       for(int i = 0; i< cadetStats.size(); i++){
           double temp = cadetStats.get(i).totalScore();
           double hold = (temp - avg);
           double holdSqr = hold*hold;
           squareDiff += holdSqr;
       }
      answer = (squareDiff/cadetStats.size());
      return answer;
   }
   /**
    * 
    * @Method returns average scores for males 
    */
   public double avgScoreBySexM(){
       int maleCnt = 0;
       double allScores = 0;
       double averageScore;
       for(int i = 0;i < cadetStats.size();i++){
           Sex = cadetStats.get(i).getBSex();
           if(Sex = true){
               allScores += cadetStats.get(i).totalScore();
               maleCnt++;
           }
       }
       averageScore = allScores/maleCnt;
       return averageScore;
   }
   
   /**
    * 
    * @Method returns average scores for females 
    */
   public double avgScoreBySexF(){
       int femaleCnt = 0;
       double allScores = 0;
       double averageScore;
       for(int i = 0;i < cadetStats.size();i++){
           Sex = cadetStats.get(i).getBSex();
           if(Sex = false){
               allScores += cadetStats.get(i).totalScore();
               femaleCnt++;
           }
       }
       averageScore = allScores/femaleCnt;
       return averageScore;
   }
   
   public double avgScoreByYear(int asYear){
       // AS 100
       int gmcOne = 0;
       // AS 200
       int gmcTwo = 0;
       // AS 250
       int gmcTwoOne = 0;
       // AS 300
       int pocOne = 0;
       // AS 400
       int pocTwo = 0;
       // AS 450
       int pocTwoOne = 0;
       // AS 700
       int pocThree = 0;
       // AS 800
       int pocFour = 0;
       double allScores = 0;
       double averageScore;
       for(int i = 0;i < cadetStats.size();i++){
           if(asYear == 100){
           allScores += cadetStats.get(i).totalScore();
           gmcOne++;
           }
           if(asYear == 200){
               allScores += cadetStats.get(i).totalScore();
           gmcTwo++;
           }
           if(asYear == 250){
               allScores += cadetStats.get(i).totalScore();
           gmcTwoOne++;
           }
           if(asYear == 300){
               allScores += cadetStats.get(i).totalScore();
           pocOne++;
           }
           if(asYear == 400){
               allScores += cadetStats.get(i).totalScore();
           pocTwo++;
           }
           if(asYear == 450){
               allScores += cadetStats.get(i).totalScore();
           pocTwoOne++;
           }
           if(asYear == 700){
               allScores += cadetStats.get(i).totalScore();
           pocThree++;
           }
           if(asYear == 800){
               allScores += cadetStats.get(i).totalScore();
           pocFour++;
           }
       }
       
       //Decide what category to divide by 
       int divide = 0;
       if(asYear == 100){
           divide = gmcOne;
       }
       if(asYear == 200){
           divide = gmcTwo;
       }
       if(asYear == 250){
           divide = gmcTwoOne;
       }
       if(asYear == 300){
           divide = pocOne;
       }
       if(asYear == 400){
           divide = pocTwo;
       }
       if(asYear == 450){
           divide = pocTwoOne;
       }
       if(asYear == 700){
           divide = pocThree;
       }
       if(asYear == 800){
           divide = pocFour;
       }
       averageScore = allScores/divide;
       return averageScore;
   }
   
}
