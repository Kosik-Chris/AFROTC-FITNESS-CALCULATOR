/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder.CadetClasses;

import Cadet.Spartan.Warrior.holder.Cadet;
import java.util.ArrayList;

/**
 *
 * @author Christopher
 */
public class FemalesStats {
        ArrayList<Cadet> cadetStats;
    public FemalesStats(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int numFemaleCadets = 0;
    
    public int numberFemaless(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false){
                numFemaleCadets++;
            }
        }
      return numFemaleCadets;      
    }
    
    public int getNumF(){
        return numFemaleCadets;
    }
    
    public double averageScore(){
        double totS = 0;
        double avgS;
        for(int i = 0; i< cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false){
                totS += cadetStats.get(i).totalScore();
            }
        }
        
        avgS = totS/numFemaleCadets;
        return avgS;
    }
    
    public double averageSitupScore(){
        double totalFSit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false){
               totalFSit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = (totalFSit)/(numFemaleCadets);
      return averageSit;
    }
    
    public double averagePushupScore(){
        double totalFPush = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false){
               totalFPush += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = ((totalFPush)/(numFemaleCadets));
      return averagePush;
    }
    
    public double averageRunScore(){
        double totalFRun = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false){
               totalFRun += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = ((totalFRun)/(numFemaleCadets));
      return averageRun;
    }
    
    public double averageAbScore(){
        double totalFAb = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false){
               totalFAb += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = ((totalFAb)/(numFemaleCadets));
      return averageAb;
    }
    
    public int averageSitRep(){
        int totR = 0;
        int avgR;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false){
               totR += cadetStats.get(i).getNumSitUps();
            }
        }
        avgR = ((totR)/(numFemaleCadets));
      return avgR;
    }
    
    public int averagePushRep(){
        int totR = 0;
        int avgR;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false){
               totR += cadetStats.get(i).getNumPushUps();
            }
        }
        avgR = ((totR)/(numFemaleCadets));
      return avgR;
    }
    
    public String averageRunTime(){
        int totR = 0;
        int avgR;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false){
               totR += cadetStats.get(i).getNumRunTime();
            }
        }
        avgR = ((totR)/(numFemaleCadets));
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
            if(cadetStats.get(i).getBSex() == false){
               totR += cadetStats.get(i).getNumWaist();
            }
        }
        avgR = ((totR)/(numFemaleCadets));
      return avgR; 
    }
}
