package com.company;

import java.io.*;
import java.util.*;

class PassiveMember extends Member {
   
   private double subscription = 500; 
   
   public double getSubscription(){
      return subscription;
   }  
   

   public void overwrite(){
      try{   
         PrintStream output = new PrintStream(new FileOutputStream("Passive medlemmer.txt", true));    
         output.printf("%-30s %-10d %-10s\n",super.getName(),super.getAge(),super.getGender());  
         PrintStream output1 = new PrintStream(new FileOutputStream("Alle medlemmere.txt", true));    
         output1.printf("%-7d Nej     %-30s %-5.2f\n",super.getId(),super.getName(),subscription); 
      }catch(Exception e){
         System.out.println("Der skete en fejl " + e);
      }
   }
   
   
}
