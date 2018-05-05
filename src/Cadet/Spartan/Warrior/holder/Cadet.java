/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder;

/**
 *
 * @author Christopher
 */
public class Cadet {
   private  int pushUps,sitUps,asYear,age,runTime;
   private  String name;
   private  double waist,totalScore,pScore,sScore,rScore,wScore,weight,bmi
           ,height;
   private  boolean sex, passOrFail;
   private  String scoreValue;
   //Constructor
     public Cadet(int pushUps,int sitUps,int asYear,int age,int runTime,
    String name,double waist,double weight,double bmi, double height,
    boolean sex ){
        this.pushUps = pushUps;
        this.sitUps = sitUps;
        this.asYear = asYear;
        this.age = age;
        this.runTime = runTime;
        this.name = name;
        this.waist = waist;
        this.weight = weight;
        this.bmi = bmi;
        this.height = height;
        this.sex = sex;
    }
     
   public void calcScores(){
       
       pushUpScore(pushUps,age,sex);
       sitUpScore(sitUps,age,sex);
       runScore(runTime,age,sex);
       waistScore(waist,age,sex);
       totalScore();
   }  
     
    public String getPushUps() {
        return Integer.toString(pushUps);
    }

    public String getSitUps() {
        return Integer.toString(sitUps);
    }

    public  String getAsYear() {
        return Integer.toString(asYear);
    }

    public  String getAge() {
        return Integer.toString(age);
    }

    public  String getRunTime() {
        return Integer.toString(runTime);
    }

    public  String getSex() {
        if(sex == true){
            return "Male";
        }
        else{
            return "Female";
        }
    }

    public  String getName() {
        return name;
    }

    public String getWaist() {
        return Double.toString(waist);
    }
    public String getBMI(){
        return Double.toString(bmi);
    }
    
