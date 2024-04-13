package list;

import java.util.ArrayList;
import java.util.LinkedList;

public class SinglyLinkedList {

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

    /* private static class SNode<E> {
    } */

    public SinglyLinkedList() {
        head = null;
    }

    public int size(){
        Node currNode = head;
        int count = 0;
        while (currNode != null){
            count ++;
            currNode = currNode.next;
        }
        return count;
    }

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
    public ArrayList<String> outputList(){
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

    public boolean findWord(String word){
        Node currNode = head;
        while (currNode != null) {
            if (currNode.word.equals(word))
                return true;
            currNode = currNode.next;
        }
        return false;
    }

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

    
    /* public void printlnList() {
        for (E element : this) {
            System.out.println(element);
        }
    } */
}
