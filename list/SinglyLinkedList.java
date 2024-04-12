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

    
    /* public void printlnList() {
        for (E element : this) {
            System.out.println(element);
        }
    } */
}
