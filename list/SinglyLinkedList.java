// -----------------------------------------------------
// COMP249 Assignment 3 due 15.04.2024
// Written by: Alisa Ignatina 40267100 and Jinghao Lai 40041316 
// -----------------------------------------------------

package list;

import java.util.ArrayList;


/**
 * a singly-liked list to store the words within the Vocab objects
 */
public class SinglyLinkedList {

    /**
     * inner class representing one node of the list
     */
    private class Node{
        String word;
        Node next;

        Node(){
            word = null;
            next = null;
        }

        Node(String word){
            this.word = word;
            next = null;
        }
    }

    private Node head;

    public SinglyLinkedList() {
        head = null;
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
     * compares if this list is equal to another singly linked list
     */
    public boolean equals(Object otherObject){
        if (otherObject == null)
            return false;
        else if (this.getClass() != otherObject.getClass())
            return false;
        else {
            SinglyLinkedList oList = (SinglyLinkedList) otherObject;
            if (this.size() != oList.size())
                return false;
            
            Node position = head;
            Node oPosition = oList.head;
            while (position != null){
                if (!position.word.equals(oPosition.word))
                    return false;
                position = position.next;
                oPosition = oPosition.next;
            }
            
            return true;
            
        }
        
    }

    /**
     * extracts all words from linkedList into ArrayList
     * @return ArrayList of words
     */
    public ArrayList<String> outputWordsList(){
        ArrayList<String> words = new ArrayList<>();
        Node currNode = head;
        while (currNode != null) {
            words.add(currNode.word);
            currNode = currNode.next;
        }

        return words;
    }

    /**
     * adds word to the start of the list
     * @param word
     */
    public void addWord(String word){
        Node newNode = new Node(word);
        newNode.next = head;
        head = newNode;
        
    }

    /**
     * attempts to find the word in the words of this topic
     * @param word to find
     * @return true if the word was found
     */
    public boolean findWord(String word){
        Node currNode = head;
        while (currNode != null) {
            if (currNode.word.equals(word))
                return true;
            currNode = currNode.next;
        }
        return false;
    }


    /**
     * finds all words which start with given letter
     * @param given letter
     * @return words starting with this letter
     */
    public ArrayList<String> wordsStartingWithLetter(char letter){
        Node currNode = head;
        ArrayList<String> words = new ArrayList<>();
        while (currNode != null) {
            if (currNode.word.charAt(0) == (letter))
                words.add(currNode.word);
            currNode = currNode.next;
        }
        return words;
    }


    /**
     * removes the word from the list
     * @param word to remove
     */
    public void removeWord(String word) {
        if(head==null){
            System.out.println("The list is empty, no words to remove");
            return;
        }

        if(head.word.equals(word)){
            head=head.next;
            System.out.println("Word removed successfully.");
            return;
           
        }

        Node current=head;
        while(current.next!=null){
            if (current.next.word.equals(word)){

                current.next=current.next.next;
                System.out.println("Word removed successfully.");
                return;
            }
            current=current.next;
        }

        System.out.println("Sorry, there is no word:"+ word);
       
       
    }


    /**
     * replaces the word in the list with the new one
     * @param oldWord
     * @param newWord
     */
    public void replaceWord(String oldWord, String newWord){
        Node current=head;
        while(current!=null){
            if(current.word.equals(oldWord)){
                current.word=newWord;
                return;
            }

            current=current.next;
        }

    }
    
    



}
