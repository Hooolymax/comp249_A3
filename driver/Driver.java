package driver;

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import java.util.Scanner;

import java.util.LinkedList;
import java.util.ArrayList;
import list.DoublyLinkedList;
import list.SinglyLinkedList;

public class Driver {


    static Scanner sc=new Scanner(System.in);

    
    


    public static void main (String []args){



        DoublyLinkedList vocabList=new DoublyLinkedList();

        ArrayList<String> vocab=new ArrayList<>();

       


        //read the vocab topics in the input file
        readVocab(vocab);

        for (String topic : vocab) {
            System.out.println(topic);
        }


        


        

        int choice=1;

     do{

        System.out.println("-----------------------------------");
        System.out.println("Vocabulary Control Center");
        System.out.println("-----------------------------------");

        System.out.println("1 browser a topic");
        System.out.println("2 insert a new topic before another one");
        System.out.println("3 inset a new topic after another one");
        System.out.println("4 remove a topic");
        System.out.println("5 modify a topic");
        System.out.println("6 search topics for a word");
        System.out.println("7 load from a file");
        System.out.println("8 show all words starting with a given letter");
        System.out.println("9 save to file");
        System.out.println("0 exit");


        System.out.println("-----------------------------------");
        System.out.println("Enter Your Choice:");
      


        try{
        choice=sc.nextInt();
        }catch (InputMismatchException e){
        System.out.println("Please eneter a valid number.");
        sc.next();
        continue;
        
      }
    


    
    switch (choice) {
        case 1:
            
            break;
    
        case 2:

            break;

        case 3: 
        
            break;

        case 4:

            break;

        case 6:

        break;

        case 7:

        break;

        case 8:

        break;


        case 9:

        break;


        case 0:
        System.out.println("Exiting the program, thank you");

        break;

        default:

        System.out.println("Invalid Input");

    }



}



    while (choice!=0);

    //       test  //

       








        
    }





    
    
    public static void readVocab(ArrayList list){

       
        try{
            Scanner reader=new Scanner(new FileInputStream("input/Input files.txt"));

            

            while(reader.hasNextLine()){


                String line = reader.nextLine().trim();

                if (line.startsWith("#")){

                    list.add(line.substring(1).trim());


                }

            }
            reader.close(); 

          }catch(IOException e){
            e.printStackTrace();
          }

        

           

    }

   

    
}