    public double pushUpScore(int pushUps, int age, boolean sex){
        if(age< 30){
           if (sex == true) {
               //Males
               if(pushUps >=67){
                   pushUps = 67;
               }
               switch(pushUps){
                   case 33:
                       pScore = 5.0;
                       break;
                   case 34:
                       pScore = 5.3;
                       break;
                   case 35:
                       pScore = 5.5;
                       break;
                   case 36:
                       pScore = 5.8;
                       break;
                   case 37:
                       pScore = 6.0;
                       break;
                   case 38:
                       pScore = 6.3;
                       break;
                   case 39:
                       pScore = 6.5;
                       break;
                   case 40:
                       pScore = 6.8;
                       break;
                   case 41:
                       pScore = 7.0;
                       break;
                   case 42:
                       pScore = 7.2;
                       break;
                   case 43:
                       pScore = 7.3;
                       break;
                   case 44:
                       pScore = 7.5;
                       break;
                   case 45:
                       pScore = 7.7;
                       break;
                   case 46:
                       pScore=7.8;
                       break;
                   case 47:
                       pScore=8.0;
                       break;
                   case 48:
                       pScore=8.1;
                       break;
                   case 49:
                       pScore=8.3;
                       break;
                   case 50:
                       pScore=8.4;
                       break;
                   case 51:
                       pScore=8.5;
                       break;
                   case 52:
                       pScore=8.6;
                       break;
                   case 53:
                       pScore=8.7;
                       break;
                   case 54:
                       pScore=8.8;
                       break;
                   case 55:
                       pScore=8.8;
                       break;
                   case 56:
                       pScore=8.9;
                       break;
                   case 57:
                       pScore=9.0;
                       break;
                   case 58:
                       pScore = 9.1;
                       break;
                   case 59:
                       pScore = 9.2;
                       break;
                   case 60:
                       pScore=9.3;
                       break;
                   case 61:
                       pScore=9.4;
                       break;
                   case 62: case 63: case 64: case 65: case 66:
                       pScore=9.5;
                       break;
                   case 67:
                       pScore = 10.0;
                       break;
                   default:
                       pScore = 0;
                       break;     
                               
               }
           }
           if(sex == false){
               //Females
               if(pushUps >=47){
                   pushUps = 47;
               }
               switch(pushUps){
                   case 18:
                       pScore = 5.0;
                       break;
                   case 19:
                       pScore = 5.5;
                       break;
                   case 20:
                       pScore = 5.8;
                       break;
                   case 21:
                       pScore = 6.0;
                       break;
                   case 22:
                       pScore = 6.3;
                       break;
                   case 23:
                       pScore = 6.5;
                       break;
                   case 24:
                       pScore = 7.0;
                       break;
                   case 25:
                       pScore = 7.2;
                       break;
                   case 26:
                       pScore = 7.3;
                       break;
                   case 27:
                       pScore = 7.5;
                       break;
                   case 28:
                       pScore = 8.0;
                       break;
                   case 29:
                       pScore = 8.1;
                       break;
                   case 30:
                       pScore = 8.2;
                       break;
                   case 31:
                       pScore = 8.3;
                       break;
                   case 32:
                       pScore = 8.4;
                       break;
                   case 33:
                       pScore = 8.5;
                       break;
                   case 34:
                       pScore = 8.6;
                       break;
                   case 35:
                       pScore = 8.8;
                       break;
                   case 36:
                       pScore = 8.9;
                       break;
                   case 37:
                       pScore = 9.0;
                       break;
                   case 38:
                       pScore = 9.1;
                       break;
                   case 39:
                       pScore = 9.2;
                       break;
                   case 40:
                       pScore = 9.3;
                       break;
                   case 41:
                       pScore = 9.4;
                       break;
                   case 42: case 43: case 44: case 45: case 46:
                       pScore = 9.5;
                       break;
                   case 47:
                       pScore = 10.0;
                       break;
                   default:
                       pScore = 0;
                       break;
                   
               }
           }
            
        }
      if(age >=30 && age <=39){
          if(sex == true){
              //male
              if(pushUps >=57){
                   pushUps = 57;
               }
               switch(pushUps){
                   case 27:
                       pScore = 5.0;
                       break;
                   case 28:
                       pScore = 5.3;
                       break;
                   case 29:
                       pScore = 5.5;
                       break;
                   case 30:
                       pScore = 6.0;
                       break;
                   case 31:
                       pScore = 6.5;
                       break;
                   case 32:
                       pScore = 6.7;
                       break;
                   case 33:
                       pScore = 6.8;
                       break;
                   case 34:
                       pScore = 7.0;
                       break;
                   case 35:
                       pScore = 7.3;
                       break;
                   case 36:
                       pScore = 7.5;
                       break;
                   case 37:
                       pScore = 7.7;
                       break;
                   case 38:
                       pScore = 7.8;
                       break;
                   case 39:
                       pScore = 8.0;
                       break;
                   case 40:
                       pScore=8.3;
                       break;
                   case 41:
                       pScore=8.5;
                       break;
                   case 42:
                       pScore=8.6;
                       break;
                   case 43:
                       pScore=8.7;
                       break;
                   case 44:
                       pScore=8.8;
                       break;
                   case 45:
                       pScore=8.9;
                       break;
                   case 46:
                       pScore=9.0;
                       break;
                   case 47:
                       pScore=9.1;
                       break;
                   case 48:
                       pScore=9.2;
                       break;
                   case 49:
                       pScore=9.2;
                       break;
                   case 50:
                       pScore=9.3;
                       break;
                   case 51:
                       pScore=9.4;
                       break;
                   case 52: case 53: case 54: case 55: case 56:
                       pScore = 9.5;
                       break;
                   
                   case 57:
                       pScore = 10.0;
                       break;
                   default:
                       pScore = 0;
                       break;     
                               
               }
              
          }
          if(sex ==false){
               //Females
               if(pushUps >=46){
                   pushUps = 46;
               }
               switch(pushUps){
                   case 14:
                       pScore = 5.0;
                       break;
                   case 15:
                       pScore = 6.0;
                       break;
                   case 16:
                       pScore = 6.5;
                       break;
                   case 17:
                       pScore = 6.8;
                       break;
                   case 18:
                       pScore = 7.0;
                       break;
                   case 19:
                       pScore = 7.5;
                       break;
                   case 20:
                       pScore = 7.6;
                       break;
                   case 21:
                       pScore = 7.8;
                       break;
                   case 22:
                       pScore = 7.9;
                       break;
                   case 23:
                       pScore = 8.0;
                       break;
                   case 24:
                       pScore = 8.2;
                       break;
                   case 25:
                       pScore = 8.3;
                       break;
                   case 26:
                       pScore = 8.5;
                       break;
                   case 27:
                       pScore = 8.6;
                       break;
                   case 28:
                       pScore = 8.6;
                       break;
                   case 29:
                       pScore = 8.7;
                       break;
                   case 30:
                       pScore = 8.8;
                       break;
                   case 31: case 32:
                       pScore = 8.9;
                       break;
                   case 33:
                       pScore = 9.0;
                       break;
                   case 34:
                       pScore = 9.1;
                       break;
                   case 35:
                       pScore = 9.1;
                       break;
                   case 36:
                       pScore = 9.2;
                       break;
                   case 37: case 38:
                       pScore = 9.3;
                       break;
                   case 39:
                       pScore = 9.4;
                       break;  
                   case 40: case 41: case 42: case 43: case 44: case 45:
                       pScore = 9.5;
                       break;
                   case 46:
                       pScore = 10.0;
                       break;
                   default:
                       pScore = 0;
                       break; 
               }
          }     
      }
      return pScore;  
    }
    
