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
public class AS800Stats {
    ArrayList<Cadet> cadetStats;
    
    public AS800Stats(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int num800Cadets;
    
    public int number800s(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 800){
                num800Cadets++;
            }
        }
      return num800Cadets;      
    }
    
    public double averageSitupScore(){
        double total800Sit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 800){
               total800Sit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = Math.round((total800Sit)/(num800Cadets)*100.0)/100.0;
      return averageSit;
    }
    
    public double averagePushupScore(){
        double total800Push = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 800){
               total800Push += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = Math.round((total800Push)/(num800Cadets)*100.0)/100.0;
      return averagePush;
    }
    
    public double averageRunScore(){
        double total800Run = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 800){
               total800Run += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = Math.round((total800Run)/(num800Cadets)*100.0)/100.0;
      return averageRun;
    }
    
    public double averageAbScore(){
        double total800Ab = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 800){
               total800Ab += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = Math.round((total800Ab)/(num800Cadets)*100.0)/100.0;
      return averageAb;
    }
}
