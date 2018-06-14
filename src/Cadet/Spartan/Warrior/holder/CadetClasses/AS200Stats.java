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
public class AS200Stats {
    
     ArrayList<Cadet> cadetStats;
    
    public AS200Stats(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int num200Cadets;
    
    public int number200s(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 200){
                num200Cadets++;
            }
        }
      return num200Cadets;      
    }
    
    public double averageSitupScore(){
        double total200Sit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 200){
               total200Sit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = Math.round(((total200Sit)/(num200Cadets))*100.0)/100.0;
      return averageSit;
    }
    
    public double averagePushupScore(){
        double total200Push = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 200){
               total200Push += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = Math.round(((total200Push)/(num200Cadets))*100.0)/100.0;
      return averagePush;
    }
    
    public double averageRunScore(){
        double total200Run = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 200){
               total200Run += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = Math.round(((total200Run)/(num200Cadets))*100.0)/100.0;
      return averageRun;
    }
    
    public double averageAbScore(){
        double total200Ab = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 200){
               total200Ab += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = Math.round(((total200Ab)/(num200Cadets))*100.0)/100.0;
      return averageAb;
    }
}
