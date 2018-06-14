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
public class POCMales {
    ArrayList<Cadet> cadetStats;
    public POCMales(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int numPOCM = 0;
    
    public int numberPOCMales(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() >= 300){
                numPOCM++;
            }
        }
      return numPOCM;      
    }
    
    public int getNumPOCM(){
        return numPOCM;
    }
    
    public double averageScore(){
        double totS = 0;
        double avgS;
        for(int i = 0; i< cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() >= 300){
                totS += cadetStats.get(i).totalScore();
            }
        }
        
        avgS = totS/numPOCM;
        return avgS;
    }
    
    public double averageSitupScore(){
        double totalFSit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() >= 300){
               totalFSit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = (totalFSit)/(numPOCM);
      return averageSit;
    }
    
    public double averagePushupScore(){
        double totalFPush = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() >= 300){
               totalFPush += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = ((totalFPush)/(numPOCM));
      return averagePush;
    }
    
    public double averageRunScore(){
        double totalFRun = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() >= 300){
               totalFRun += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = ((totalFRun)/(numPOCM));
      return averageRun;
    }
    
    public double averageAbScore(){
        double totalFAb = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() >= 300){
               totalFAb += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = ((totalFAb)/(numPOCM));
      return averageAb;
    }
}
