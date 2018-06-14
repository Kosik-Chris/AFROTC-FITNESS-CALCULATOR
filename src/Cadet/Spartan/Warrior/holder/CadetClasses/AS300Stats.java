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
public class AS300Stats {
    ArrayList<Cadet> cadetStats;
    
    public AS300Stats(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int num300Cadets;
    
    public int number300s(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 300){
                num300Cadets++;
            }
        }
      return num300Cadets;      
    }
    
    public double averageSitupScore(){
        double total300Sit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 300){
               total300Sit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = Math.round((total300Sit)/(num300Cadets)*100.0)/100.0;
      return averageSit;
    }
    
    public double averagePushupScore(){
        double total300Push = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 300){
               total300Push += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = Math.round((total300Push)/(num300Cadets)*100.0)/100.0;
      return averagePush;
    }
    
    public double averageRunScore(){
        double total300Run = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 300){
               total300Run += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = Math.round((total300Run)/(num300Cadets)*100.0)/100.0;
      return averageRun;
    }
    
    public double averageAbScore(){
        double total300Ab = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 300){
               total300Ab += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = Math.round((total300Ab)/(num300Cadets)*100.0)/100.0;
      return averageAb;
    }
}
