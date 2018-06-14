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
public class GMCMales {
    ArrayList<Cadet> cadetStats;
    public GMCMales(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int numGMCM = 0;
    
    public int numberGMCMales(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() <= 250){
                numGMCM++;
            }
        }
      return numGMCM;      
    }
    
    public int getNumGMCM(){
        return numGMCM;
    }
    
    public double averageScore(){
        double totS = 0;
        double avgS;
        for(int i = 0; i< cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() <= 250){
                totS += cadetStats.get(i).totalScore();
            }
        }
        
        avgS = totS/numGMCM;
        return avgS;
    }
    
    public double averageSitupScore(){
        double totalFSit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() <= 250){
               totalFSit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = (totalFSit)/(numGMCM);
      return averageSit;
    }
    
    public double averagePushupScore(){
        double totalFPush = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() <= 250){
               totalFPush += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = ((totalFPush)/(numGMCM));
      return averagePush;
    }
    
    public double averageRunScore(){
        double totalFRun = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() <= 250){
               totalFRun += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = ((totalFRun)/(numGMCM));
      return averageRun;
    }
    
    public double averageAbScore(){
        double totalFAb = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == true & cadetStats.get(i).getNumAsYear() <= 250){
               totalFAb += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = ((totalFAb)/(numGMCM));
      return averageAb;
    }
}
