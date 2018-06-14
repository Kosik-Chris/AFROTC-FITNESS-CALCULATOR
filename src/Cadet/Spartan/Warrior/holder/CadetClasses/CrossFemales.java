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
public class CrossFemales {
    ArrayList<Cadet> cadetStats;
    public CrossFemales(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int numCrossF = 0;
    
    public int numberCrossFemales(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false & cadetStats.get(i).getSchool() != "MSU"){
                numCrossF++;
            }
        }
      return numCrossF;      
    }
    
    public int getNumCrossF(){
        return numCrossF;
    }
    
    public double averageScore(){
        double totS = 0;
        double avgS;
        for(int i = 0; i< cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false & cadetStats.get(i).getSchool() != "MSU"){
                totS += cadetStats.get(i).totalScore();
            }
        }
        
        avgS = totS/numCrossF;
        return avgS;
    }
    
    public double averageSitupScore(){
        double totalFSit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false & cadetStats.get(i).getSchool() != "MSU"){
               totalFSit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = (totalFSit)/(numCrossF);
      return averageSit;
    }
    
    public double averagePushupScore(){
        double totalFPush = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false & cadetStats.get(i).getSchool() != "MSU"){
               totalFPush += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = ((totalFPush)/(numCrossF));
      return averagePush;
    }
    
    public double averageRunScore(){
        double totalFRun = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false & cadetStats.get(i).getSchool() != "MSU"){
               totalFRun += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = ((totalFRun)/(numCrossF));
      return averageRun;
    }
    
    public double averageAbScore(){
        double totalFAb = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getBSex() == false & cadetStats.get(i).getSchool() != "MSU"){
               totalFAb += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = ((totalFAb)/(numCrossF));
      return averageAb;
    }
}
