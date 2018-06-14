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
public class CrosstownStats {
        ArrayList<Cadet> cadetStats;
    
    public CrosstownStats(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int numCrossCadets;
    
    public int numberCross(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() != "MSU"){
                numCrossCadets++;
            }
        }
      return numCrossCadets;      
    }
    
        public double averageScore(){
        double totScore = 0;
        double avgScore;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() != "MSU"){
                totScore += cadetStats.get(i).totalScore();
            }
        }
        avgScore = totScore/numCrossCadets;
        return avgScore;
    }
    
    public double averageSitScore(){
        double totalCrossSit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() != "MSU"){
               totalCrossSit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = Math.round((totalCrossSit)/(numCrossCadets)*100.0)/100.0;
      return averageSit;
    }
    
    public double averagePushupScore(){
        double totalCrossPush = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() != "MSU"){
               totalCrossPush += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = Math.round((totalCrossPush)/(numCrossCadets)*100.0)/100.0;
      return averagePush;
    }
    
    public double averageRunScore(){
        double totalCrossRun = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() != "MSU"){
               totalCrossRun += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = Math.round((totalCrossRun)/(numCrossCadets)*100.0)/100.0;
      return averageRun;
    }
    
    public double averageAbScore(){
        double totalCrossAb = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() != "MSU"){
               totalCrossAb += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = Math.round((totalCrossAb)/(numCrossCadets)*100.0)/100.0;
      return averageAb;
    }
}