    public double sitUpScore(int sitUps, int age, boolean sex){
        if(age <30){
                       if(sex == true){
                           //male
                                if (sitUps>=58) {
					sScore = 10;
				} else if (sitUps<58 && sitUps>54) {
					sScore = 9.5;
				} else if (sitUps==54) {
					sScore = 9.4;
				} else if (sitUps==53) {
					sScore = 9.2;
				} else if (sitUps==52) {
					sScore = 9;
				} else if (sitUps==51) {
					sScore = 8.8;
				} else if (sitUps==50) {
					sScore = 8.7;
				} else if (sitUps==49) {
					sScore = 8.5;
				} else if (sitUps==48) {
					sScore = 8.3;
				} else if (sitUps==47) {
					sScore = 8;
				} else if (sitUps==46) {
					sScore = 7.5;
				} else if (sitUps==45) {
					sScore = 7;
				} else if (sitUps==44) {
					sScore = 6.5;
				} else if (sitUps==43) {
					sScore = 6.3;
				} else if (sitUps==42) {
					sScore = 6;
				} else {
					sScore = 0;
				}
                       }
                       if(sex == false){
                       //female
                       if (sitUps>=54) {
					sScore = 10;
				} else if (sitUps<54 && sitUps>50) {
					sScore += 9.5;
				} else if (sitUps==50) {
					sScore = 9.4;
				} else if (sitUps==49) {
					sScore = 9;
				} else if (sitUps==48) {
					sScore = 8.9;
				} else if (sitUps==47) {
					sScore = 8.8;
				} else if (sitUps==46) {
					sScore = 8.6;
				} else if (sitUps==45) {
					sScore = 8.5;
				} else if (sitUps==44) {
					sScore = 8;
				} else if (sitUps==43) {
					sScore = 7.8;
				} else if (sitUps==42) {
					sScore = 7.5;
				} else if (sitUps==41) {
					sScore = 7;
				} else if (sitUps==40) {
					sScore = 6.8;
				} else if (sitUps==39) {
					sScore = 6.5;
				} else if (sitUps==38) {
					sScore = 6;
				} else {
					sScore = 0;
				}
                       }
        }
        if(age >= 30 && age <=39){
            if(sex == false){
                if (sitUps>=45) {
					sScore = 10;
				} else if (sitUps<45 && sitUps>41) {
					sScore = 9.5;
				} else if (sitUps==41) {
					sScore = 9.4;
				} else if (sitUps==40) {
					sScore = 9;
				} else if (sitUps==39) {
					sScore = 8.8;
				} else if (sitUps==38) {
                                        sScore = 8.5;
				} else if (sitUps==37) {
					sScore = 8.3;
				} else if (sitUps==36) {
					sScore = 8.2;
				} else if (sitUps==35) {
					sScore = 8;
				} else if (sitUps==34) {
					sScore = 7.8;
				} else if (sitUps==33) {
					sScore = 7.5;
				} else if (sitUps==32) {
					sScore = 7;
				} else if (sitUps==31) {
					sScore = 6.8;
				} else if (sitUps==30) {
					sScore = 6.5;
				} else if (sitUps ==29) {
					sScore = 6;
				} else {
					sScore = 0;
				}
            }
            if(sex == true){
                if (sitUps>=54) {
					sScore = 10;
				} else if (sitUps<54 && sitUps>50) {
					sScore = 9.5;
				} else if (sitUps==50) {
					sScore = 9.4;
				} else if (sitUps==49) {
					sScore = 9.2;
				} else if (sitUps==48) {
					sScore = 9;
				} else if (sitUps==47) {
					sScore = 8.8;
				} else if (sitUps==46) {
					sScore = 8.7;
				} else if (sitUps==45) {
					sScore = 8.5;
				} else if (sitUps==44) {
					sScore = 8.3;
				} else if (sitUps==43) {
					sScore = 8;
				} else if (sitUps==42) {
					sScore = 7.5;
				} else if (sitUps==41) {
					sScore = 7;
				} else if (sitUps==40) {
					sScore = 6.5;
				} else if (sitUps==39) {
					sScore = 6;
				} else {
					sScore = 0;
				}
            }
        }
        return sScore;
    }
    
