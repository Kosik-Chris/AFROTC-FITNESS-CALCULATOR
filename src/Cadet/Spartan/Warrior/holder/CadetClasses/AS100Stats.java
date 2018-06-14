/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder.CadetClasses;

import Cadet.Spartan.Warrior.holder.Cadet;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Christopher
 */
public class AS100Stats {
    ArrayList<Cadet> cadetStats;
    public AS100Stats(ArrayList<Cadet> cadets) {
        this.cadetStats = cadets;
    }
    
    int num100Cadets = 0;
    
    public int number100s(){
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 100){
                num100Cadets++;
            }
        }
      return num100Cadets;      
    }
    
    public double averageSitupScore(){
        double total100Sit = 0;
        double averageSit;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 100){
               total100Sit += cadetStats.get(i).sitUpScore(cadetStats.get(i).getNumSitUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageSit = (total100Sit)/(num100Cadets);
      return averageSit;
    }
    
    public double averagePushupScore(){
        double total100Push = 0;
        double averagePush;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 100){
               total100Push += cadetStats.get(i).pushUpScore(cadetStats.get(i).getNumPushUps(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averagePush = ((total100Push)/(num100Cadets));
      return averagePush;
    }
    
    public double averageRunScore(){
        double total100Run = 0;
        double averageRun;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 100){
               total100Run += cadetStats.get(i).runScore(cadetStats.get(i).getNumRunTime(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageRun = ((total100Run)/(num100Cadets));
      return averageRun;
    }
    
    public double averageAbScore(){
        double total100Ab = 0;
        double averageAb;
        for(int i = 0; i <cadetStats.size(); i++){
            if(cadetStats.get(i).getNumAsYear() == 100){
               total100Ab += cadetStats.get(i).waistScore(cadetStats.get(i).getNumWaist(),
                        cadetStats.get(i).getNumAge(),
                        cadetStats.get(i).getBSex());
            }
        }
        averageAb = ((total100Ab)/(num100Cadets));
      return averageAb;
    }
    
    
    
}
