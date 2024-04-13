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
import java.util.Collections;

import list.DoublyLinkedList;
import list.SinglyLinkedList;
import vocab.Vocab;

public class Driver {

    static Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);
    static Scanner sc3=new Scanner(System.in);

    static DoublyLinkedList vocabList = new DoublyLinkedList();

    public static void main(String[] args) {

        ArrayList<String> vocab = new ArrayList<>();


        int choice = 1;

        do {

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

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please eneter a valid number.");
                sc.next();
                continue;

            }
// handle exception of invalid input
            switch (choice) {

                // browse a topic
                case 1:{


                    int topicChoice=0;
                    

                    do{

                        System.out.println("------------------------------------");
                        System.out.println("            Pick a topic            ");
                        System.out.println("------------------------------------");
                        System.out.println();

                        vocabList.printListTopics();



                        System.out.println("0 Exit");
                        System.out.println("------------------------------------");

                        

                        System.out.println("Enter your choice: ");

                        

                        try{

                            topicChoice=sc3.nextInt();


                          
                            if(topicChoice==0){
                                break;
                            }

                            Vocab selectedVocab = vocabList.getVocab(topicChoice);
                            if (selectedVocab != null) {
                                selectedVocab.printVocab(); // Display the words in the chosen topic

                                System.out.println("");
                            } else {
                                System.out.println("Invalid choice, please try again.");
                            }

                            
                              

                          

                           selectedVocab.getWords();





                            

                            
                            
                            

                        }catch(InputMismatchException e){
                            System.out.println("Invalid input");

                        }
                    

                    }while(topicChoice!=0);


















                }

                

                    break;

                // insert a new topic before another one
                case 2:
                    System.out.println("Pick a topic");
                    displayTopics();
                    System.out.print("Enter your choice: ");
                    int topicNumToAdd = sc2.nextInt();
                    if (topicNumToAdd == 0){
                        continue;
                    }
                    System.out.println("Enter topic name: ");
                    String topicName = sc2.next();
                    System.out.println("Enter a word - to quit press Enter: ");
                    SinglyLinkedList wordsToEnter = new SinglyLinkedList();
                    while (true){
                        sc2.nextLine();  // Clear the newline character left in the buffer
                        String word = sc2.nextLine();
                        if (word.isEmpty())
                            break;
                        wordsToEnter.addWord(word);
                    }

                    insertTopic(topicNumToAdd, topicName, wordsToEnter);
                break;

                // inset a new topic after another one
                case 3:{

                    System.out.println("Pick a topic");
                    displayTopics();
                    System.out.print("Enter your choice: ");
                    int topicNumToAddAfter = sc2.nextInt();

                    System.out.println("Enter topic name: ");
                    String topicNameToAddAfter = sc2.next();
                    System.out.println("Enter a word - to quit press Enter: ");

                    SinglyLinkedList wordsToEnterAfter = new SinglyLinkedList();
                    while (true){
                        sc2.nextLine();  // Clear the newline character left in the buffer
                        String word;
                        while (!(word = sc2.nextLine()).isEmpty()){
                            wordsToEnterAfter.addWord(word);
                        }
                            break;
                        
                            
                            
                                
                       
                    }

                    insertTopicAfter(topicNumToAddAfter, topicNameToAddAfter, wordsToEnterAfter);


    
                }

               





                    break;

                // remove a topic
                case 4:
                    System.out.println("Pick a topic");
                    displayTopics();
                    System.out.print("Enter your choice: ");
                    int topicNumToDel = sc2.nextInt();
                    if (topicNumToDel == 0){
                        continue;
                    }
                    vocabList.removeNode(topicNumToDel);
                break;

                // modify a topic
                case 5:

                    break;

                // search topics for a word
                case 6:
                    System.out.println("Emter the word you want to find: ");
                    ArrayList<String> topicsWithWord = vocabList.findTopicsWithWord(sc2.next());
                    if (topicsWithWord.size() < 1)
                        System.out.println("the word was not found in the current database");
                    else
                        System.out.println(topicsWithWord);
                break;

                // load from a file
                case 7:

                

                    System.out.println("Please enter the full file name");

                    String fileToLoad = null;
                    fileToLoad = sc2.nextLine();

                    loadVocab("input/" + fileToLoad);
                    

                
                break;

                // show all words starting with a given letter
                case 8:
                    System.out.println("Enter the starting letter: ");
                    ArrayList<String> words = vocabList.findWordsByLetter(sc2.next().charAt(0));
                    Collections.sort(words);
// migh need to do sort manually
                    if (words.size() < 1)
                        System.out.println("no words starting with this letter");
                    else
                        System.out.println(words);
                break;

                // save to file
                case 9:
                    try(PrintWriter fileWriter = new PrintWriter(new FileOutputStream("output/output_file.txt"))){
// format output
                        fileWriter.println(vocabList.getAllList());
                        System.out.println("File successfully saved");
                    } catch (FileNotFoundException e){
                        System.out.println("error during file creation");
                    }


                break;

                case 0:
                    System.out.println("Exiting the program, thank you");
                    System.exit(0);
                break;

                default:

                    System.out.println("Invalid Input");

            }

        }

        while (choice != 0);

        // test //

    }

    // test only

    public static void readVocab(ArrayList list) {

        try {
            Scanner reader1 = new Scanner(new FileInputStream("input/input_file.txt"));

            while (reader1.hasNextLine()) {

                String line = reader1.nextLine().trim();

                if (line.startsWith("#")) {

                    list.add(line.substring(1).trim());

                }

            }
            reader1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Loads vocabulary topics and their associated words from a specified file.
     * adds them to a doubly linked list.
     * 
     * @param filename the path to the file containing the vocabulary data.
     * @return a {@link DoublyLinkedList} containing {@link Vocab} objects loaded
     *         from the file.
     *         Each {@link Vocab} object consists of a topic and a
     *         {@link SinglyLinkedList} of words.
     * @throws IOException if an input or output exception occurred
     */

    

        public static DoublyLinkedList loadVocab(String filename) {

        

            try (Scanner reader2 = new Scanner(new FileInputStream(filename))) {
                while (reader2.hasNextLine()) {

                    String line = reader2.nextLine().trim();

                    if (line.startsWith("#")) {

                        String topic = line.substring(1).trim();
                        SinglyLinkedList words = new SinglyLinkedList();

                        while (reader2.hasNextLine()) {
                            String word = reader2.nextLine().trim();
                            if (word.startsWith("#") || word.isEmpty()) {

                                reader2.reset();
                                break;
                            }

                            words.addWord(word);
                        }

                        vocabList.add(new Vocab(topic, words));
                       

                    }
                }
                System.out.println("Done loading");
            }

        

        catch (IOException e) {
            System.out.println("The file can not be found");
        }

        
        return vocabList;
        

    }












    public static void displayTopics(){
        ArrayList<String> topics = vocabList.outputTopics();
        int n = 1;
        for (String topic : topics){
            System.out.println(n++ + " " + topic);
        }
        System.out.println("0 Exit");
    }

    /**
     * creates vocab from given parametres and adds it to vocabList before the topicNum element
     * @param topicNum
     * @param topicName
     * @param words
     */
    public static void insertTopic(int topicNum, String topicName, SinglyLinkedList words){
        Vocab vocab = new Vocab(topicName, words);
        vocabList.insertNode(topicNum, vocab);
    }


    public static void insertTopicAfter(int topicNum, String topicName, SinglyLinkedList words){
        Vocab vocab = new Vocab(topicName, words);
        vocabList.insertNodeAfter(topicNum, vocab);
    }







}