    public double runScore(int runTime, int age, boolean sex){
        if(age <30){
            if(sex == true){
                if (runTime<=552) {
					rScore = 60;
				} else if (runTime>552 && runTime<=574) {
					rScore = 59.7;
				} else if (runTime>574 && runTime<=585) {
					rScore = 59.3;
				} else if (runTime>585 && runTime<=598) {
					rScore = 58.9;
				} else if (runTime>598 && runTime<=610) {
					rScore = 58.5;
				} else if (runTime>610 && runTime<=623) {
					rScore = 57.9;
				} else if (runTime>623 && runTime<=637) {
					rScore = 57.3;
				} else if (runTime>637 && runTime<=651) {
					rScore = 56.6;
				} else if (runTime>651 && runTime<=666) {
					rScore = 55.7;
				} else if (runTime>666 && runTime<=682) {
					rScore = 54.8;
				} else if (runTime>682 && runTime<=698) {
					rScore = 53.7;
				} else if (runTime>698 && runTime<=716) {
					rScore = 52.4;
				} else if (runTime>716 && runTime<=734) {
					rScore = 50.9;
				} else if (runTime>734 && runTime<=753) {
					rScore = 49.2;
				} else if (runTime>753 && runTime<=773) {
					rScore = 47.2;
				} else if (runTime>773 && runTime<=794) {
					rScore = 44.9;
				} else if (runTime>794 && runTime<=816) {
					rScore = 42.3;
				} else {
					rScore += 0;
				}
            }
            if(sex == false){
                if (runTime<=623) {
					rScore = 60;
				} else if (runTime>623 && runTime<=651) {
					rScore = 59.9;
				} else if (runTime>651 && runTime<=666) {
					rScore = 59.5;
				} else if (runTime>666 && runTime<=682) {
					rScore = 59.2;
				} else if (runTime>682 && runTime<=698) {
					rScore = 58.9;
				} else if (runTime>698 && runTime<=716) {
					rScore = 58.6;
				} else if (runTime>716 && runTime<=734) {
					rScore = 58.1;
				} else if (runTime>734 && runTime<=754) {
					rScore = 57.6;
				} else if (runTime>754 && runTime<=773) {
					rScore = 57;
				} else if (runTime>773 && runTime<=794) {
					rScore = 56.2;
				} else if (runTime>794 && runTime<=816) {
					rScore = 55.3;
				} else if (runTime>816 && runTime<=840) {
					rScore = 54.2;
				} else if (runTime>840 && runTime<=865) {
					rScore = 52.8;
				} else if (runTime>865 && runTime<=892) {
					rScore = 51.2;
				} else if (runTime>892 && runTime<=920) {
					rScore = 49.3;
				} else if (runTime>920 && runTime<=950) {
					rScore =46.9;
				} else if (runTime>950 && runTime<=982) {
					rScore = 44.1;
				} else {
					rScore = 0;
				}
            }
        }
        if(age >=30 && age <=39){
            if(sex == true){
                if (runTime<=574) {
					rScore = 60;
				} else if (runTime>574 && runTime<=598) {
					rScore = 59.3;
				} else if (runTime>598 && runTime<=610) {
					rScore = 58.6;
				} else if (runTime>610 && runTime<=623) {
					rScore = 57.9;
				} else if (runTime>623 && runTime<=637) {
					rScore = 57.3;
				} else if (runTime>637 && runTime<=651) {
					rScore = 56.6;
				} else if (runTime>651 && runTime<=666) {
					rScore = 55.7;
				} else if (runTime>666 && runTime<=682) {
					rScore = 54.8;
				} else if (runTime>682 && runTime<=698) {
					rScore = 53.7;
				} else if (runTime>698 && runTime<=716) {
					rScore = 52.4;
				} else if (runTime>716 && runTime<=734) {
					rScore =50.9;
				} else if (runTime>734 && runTime<=753) {
					rScore = 49.2;
				} else if (runTime>753 && runTime<=773) {
					rScore = 47.2;
				} else if (runTime>773 && runTime<=794) {
					rScore = 44.9;
				} else if (runTime>794 && runTime<=816) {
					rScore = 42.3;
				} else if (runTime>816 && runTime<=840) {
					rScore = 39.3;
				} else {
					rScore = 0;
				}
                
            }
            if(sex == false){
                if (runTime<=651) {
					rScore = 60;
				} else if (runTime>651 && runTime<=698) {
					rScore = 59.5;
				} else if (runTime>698 && runTime<=716) {
					rScore = 59;
				} else if (runTime>716 && runTime<=734) {
					rScore = 58.6;
				} else if (runTime>734 && runTime<=753) {
					rScore = 58.1;
				} else if (runTime>753 && runTime<=773) {
					rScore = 57.6;
				} else if (runTime>773 && runTime<=794) {
					rScore = 57;
				} else if (runTime>794 && runTime<=816) {
					rScore = 56.2;
				} else if (runTime>816 && runTime<=840) {
					rScore = 55.3;
				} else if (runTime>840 && runTime<=865) {
					rScore = 54.2;
				} else if (runTime>865 && runTime<=892) {
					rScore = 52.8;
				} else if (runTime>892 && runTime<=920) {
					rScore = 51.2;
				} else if (runTime>920 && runTime<=950) {
					rScore = 49.3;
				} else if (runTime>950 && runTime<=982) {
					rScore = 46.9;
				} else if (runTime>982 && runTime<=1017) {
					rScore = 40.8;
				}
                                else{
                                    rScore = 0;
                                }
                
            }
        }
        
        return rScore;
    }
    
