// -----------------------------------------------------
// COMP249 Assignment 3 due 15.04.2024
// Written by: Alisa Ignatina 40267100 and Jinghao Lai 40041316 
// -----------------------------------------------------

package list;



import java.util.ArrayList;

import vocab.Vocab;


/**
 * a doubly linked list to store the Vocab objects
 */
public class DoublyLinkedList {

    /**
     * represents a node of double linked list which has access to previous and next node
     */
    private class Node {

        Vocab vocab;
        Node next;
        Node prev;

        Node() {
            vocab = null;
            next = null;
            prev = null;
        }

        Node(Vocab vocab) {
            this.vocab = vocab;
            this.next = null;
            this.prev = null;
        }




    }

    private Node head;
    private Node tail;
    

    public DoublyLinkedList() {

        head = null;
        tail = null;

    }


    /**
     * calculates the number of words (nodes) in the current list
     * @return size
     */
    public int size(){
        Node currNode = head;
        int count = 0;
        while (currNode != null){
            count ++;
            currNode = currNode.next;
        }
        return count;
    }


    /**
     * compares if this list is equal to another doubly linked list
     */
    public boolean equals(Object otherObject){
        if (otherObject == null)
            return false;
        else if (this.getClass() != otherObject.getClass())
            return false;
        else {
            DoublyLinkedList oList = (DoublyLinkedList) otherObject;
            if (this.size() != oList.size())
                return false;
            
            Node position = head;
            Node oPosition = oList.head;
            while (position != null){
                if (!position.vocab.equals(oPosition.vocab))
                    return false;
                position = position.next;
                oPosition = oPosition.next;
            }
            
            return true;
            
        }
        
    }


    /**
     * adds new node to the beginning
     * @param vocab
     */
    public void addVocab(Vocab vocab) {

        Node newNode = new Node(vocab);
        if (head == null) {
            head = newNode;
            tail = newNode;

        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        }

    }


    /**
     * outputs all the content of all vocab objects 
     * @return two dimensional array list of topics and words in them
     */
    public ArrayList<ArrayList<String>> getAllList() {
        ArrayList<ArrayList<String>> vocabs = new ArrayList<>();
        Node current = head;
        while (current != null) {
            vocabs.add(current.vocab.toList());
            current = current.next;
        }
        return vocabs;

    }


    /**
     * returns all topic names in the list
     * @return list of strings
     */
    public ArrayList<String> outputTopics(){
        ArrayList<String> topics = new ArrayList<>();
        Node currNode = head;
        while (currNode != null) {
            topics.add(currNode.vocab.getTopic());
            currNode = currNode.next;
        }

        return topics;
    }


    /**
     * inserts a topic before the nodeNumber topic
     * @param nodeNum
     */
    public void insertNode(int nodeNum, Vocab vocab){
        Node newNode = new Node(vocab);

        if (nodeNum == 1){ // only 1 node
            newNode.next = head;
            head = newNode;
            return;
        }
        

        Node currNode = head;
        for (int i = 1; i < nodeNum - 1; i++, currNode = currNode.next); // currNode is previous node now
        newNode.next = currNode.next;
        newNode.prev = currNode;
        currNode.next.prev = newNode;
        currNode.next = newNode;

    }



    /**
     * inserts a topic after the nodeNumber topic
     * @param nodeNum
     */
    public void insertNodeAfter(int nodeNum, Vocab vocab){


        Node newNode = new Node(vocab);

        if(head==null){

            head = newNode;

            tail=newNode;

            return;
        }

        Node current=head;
        int count=1;

        while(current!=null&&count<nodeNum){

            current=current.next;
            count++;

        }

        if(current==null){
            System.out.println("Invalid position");

            return;
        }

        newNode.next=current.next;
        newNode.prev=current;
        if(current.next!=null){
            current.next.prev=newNode;
        }else{
            tail=newNode;
        }
        current.next=newNode;





    }


    /**
     * removes the vocab (node) from the list
     * @param nodeNum of node to remove
     */
    public void removeNode(int nodeNum){
        if (nodeNum == 1){
            if (this.size() == 1){
                head = null;
                return;
            }

            head = head.next;
            head.prev = null;
            return;
        }
        if (nodeNum == this.size()){
            tail = tail.prev;
            tail.next = null;
            return;
        }

        Node currNode = head;
        for (int i = 1; i < nodeNum - 1; i++, currNode = currNode.next);  // node before the node to remove found
        currNode.next = currNode.next.next; // next link
        currNode = currNode.next; //moving to the node after
        currNode.prev = currNode.prev.prev;
        
    }


    /**
     * finds which topics contain given word
     * @param word
     * @return name of topics which have the word
     */
    public ArrayList<String> findTopicsWithWord(String word){
        Node currNode = head;
        ArrayList<String> topics = new ArrayList<>();
        while (currNode != null) {
            if (currNode.vocab.getWords().findWord(word)) // if word found in topic
                topics.add(currNode.vocab.getTopic());
            currNode = currNode.next;
        }
        return topics;
    }


    /**
     * finds all words starting with given letter in all topics
     * @param letter the word starts with
     * @return list with all found words in all topics
     */
    public ArrayList<String> findWordsByLetter(char letter){
        Node currNode = head;
        ArrayList<String> words = new ArrayList<>();
        while (currNode != null) {
            words.addAll(currNode.vocab.getWords().wordsStartingWithLetter(letter));
            currNode = currNode.next;
        }
        return words;
    }




    //Show the topics
    public void printListTopics() {

        if(head==null){
            System.out.println("No topics avaliable");

        }

        

        int count=1;

        for(Node current = head;current!=null;current=current.next){


            System.out.println(count+" "+current.vocab.getTopic());

            
            count++;




        }
       
      

        
    }


    
    
    /**Find the vocab by index
     * @param index
     * @return Vocab
     */
    public Vocab getVocab(int index) {
        if (index <= 0 || index > this.size()) {
            System.out.println("Invalid topic number.");
            return null; // Return null if the index is out of bounds
        }
    
        Node current = head;
        int count = 1;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
    
        if (current != null) {
            return current.vocab;
        } else {
            return null;
        }
    }
    
    
}