/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.lang3.math.NumberUtils;
/**
 *
 * @author Christopher
 */
public class Calculation {
   ArrayList<Cadet> cadetStats;
//   ArrayList<Integer> duplicateFind = new ArrayList<Integer>();
   private int numFails,numZeroP,numZeroS,numZeroR,numZeroW,asYear;
   private int numMales,numFemales,numGmcMales,numGmcFemales,numPocMales,
           numPocFemales,numHostMales,numHostFemales,numCrosstownMales,
           numCrosstownFemales;
   private Boolean Sex;
   public Calculation(ArrayList<Cadet> cadets){
       this.cadetStats = cadets;
   }
   
   public void main(String[] args) throws IOException{
       //TODO make cool stuff
    }
   
   public int numMales(){
       for(int i = 0; i <cadetStats.size();i++){
           if(cadetStats.get(i).getBSex() == true){
               numMales++;
           }
       }
       return numMales;
   }
   
   public int numFemales(){
       for(int i = 0; i <cadetStats.size();i++){
           if(cadetStats.get(i).getBSex() == false){
               numFemales++;
           }
       }
       return numFemales;
   }
   
   public int numGmcMales(){
       for(int i = 0; i <cadetStats.size();i++){
           if(cadetStats.get(i).getBSex() == true){ 
              if(cadetStats.get(i).getNumAsYear() == 100||
                   cadetStats.get(i).getNumAsYear() == 200||
                   cadetStats.get(i).getNumAsYear() == 250){
               numGmcMales++;
           }
       }
       }
       return numGmcMales;
   }
   
   public int numGmcFemales(){
       for(int i = 0; i <cadetStats.size();i++){
           if(cadetStats.get(i).getBSex() == false){
               if(cadetStats.get(i).getNumAsYear() == 100||
                   cadetStats.get(i).getNumAsYear() == 200||
                   cadetStats.get(i).getNumAsYear() == 250){
                    numGmcFemales++;
               }
           }
       }
       return numGmcFemales;
   }
   
   public int numGmc(){
       return numGmcMales+numGmcFemales;
   }
   
   public int numPoc(){
       return numPocMales+numPocFemales;
   }
   
   public int numPocMales(){
       for(int i = 0; i <cadetStats.size();i++){
           if(cadetStats.get(i).getBSex() == true){
               if(cadetStats.get(i).getNumAsYear() == 300||
                   cadetStats.get(i).getNumAsYear() == 400||
                   cadetStats.get(i).getNumAsYear() == 450||
                   cadetStats.get(i).getNumAsYear() == 700||
                   cadetStats.get(i).getNumAsYear() == 800){
               numPocMales++;
           }
           }
       }
       return numPocMales;
   }
   
   public int numPocFemales(){
       for(int i = 0; i <cadetStats.size();i++){
           if(cadetStats.get(i).getBSex() == false){              
                 if(cadetStats.get(i).getNumAsYear() == 300||
                   cadetStats.get(i).getNumAsYear() == 400||
                   cadetStats.get(i).getNumAsYear() == 450||
                   cadetStats.get(i).getNumAsYear() == 700||
                   cadetStats.get(i).getNumAsYear() == 800){
               numPocFemales++;
           }
           }
       }
       return numPocFemales;
   }
   
   public int numHostMales(){
       for(int i = 0; i <cadetStats.size();i++){
           if(cadetStats.get(i).getSchool() == "MSU"&
                   cadetStats.get(i).getBSex() == true){
               numHostMales++;
           }
       }
       return numHostMales;
   }
   
   public int numHostFemales(){
       for(int i = 0; i <cadetStats.size();i++){
           if(cadetStats.get(i).getSchool() == "MSU"&
                   cadetStats.get(i).getBSex() == false){
               numHostFemales++;
           }
       }
       return numHostFemales;
   }
   
