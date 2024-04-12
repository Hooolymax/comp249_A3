package list;

import java.util.LinkedList;

import vocab.Vocab;

public class DoublyLinkedList<T>{



    private class Node{

        
        Vocab vocab;
        Node next;
        Node prev;

        Node(){
            vocab=null;
            next=null;
            prev=null;
        }

        Node(Vocab vocab){

            this.vocab=vocab;
            this.next=null;
            this.prev=null;
        }

    }
    
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList(){

        size=0;
        head=null;
        tail=null;

    }

    
    /** 
     * @param vocab
     */
    public void add(Vocab vocab){

        Node newNode=new Node(vocab);
        if(head==null){
            head=newNode;
            tail=newNode;

        }else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;

        }

        size++;


    }




    public void printList(){

   
        Node current=head;
        while(current!=null){
            current.vocab.printVocab();
            current=current.next;
        }

    }


    public int size() {
        return size;
    }

    
}