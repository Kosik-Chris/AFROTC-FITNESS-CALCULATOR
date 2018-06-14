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
public class HostStats {
    ArrayList<Cadet> cadetStats;
    
    public HostStats(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int numHostsCadets;
    
    public int numberHosts(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() == "MSU"){
                numHostsCadets++;
            }
        }
      return numHostsCadets;      
    }
    
    public double averageScore(){
        double totScore = 0;
        double avgScore;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() == "MSU"){
                totScore += cadetStats.get(i).totalScore();
            }
        }
        avgScore = totScore/numHostsCadets;
        return avgScore;
    }
    
    public double averageSitScore(){
        double totalHostSit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() == "MSU"){
               totalHostSit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = Math.round((totalHostSit)/(numHostsCadets)*100.0)/100.0;
      return averageSit;
    }
    
    public double averagePushupScore(){
        double totalHostPush = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() == "MSU"){
               totalHostPush += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = Math.round((totalHostPush)/(numHostsCadets)*100.0)/100.0;
      return averagePush;
    }
    
    public double averageRunScore(){
        double totalHostRun = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() == "MSU"){
               totalHostRun += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = Math.round((totalHostRun)/(numHostsCadets)*100.0)/100.0;
      return averageRun;
    }
    
    public double averageAbScore(){
        double totalHostAb = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getSchool() == "MSU"){
               totalHostAb += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = Math.round((totalHostAb)/(numHostsCadets)*100.0)/100.0;
      return averageAb;
    }
}