    public double waistScore(double waist, int age, boolean sex){
            if(sex == true){
                //male
                if (waist<=35) {
				wScore = 20;
			} else if (waist==35.5) {
				wScore = 17.6;
			} else if (waist==36) {
				wScore = 17;
			} else if (waist==36.5) {
				wScore = 16.4;
			} else if (waist==37) {
				wScore = 15.8;
			} else if (waist==37.5) {
				wScore = 15.1;
			} else if (waist==38) {
				wScore = 14.4;
			} else if (waist==38.5) {
				wScore = 13.5;
			} else if (waist==39) {
				wScore = 12.6;
			} else {
				wScore = 0;
			}
            }
            if(sex == false){
               //female 
               if (waist<=31.5) {
				wScore = 20;
			} else if (waist==32) {
				wScore = 17.6;
			} else if (waist==32.5) {
				wScore = 17.1;
			} else if (waist==33) {
				wScore = 16.5;
			} else if (waist==33.5) {
				wScore = 15.9;
			} else if (waist==34) {
				wScore = 15.2;
			} else if (waist==34.5) {
				wScore = 14.5;
			} else if (waist==35) {
				wScore = 13.7;
			} else if (waist==35.5) {
				wScore = 12.8;
			} else {
				wScore = 0;
			}
            }
        
        return wScore;
    }
    
    public double totalScore(){
        totalScore = pScore+sScore+rScore+wScore;
        return totalScore;
    }
    
    public String value(double totalScore){
        if(totalScore >= 75.0 && totalScore <= 89.9){
         if(pScore >0 && sScore >0 && rScore >0 && rScore>0 && wScore>0){   
             passOrFail = true;
             scoreValue = "SAT";
        }
         else{
             passOrFail = false;
             scoreValue = "UNSAT";
         }
    }
        if(totalScore <75){
            passOrFail = false;
            scoreValue = "UNSAT";
        }
        if(totalScore >=90.0){
            if(pScore >0 && sScore >0 && rScore >0 && rScore>0 && wScore>0){   
             passOrFail = true;
             scoreValue = "EXCEL";
        }
            else{
                passOrFail = false;
                scoreValue = "UNSAT";
            }
        }
    return scoreValue;
}
 public double bmi(double height, double waist){
     //TODO: handle BMI
     return 25;
 }
    
    public String toString(){
        // returns line of score results
        String line = String.format("push up score: %.1f\nsit up score: %.1f\n"
                + "run score %.1f\n"
                + "waist score %.1f\n"
                + "total score %.1f", pScore, sScore,rScore,wScore,totalScore);
        return line;
    }
    
}
