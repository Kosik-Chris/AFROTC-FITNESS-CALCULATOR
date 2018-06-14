/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder.CadetClasses;

import Cadet.Spartan.Warrior.holder.Cadet;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Christopher
 */
public class MalesStats {
    ArrayList<Cadet> cadetStats;
    public MalesStats(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int numMaleCadets = 0;
    
    public int numberMaless(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true){
                numMaleCadets++;
            }
        }
      return numMaleCadets;      
    }
    
    public double averageScore(){
        double totalMaleS = 0;
        double averageS;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true){
               totalMaleS += cadetStats.get(i).totalScore();
            }
        }
        averageS = (totalMaleS)/(numMaleCadets);
      return averageS;
    }
    
    public int getNumMale(){
        return numMaleCadets;
    }
    
    public double averageSitupScore(){
        double totalMaleSit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true){
               totalMaleSit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = (totalMaleSit)/(numMaleCadets);
      return averageSit;
    }
    
    public double averagePushupScore(){
        double totalMalePush = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true){
               totalMalePush += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = ((totalMalePush)/(numMaleCadets));
      return averagePush;
    }
    
    public double averageRunScore(){
        double totalMaleRun = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true){
               totalMaleRun += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = ((totalMaleRun)/(numMaleCadets));
      return averageRun;
    }
    
    public double averageAbScore(){
        double totalMaleAb = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true){
               totalMaleAb += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = ((totalMaleAb)/(numMaleCadets));
      return averageAb;
    }
    

    public int averageSitRep(){
        int totR = 0;
        int avgR;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true){
               totR += cadetStats.get(i).getNumSitUps();
            }
        }
        avgR = ((totR)/(numMaleCadets));
      return avgR;
    }
    
    public int averagePushRep(){
        int totR = 0;
        int avgR;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true){
               totR += cadetStats.get(i).getNumSitUps();
            }
        }
        avgR = ((totR)/(numMaleCadets));
      return avgR;
    }
    
    public String averageRunTime(){
        int totR = 0;
        int avgR;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true){
               totR += cadetStats.get(i).getNumRunTime();
            }
        }
        avgR = ((totR)/(numMaleCadets));
      int min;
      int sec;
      
      min = avgR/60;
      sec = avgR%60;
      
      String answer = min+":"+sec;
      return answer;
    }
    
    public int averageAbSize(){
        int totR = 0;
        int avgR;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true){
               totR += cadetStats.get(i).getNumWaist();
            }
        }
        avgR = ((totR)/(numMaleCadets));
      return avgR; 
    }
}
