package com.company;

import java.io.*;
import java.util.*;

class FileReaderIO{
   String id = "";

   public void paySubscription(Scanner sc){  
   
      System.out.println("Indtast medlemsID");
      id = sc.next();
      ArrayList<String> list = new ArrayList<String>();     
      try{
         Scanner input = new Scanner(new File("Alle medlemmere.txt"));
         while (input.hasNextLine()) {
            String line = input.nextLine();            
            if(line.contains(id)){
               line = line.replace("Nej ","Ja  ");  
            }    
            list.add(line);
         }    
            PrintStream output = new PrintStream(new File("Alle medlemmere.txt"));
            for(int i = 0; i < list.size(); i++){
               String line = list.get(i);
               output.println(line);
            }  
      }catch(Exception e){
         System.out.println("Der skete en fejl " + e);
      }  
   }


   public void showArrears(){
   
      ArrayList<String> list = new ArrayList<String>();
      try{
         Scanner input = new Scanner(new File("Alle medlemmere.txt")); 
         PrintStream output = new PrintStream(new File("Medlemmer i restance.txt"));
         while (input.hasNextLine()) {
            String line = input.nextLine();
            if(line.contains("Nej ")){
               list.add(line);
            }
         }
         output.println("ID      betalt     Navn                Kontigent(dkk)");
         System.out.println("ID      betalt     Navn                Kontigent(dkk)");
         for(int i = 0; i < list.size(); i++){
            String line = list.get(i);
            output.println(line);
            System.out.println(line);
         }
      }catch(Exception e){
         System.out.println("Der skete en fejl " + e);
      }
   }
}