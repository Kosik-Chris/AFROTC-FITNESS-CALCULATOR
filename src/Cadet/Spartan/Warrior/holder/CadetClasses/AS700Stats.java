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
public class AS700Stats {
    ArrayList<Cadet> cadetStats;
    
    public AS700Stats(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int num700Cadets;
    
    public int number700s(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 700){
                num700Cadets++;
            }
        }
      return num700Cadets;      
    }
    
    public double averageSitupScore(){
        double total700Sit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 700){
               total700Sit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = Math.round((total700Sit)/(num700Cadets)*100.0)/100.0;
      return averageSit;
    }
    
    public double averagePushupScore(){
        double total700Push = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 700){
               total700Push += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = Math.round((total700Push)/(num700Cadets)*100.0)/100.0;
      return averagePush;
    }
    
    public double averageRunScore(){
        double total700Run = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 700){
               total700Run += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = Math.round((total700Run)/(num700Cadets)*100.0)/100.0;
      return averageRun;
    }
    
    public double averageAbScore(){
        double total700Ab = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 700){
               total700Ab += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = Math.round((total700Ab)/(num700Cadets)*100.0)/100.0;
      return averageAb;
    }
}