   public int numCrosstownMales(){
       for(int i = 0; i <cadetStats.size();i++){
           if(cadetStats.get(i).getSchool() != "MSU"&
                   cadetStats.get(i).getBSex() == true){
               numCrosstownMales++;
           }
       }
       return numCrosstownMales;
   }
   
   public int numCrosstownFemales(){
       for(int i = 0; i <cadetStats.size();i++){
           if(cadetStats.get(i).getSchool() != "MSU"&
                   cadetStats.get(i).getBSex() == false){
               numCrosstownFemales++;
           }
       }
       return numCrosstownFemales;
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
       String message = "hello";
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


//        duplicateFind.add(numZeroP);
//        duplicateFind.add(numZeroS);
//        duplicateFind.add(numZeroR);
//        duplicateFind.add(numZeroW);
//        System.out.println(duplicateFind.get(0));
        
        

        
        //compare #zero score values to find top failed
        //check to see if any are identical
        //add to list and call method for functionality
//        findDuplicates(duplicateFind);
//        int result = NumberUtils.max(zeroFind);
//        if(findDuplicates(duplicateFind) == null){
            int [] maxFailed = new int[]{numZeroP,numZeroS,numZeroR,numZeroW};
            int result = NumberUtils.max(maxFailed);
            if(result == numZeroP){
                message = "Top Failed Exercise was Push ups: "
                        +result+" fails.";
            }
            if(result == numZeroS){
                message = "Top Failed Exercise was Situps: "+result+
                        " fails.";
            }
            if(result == numZeroR){
                message = "Top Failed Exercise was 1.5 mile run: "+result+" "
                        + "fails.";
            }
            if(result == numZeroW){
                message = "Top Failed Exercise was waist measurement: "+result+" "
                        + "fails.";
            }
//        }
//        if(findDuplicates(duplicateFind) != null){
//            message = "Duplicates Found";
//        }
            
        return message;
   }
   
//   public Set<Integer> findDuplicates(<List>listContainingDuplicates)
//{ 
//    final Set<Integer> duplicates = new HashSet(); 
//    final Set<Integer> uniques = new HashSet();
//
//        for (Integer myInt : listContainingDuplicates)
//    { 
//        if (!uniques.add(myInt))
//        {
//        duplicates.add(myInt);
//        }
//    }
//        return duplicates;
//}
 
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
           if(cadetStats.get(i).getBSex() == true){
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
           if(cadetStats.get(i).getBSex() == false){
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
       double avgScore;
       for(int i = 0;i < cadetStats.size();i++){
           if(asYear == 100 & cadetStats.get(i).getNumAsYear() == 100){
           allScores += cadetStats.get(i).totalScore();
           gmcOne++;
           }
           if(asYear == 200 & cadetStats.get(i).getNumAsYear() == 200){
               allScores += cadetStats.get(i).totalScore();
           gmcTwo++;
           }
           if(asYear == 250 & cadetStats.get(i).getNumAsYear() == 250){
               allScores += cadetStats.get(i).totalScore();
           gmcTwoOne++;
           }
           if(asYear == 300 & cadetStats.get(i).getNumAsYear() == 300){
               allScores += cadetStats.get(i).totalScore();
           pocOne++;
           }
           if(asYear == 400 & cadetStats.get(i).getNumAsYear() == 400){
               allScores += cadetStats.get(i).totalScore();
           pocTwo++;
           }
           if(asYear == 450 & cadetStats.get(i).getNumAsYear() == 450){
               allScores += cadetStats.get(i).totalScore();
           pocTwoOne++;
           }
           if(asYear == 700 & cadetStats.get(i).getNumAsYear() == 700){
               allScores += cadetStats.get(i).totalScore();
           pocThree++;
           }
           if(asYear == 800 & cadetStats.get(i).getNumAsYear() == 800){
               allScores += cadetStats.get(i).totalScore();
           pocFour++;
           }
       }
       
       //Decide what category to divide by 
       double divide = 0;
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
       avgScore = allScores/divide;
       return avgScore;
   }
   
   public double avg100Score(){
       Double avgScore  = avgScoreByYear(100);
       return avgScore;
   }
   
   public double avg200Score(){
       Double avgScore = avgScoreByYear(200);
       return avgScore;
   }
   public double avg250Score(){
       Double avgScore = avgScoreByYear(250);
       return avgScore;
   }
   
   public double avg300Score(){
       Double avgScore = avgScoreByYear(300);
       return avgScore;
   }
   
   public double avg400Score(){
       Double avgScore = avgScoreByYear(400);
       return avgScore;
   }
   
   public double avg450Score(){
       Double avgScore = avgScoreByYear(450);
       return avgScore;
   }
   
   public double avg700Score(){
       Double avgScore = avgScoreByYear(700);
       return avgScore;
   }
   
   public double avg800Score(){
       Double avgScore = avgScoreByYear(800);
       return avgScore;
   }
   
   public double avgScoreBySchool(String school){
       int wmuCnt = 0;
       int msuCnt = 0;
       int cmuCnt = 0;
       int lccCnt = 0;
       double avgScoret = 0;
       double allScores = 0;
       for(int i = 0; i <cadetStats.size(); i++){
       if(school == "WMU" & cadetStats.get(i).getSchool() == "WMU"){
           wmuCnt++;
           allScores += cadetStats.get(i).totalScore();
       }
       if(school == "MSU" & cadetStats.get(i).getSchool() == "MSU"){
           msuCnt++;
           allScores += cadetStats.get(i).totalScore();
       }
       if(school == "CMU" & cadetStats.get(i).getSchool() == "CMU"){
           cmuCnt++;
           allScores += cadetStats.get(i).totalScore();
       }
       if(school == "LCC" & cadetStats.get(i).getSchool() == "LCC"){
           lccCnt++;
           allScores += cadetStats.get(i).totalScore();
       }
   }
     double divide = 0;
     if(school == "WMU"){
         divide = wmuCnt;
     }
     if(school == "MSU"){
         divide = msuCnt;
     }
     if(school == "LCC"){
         divide = lccCnt;
     }
     if(school == "CMU"){
         divide = cmuCnt;
     }
     avgScoret = allScores/divide;
   return avgScoret;
}
   /**
    * This method calculates the average based off component string
    * sent. Calls other methods
    * @param component
    * @return average based off component 
    */
   public double gmcScoreStats(String component){
       //Average total score, push up score, sit up score, run score
       //and ab score
       //Declare new variables to hold avg score per category
       double answer = 0;
       if(component == "total"){
          answer = gmcTotAverageScore();
       }
       if(component == "pushups"){
           answer = gmcPushupAverageScore();
       }
       if(component == "situps"){
           answer = gmcSitupAverageScore();
       }
       if(component == "run"){
           answer = gmcRunAverageScore();
       }
       if(component == "ab"){
           answer = gmcAbAverageScore();
       }
       return answer;
   }
   
   public double gmcTotAverageScore(){
       int numGmc = 0;
       double gmcTotScore = 0;
       double gmcAvgScore = 0;
       for(int i = 0; i <cadetStats.size(); i++){
           if(cadetStats.get(i).getNumAsYear() == 100 ||
                   cadetStats.get(i).getNumAsYear() == 200 ||
                   cadetStats.get(i).getNumAsYear() == 250){
               gmcTotScore += cadetStats.get(i).totalScore();
               numGmc++;
           }
       }
       gmcAvgScore = gmcTotScore/numGmc;
       return gmcAvgScore;
   }
   
   public double gmcSitupAverageScore(){
       double allGmcSScores = 0;
       double averageGmcSScore;
       int numGmc = 0;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 100 ||
                   cadetStats.get(i).getNumAsYear() == 200 ||
                   cadetStats.get(i).getNumAsYear() == 250){
               allGmcSScores += cadetStats.get(i).sitUpScore(
                       cadetStats.get(i).getNumSitUps(),
                       cadetStats.get(i).getNumAge(),
                       cadetStats.get(i).getBSex());
               numGmc++;
           }
       }
       averageGmcSScore = allGmcSScores/numGmc;
       return averageGmcSScore;
   }
   
   public double gmcPushupAverageScore(){
       double allGmcPScores = 0;
       double averageGmcPScore;
       int numGmc = 0;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 100 ||
                   cadetStats.get(i).getNumAsYear() == 200 ||
                   cadetStats.get(i).getNumAsYear() == 250){
               allGmcPScores += cadetStats.get(i).pushUpScore(
                       cadetStats.get(i).getNumPushUps(),
                       cadetStats.get(i).getNumAge(),
                       cadetStats.get(i).getBSex());
               numGmc++;
           }
       }
       averageGmcPScore = allGmcPScores/numGmc;
       return averageGmcPScore;
   }
   
   public double gmcRunAverageScore(){
       double allGmcRScores = 0;
       double averageGmcRScore;
       int numGmc = 0;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 100 ||
                   cadetStats.get(i).getNumAsYear() == 200 ||
                   cadetStats.get(i).getNumAsYear() == 250){
               allGmcRScores += cadetStats.get(i).runScore(
                       cadetStats.get(i).getNumRunTime(),
                       cadetStats.get(i).getNumAge(),
                       cadetStats.get(i).getBSex());
               numGmc++;
           }
       }
       averageGmcRScore = allGmcRScores/numGmc;
       return averageGmcRScore;
   }
   
   public double gmcAbAverageScore(){
       double allGmcAScores = 0;
       double averageGmcAScore;
       int numGmc = 0;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 100 ||
                   cadetStats.get(i).getNumAsYear() == 200 ||
                   cadetStats.get(i).getNumAsYear() == 250){
               allGmcAScores += cadetStats.get(i).waistScore(
                       cadetStats.get(i).getNumWaist(),
                       cadetStats.get(i).getNumAge(),
                       cadetStats.get(i).getBSex());
               numGmc++;
           }
       }
       averageGmcAScore = allGmcAScores/numGmc;
       return averageGmcAScore;
   }
   
   public double gmcRepStats(String component){
       double answer = 0;
           if(component == "pushups"){
               answer = gmcPushupAverageRep();
           }
           if(component == "situps"){
               answer = gmcSitupAverageRep();
           }
           if(component == "run"){
               answer = gmcRunAverageTime();
           }
           if(component == "ab"){
               answer = gmcAbAverageSize();
           }
           
       return answer;
   }
   
    public double gmcPushupAverageRep(){
       double allGmcPReps = 0;
       double averageGmcPReps;
       int numGmc = 0;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 100 ||
                   cadetStats.get(i).getNumAsYear() == 200 ||
                   cadetStats.get(i).getNumAsYear() == 250){
               allGmcPReps += cadetStats.get(i).getNumPushUps();
               numGmc++;
           }
       }
       averageGmcPReps = allGmcPReps/numGmc;
       return averageGmcPReps;
    }
    
    public double gmcSitupAverageRep(){
       double allGmcSReps = 0;
       double averageGmcSReps;
       int numGmc = 0;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 100 ||
                   cadetStats.get(i).getNumAsYear() == 200 ||
                   cadetStats.get(i).getNumAsYear() == 250){
               allGmcSReps += cadetStats.get(i).getNumSitUps();
               numGmc++;
           }
       }
       averageGmcSReps = allGmcSReps/numGmc;
       return averageGmcSReps;
    }
    
    public double gmcRunAverageTime(){
       int numGmc = 0;
       double allGmcRTime = 0;
       double averageGmcRTime;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 100 ||
                   cadetStats.get(i).getNumAsYear() == 200 ||
                   cadetStats.get(i).getNumAsYear() == 250){
               allGmcRTime += cadetStats.get(i).getNumRunTime();
               numGmc++;
           }
       }
       averageGmcRTime = allGmcRTime/numGmc;
       return averageGmcRTime;
    }
    
    public double gmcAbAverageSize(){
       int numGmc = 0;
       double allGmcASize = 0;
       double averageGmcASize;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 100 ||
                   cadetStats.get(i).getNumAsYear() == 200 ||
                   cadetStats.get(i).getNumAsYear() == 250){
               allGmcASize += cadetStats.get(i).getNumWaist();
               numGmc++;
           }
       }
       averageGmcASize = allGmcASize/numGmc;
       return averageGmcASize;
    }
   
   public double pocScoreStats(String component){
       double answer = 0;
       if(component == "total"){
          answer = pocTotAverageScore();
       }
       if(component == "pushups"){
           answer = pocPushupAverageScore();
       }
       if(component == "situps"){
           answer = pocSitupAverageScore();
       }
       if(component == "run"){
           answer = pocRunAverageScore();
       }
       if(component == "ab"){
           answer = pocAbAverageScore();
       }
       return answer;
   }
   
   public double pocTotAverageScore(){
       double pocTotScore = 0;
       double pocAvgScore = 0;
       int numPoc = 0;
       for(int i = 0; i <cadetStats.size(); i++){
           if(cadetStats.get(i).getNumAsYear() == 300 ||
                   cadetStats.get(i).getNumAsYear() == 400 ||
                   cadetStats.get(i).getNumAsYear() == 450 ||
                   cadetStats.get(i).getNumAsYear() == 700 ||
                   cadetStats.get(i).getNumAsYear() == 800){
               pocTotScore += cadetStats.get(i).totalScore();
               numPoc++;
           }
       }
       pocAvgScore = pocTotScore/numPoc;
       return pocAvgScore;
   }
   
   public double pocSitupAverageScore(){
       int numPoc = 0;
       double allPocSScores = 0;
       double averagePocSScore;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 300 ||
                   cadetStats.get(i).getNumAsYear() == 400 ||
                   cadetStats.get(i).getNumAsYear() == 450 ||
                   cadetStats.get(i).getNumAsYear() == 700 ||
                   cadetStats.get(i).getNumAsYear() == 800){
               allPocSScores += cadetStats.get(i).sitUpScore(
                       cadetStats.get(i).getNumSitUps(),
                       cadetStats.get(i).getNumAge(),
                       cadetStats.get(i).getBSex());
               numPoc++;
           }
       }
       averagePocSScore = allPocSScores/numPoc;
       return averagePocSScore; 
   }
   
   public double pocPushupAverageScore(){
       int numPoc = 0;
       double allPocPScores = 0;
       double averagePocPScore;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 300 ||
                   cadetStats.get(i).getNumAsYear() == 400 ||
                   cadetStats.get(i).getNumAsYear() == 450 ||
                   cadetStats.get(i).getNumAsYear() == 700 ||
                   cadetStats.get(i).getNumAsYear() == 800){
               allPocPScores += cadetStats.get(i).pushUpScore(
                       cadetStats.get(i).getNumPushUps(),
                       cadetStats.get(i).getNumAge(),
                       cadetStats.get(i).getBSex());
               numPoc++;
           }
       }
       averagePocPScore = allPocPScores/numPoc;
       return averagePocPScore;
   }
   
   public double pocRunAverageScore(){
       int numPoc = 0;
       double allPocRScores = 0;
       double averagePocRScore;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 300 ||
                   cadetStats.get(i).getNumAsYear() == 400 ||
                   cadetStats.get(i).getNumAsYear() == 450 ||
                   cadetStats.get(i).getNumAsYear() == 700 ||
                   cadetStats.get(i).getNumAsYear() == 800){
               allPocRScores += cadetStats.get(i).runScore(
                       cadetStats.get(i).getNumRunTime(),
                       cadetStats.get(i).getNumAge(),
                       cadetStats.get(i).getBSex());
               numPoc++;
           }
       }
       averagePocRScore = allPocRScores/numPoc;
       return averagePocRScore;
   }
   
   public double pocAbAverageScore(){
       int numPoc = 0;
       double allPocAScores = 0;
       double averagePocAScore;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 300 ||
                   cadetStats.get(i).getNumAsYear() == 400 ||
                   cadetStats.get(i).getNumAsYear() == 450 ||
                   cadetStats.get(i).getNumAsYear() == 700 ||
                   cadetStats.get(i).getNumAsYear() == 800){
               allPocAScores += cadetStats.get(i).waistScore(
                       cadetStats.get(i).getNumWaist(),
                       cadetStats.get(i).getNumAge(),
                       cadetStats.get(i).getBSex());
               numPoc++;
           }
       }
       averagePocAScore = allPocAScores/numPoc;
       return averagePocAScore;
   }
   
   public double pocRepStats(String component){
       double answer = 0;
           if(component == "pushups"){
               answer = pocPushupAverageRep();
           }
           if(component == "situps"){
               answer = pocSitupAverageRep();
           }
           if(component == "run"){
               answer = pocRunAverageTime();
           }
           if(component == "ab"){
               answer = pocAbAverageSize();
           }  
       return answer;
   }
   
   public double pocPushupAverageRep(){
       double allPocPReps = 0;
       double averagePocPReps;
       int numPoc = 0;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 300 ||
                   cadetStats.get(i).getNumAsYear() == 400 ||
                   cadetStats.get(i).getNumAsYear() == 450 ||
                   cadetStats.get(i).getNumAsYear() == 700 ||
                   cadetStats.get(i).getNumAsYear() == 800){
               allPocPReps += cadetStats.get(i).getNumPushUps();
               numPoc++;
           }
       }
       averagePocPReps = allPocPReps/numPoc;
       return averagePocPReps; 
   }
   
   public double pocSitupAverageRep(){
       int numPoc = 0;
       double allPocSReps = 0;
       double averagePocSReps;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 300 ||
                   cadetStats.get(i).getNumAsYear() == 400 ||
                   cadetStats.get(i).getNumAsYear() == 450 ||
                   cadetStats.get(i).getNumAsYear() == 700 ||
                   cadetStats.get(i).getNumAsYear() == 800){
               allPocSReps += cadetStats.get(i).getNumSitUps();
               numPoc++;
           }
       }
       averagePocSReps = allPocSReps/numPoc;
       return averagePocSReps;
   }
   
   public double pocRunAverageTime(){
       int numPoc = 0;
       double allPocRTime = 0;
       double averagePocRTime;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 300 ||
                   cadetStats.get(i).getNumAsYear() == 400 ||
                   cadetStats.get(i).getNumAsYear() == 450 ||
                   cadetStats.get(i).getNumAsYear() == 700 ||
                   cadetStats.get(i).getNumAsYear() == 800){
               allPocRTime += cadetStats.get(i).getNumRunTime();
               numPoc++;
           }
       }
       averagePocRTime = allPocRTime/numPoc;
       return averagePocRTime;
   }
   
   public double pocAbAverageSize(){
       int numPoc = 0;
       double allPocASize = 0;
       double averagePocASize;
       for(int i = 0;i < cadetStats.size();i++){
           if(cadetStats.get(i).getNumAsYear() == 300 ||
                   cadetStats.get(i).getNumAsYear() == 400 ||
                   cadetStats.get(i).getNumAsYear() == 450 ||
                   cadetStats.get(i).getNumAsYear() == 700 ||
                   cadetStats.get(i).getNumAsYear() == 800){
               allPocASize += cadetStats.get(i).getNumWaist();
               numPoc++;
           }
       }
       averagePocASize = allPocASize/numPoc;
       return averagePocASize; 
   }
       
}
