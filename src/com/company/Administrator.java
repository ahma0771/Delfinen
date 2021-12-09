package com.company;

import java.io.*;
import java.util.*;

class Administrator{


   public void showMainMenu(Scanner sc){
   
      System.out.println("   Hovedmenu, Definen   ");
      System.out.println("       Vælg Bruger     ");
      System.out.println(" 1. Formand             ");
      System.out.println(" 2. Træner              ");
      System.out.println(" 3. Kasserer            ");
      
      int menuChoice = sc.nextInt();
      if(menuChoice == 1){
         showAdminMenu(sc);
      }else if(menuChoice == 2){
         System.out.println("Den valgte menu er under ombygning\nDu vil blive sendt tilbage til hovedmenuen\n");
         showMainMenu(sc);
      } else if(menuChoice == 3){
         showCashierMenu(sc);
      }
   }
  

   public void showAdminMenu(Scanner sc){
     
      System.out.println("      Formandmenu\n     ");
      System.out.println(" 1. Tilmeld medlem      ");
      System.out.println(" 2. Nej, gå tilbage     ");
     
      int input = typeOneOrTwo(sc);         
      if(input == 1){
         createUser(sc); 
      }else if(input == 2){
         showMainMenu(sc);
      }
   }
   

   public void createUser(Scanner sc){
    
      System.out.println("  Vælg Aktivitetsform   ");
      System.out.println(" 1. Passiv             ");
      System.out.println(" 2. Aktiv              ");
      int input = typeOneOrTwo(sc); 
           
      if(input == 1){
         PassiveMember passive = new PassiveMember();
         passive.register();
         passive.overwrite();
      } 
      
      if(input == 2){
         System.out.println(" 1. Konkurrencesvømmer\n 2. Motionist");
         int input2 = typeOneOrTwo(sc);
         
         if(input2 == 1){
            CompetitionSwimmer cSwimmer = new CompetitionSwimmer();
            cSwimmer.register();
            cSwimmer.selectDisciplin();
            cSwimmer.overwrite();
         }
         if(input2 == 2){
            Swimmer swimmer = new Swimmer();
            swimmer.register(); 
            swimmer.subscriptionCalculator();      
            swimmer.overwrite();
         }
      }
   }
    

   public void showCashierMenu(Scanner sc){
   
      FileReaderIO f = new FileReaderIO();
      System.out.println("     Kasserer menu      ");
      System.out.println(" 1. Betaling af kontingent");
      System.out.println(" 2. Vis medlemmer i restance"); 
      System.out.println(" 3. Gå tilbage til hovedmenu");
      int input = typeOneOrTwo(sc);         
      if(input == 1){
           f.paySubscription(sc);
      }else if(input == 2){
           f.showArrears();
      }
   
   }
   

   public int typeOneOrTwo(Scanner sc){
      int choice = sc.nextInt();
      while(choice != 1 && choice !=2 && choice != 3){
         System.out.println(" Vælg venligst 1, 2 eller 3 ");
         choice = sc.nextInt();
      }if(choice == 3){
         showMainMenu(sc);
      }
      return choice; 
   }
}