package com.company;

import java.io.*;
import java.util.*;

class CompetitionSwimmer extends Swimmer {

   private String disciplin = "";
   

   public void selectDisciplin(){     
     Administrator a = new Administrator();
     Scanner sc = new Scanner(System.in);  
                      
     System.out.println("Vælg disciplin");
     System.out.println("Brystsvømning \n1. Ja\n2. Nej");
     int choise = a.typeOneOrTwo(sc);
     if(choise==1){
      disciplin += "Brystsvømning ";
     }
     System.out.println("Butterfly \n1. Ja\n2. Nej");
     int choise2 = a.typeOneOrTwo(sc);
     if(choise2 ==1){
      disciplin += "Butterfly ";
     }
     System.out.println("Crawl \n1. Ja\n2. Nej");
     int choise3 = a.typeOneOrTwo(sc);
     if(choise3 == 1){
      disciplin += "Crawl ";
     }                  
   }
   
   public void overwrite(){
      
      try{
         PrintStream output = new PrintStream(new FileOutputStream("Aktive konkurrencesvømmere.txt",true));
         output.printf("%-30s %-10d %-10s %-10.2f %-10s\n",super.getName(),super.getAge(),super.getGender(),super.getSubscription(),disciplin);
         PrintStream output1 = new PrintStream(new FileOutputStream("Alle medlemmere.txt", true));    
         output1.printf("%-7d Nej     %-30s %-5.2f\n",super.getId(),super.getName(),super.getSubscription());
      }catch(Exception e){
         System.out.println("Der skete en fejl " + e);
      }
   }
    
    
     
}