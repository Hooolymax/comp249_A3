package list;



import java.util.ArrayList;

import vocab.Vocab;



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
    /* private int size; */

    public DoublyLinkedList() {

        /* size = 0; */
        head = null;
        tail = null;

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
     * @param vocab
     */
    public void add(Vocab vocab) {

        Node newNode = new Node(vocab);
        if (head == null) {
            head = newNode;
            tail = newNode;

        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        }

        /* size++; */

    }

    public ArrayList<String> getAllList() {
        return null;

    }

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

    public ArrayList<String> findWordsByLetter(char letter){
        Node currNode = head;
        ArrayList<String> words = new ArrayList<>();
        while (currNode != null) {
            words.addAll(currNode.vocab.getWords().wordsStartingWithLetter(letter));
            currNode = currNode.next;
        }
        return words;
    }

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
    
    /* public int size() {
        return size;
    }
 */
}