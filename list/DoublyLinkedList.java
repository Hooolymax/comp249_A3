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

    public void printList() {

        Node current = head;
        while (current != null) {
            current.vocab.printVocab();
            current = current.next;
        }

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
     * @param nodeNumber
     */
    public void insertNode(int nodeNumber, Vocab vocab){

        Node currNode = head;
        Node newNode = new Node(vocab);
        for (int i = 1; i < nodeNumber; i++, currNode = currNode.next); // currNode is previous node now
        newNode.next = currNode.next;
        newNode.prev = currNode;
        currNode.next.prev = newNode;
        currNode.next = newNode;

    }


    public void removeNode(int nodeNum){
        Node currNode = head;
        for (int i = 1; i < nodeNum; i++, currNode = currNode.next);  // node before the node to remove found
        currNode.next = currNode.next.next; // next link
        currNode = currNode.next; //moving to the node after
        currNode.prev = currNode.prev.prev;
        
    }


    /* public int size() {
        return size;
    }
 */
}