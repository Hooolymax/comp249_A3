// -----------------------------------------------------
// COMP249 Assignment 3 due 15.04.2024
// Written by: Alisa Ignatina 40267100 and Jinghao Lai 40041316 
// -----------------------------------------------------

package vocab;


import java.util.ArrayList;

import list.SinglyLinkedList;


public class Vocab {

    String topic;
    SinglyLinkedList words;

    public Vocab(){
        this.topic = "n/a";
        this.words = new SinglyLinkedList();
    }

    public Vocab(String topic){
        this.topic = topic;
        this.words = new SinglyLinkedList();
    }

    public Vocab(String topic, SinglyLinkedList words) {

        this.topic = topic;
        this.words = words;

    }

    
    public String getTopic() {
        return topic;
    }

    public SinglyLinkedList getWords() {
        return words;
    }

    public void setTopicName(String topic) {
        this.topic = topic;
    }

    
    
    /* public void setWords(SinglyLinkedList words) {
        this.words = words;
    } */

 
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vocab other = (Vocab) obj;
        if (topic == null) {
            if (other.topic != null)
                return false;
        } else if (!topic.equals(other.topic))
            return false;
        if (words == null) {
            if (other.words != null)
                return false;
        } else if (!words.equals(other.words))
            return false;
        return true;
    }

    public void printVocab() {

        System.out.println("Topic: " + topic);
        ArrayList<String> wordlist = words.outputWordsList();
        for (int i = 0; i < wordlist.size(); i++) {
            System.out.print((i + 1) + ": " + wordlist.get(i) + "     ");
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
        if (wordlist.size() % 4 != 0) { // Ensure there's a newline if not ended on a multiple of 4
            System.out.println();
        }
    }

    

    
    public ArrayList<String> toList() {
        ArrayList<String> vocab= new ArrayList<>();
        vocab.add(topic);
        vocab.addAll(words.outputWordsList());
        return vocab;
    }

    public void printTopics(){
        System.out.println(" " + topic);
    }


}
