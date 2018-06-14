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
public class AS250Stats {
    ArrayList<Cadet> cadetStats;
    
    public AS250Stats(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int num250Cadets;
    
    public int number250s(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 250){
                num250Cadets++;
            }
        }
      return num250Cadets;      
    }
    
    public double averageSitupScore(){
        double total250Sit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 250){
               total250Sit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = Math.round((total250Sit)/(num250Cadets)*100.0)/100.0;
      return averageSit;
    }
    
    public double averagePushupScore(){
        double total250Push = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 250){
               total250Push += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = Math.round((total250Push)/(num250Cadets)*100.0)/100.0;
      return averagePush;
    }
    
    public double averageRunScore(){
        double total250Run = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 250){
               total250Run += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = Math.round((total250Run)/(num250Cadets)*100.0)/100.0;
      return averageRun;
    }
    
    public double averageAbScore(){
        double total250Ab = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 250){
               total250Ab += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = Math.round((total250Ab)/(num250Cadets)*100.0)/100.0;
      return averageAb;
    }
}
