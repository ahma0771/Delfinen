package com.company;

import java.io.*;
import java.util.*;

class Member{


   private String name;
   private int age;
   private String gender; 
   private int id;
  

   public void register(){
      Scanner sc = new Scanner(System.in);
      fillNameAndAge(sc);
      selectGender(sc);
   } 
   
   public void fillNameAndAge(Scanner sc){     
      System.out.println("indtast fulde navn");
      name = sc.nextLine();
      name = name.replaceAll("[^A-Za-z ]","");  
      System.out.println("Indtast fødselsår");
      age = sc.nextInt(); 
           
      while(age > 2021 || age < 1920){
         if(age > 2021){
         System.out.println("indstast fødselsår før 2021, prøv igen");
         } else if(age < 1920){
         System.out.println("prøv igen og indtast med 4 cifre");
         }
         age = sc.nextInt();
      }
      Random r = new Random();
      id = r.nextInt(89999)+10000;
   }
   
   public void selectGender(Scanner sc){
   
      System.out.println(" Vælg Køn:\n 1. Mand \n 2. Kvinde");
      int choice = sc.nextInt();            
      while(choice !=1 && choice !=2){
         System.out.println("Vælg venligst 1 eller 2");
         choice = sc.nextInt();
      }
      if(choice == 1){
         gender = "Mand";
      }else if(choice == 2){
         gender = "Kvinde";
      }     
   }
      

   public int getAge(){
      return this.age;
   }
   
   public String getName(){
      return this.name;
   }
   
   public String getGender(){
      return this.gender;
   }
   
   public int getId(){
      return this.id;
   }
}