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
public class AS450Stats {
    ArrayList<Cadet> cadetStats;
    
    public AS450Stats(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int num450Cadets;
    
    public int number450s(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 450){
                num450Cadets++;
            }
        }
      return num450Cadets;      
    }
    
    public double averageSitupScore(){
        double total450Sit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 450){
               total450Sit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = Math.round((total450Sit)/(num450Cadets)*100.0)/100.0;
      return averageSit;
    }
    
    public double averagePushupScore(){
        double total450Push = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 450){
               total450Push += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = Math.round((total450Push)/(num450Cadets)*100.0)/100.0;
      return averagePush;
    }
    
    public double averageRunScore(){
        double total450Run = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 450){
               total450Run += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = Math.round((total450Run)/(num450Cadets)*100.0)/100.0;
      return averageRun;
    }
    
    public double averageAbScore(){
        double total450Ab = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 450){
               total450Ab += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = Math.round((total450Ab)/(num450Cadets)*100.0)/100.0;
      return averageAb;
    }
}
