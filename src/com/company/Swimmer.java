package com.company;

import java.io.*;
import java.util.*;


class Swimmer extends Member {


   private double subscription;
   

   public void subscriptionCalculator(){    
      if(super.getAge() < 1959){
        subscription = 1200; //25% af 1600
      } else if (super.getAge() < 2001){
         subscription = 1600;
      } else{
         subscription = 1000; //junior
      }           
   }
   

   public void overwrite(){
      try{
         PrintStream output = new PrintStream(new FileOutputStream("Aktive Motionister.txt",true));    
         output.printf("%-30s %-10d %-10s %-10.2f\n",super.getName(),super.getAge(),super.getGender(),this.subscription);
         PrintStream output1 = new PrintStream(new FileOutputStream("Alle medlemmere.txt", true));    
         output1.printf("%-7d Nej     %-30s %-5.2f\n",super.getId(),super.getName(),this.subscription);
      }catch(Exception e){
         System.out.println("Der skete en fejl " + e);
      }
   }
   

   public double getSubscription(){
      subscriptionCalculator();
      return this.subscription;    
   }  
}