package vocab;
import java.util.LinkedList;

import list.SinglyLinkedList;

public class Vocab {
    String topic;
    SinglyLinkedList<String> words;


   
    

    public Vocab(String topic, SinglyLinkedList<String> words){

        this.topic=topic;
        this.words=words;


    }

    public String getTopic() {
        return topic;
    }

    public SinglyLinkedList<String> getSWords() {
        return words;
    }

    public void setTopicName(String topic) {
        this.topic = topic;
    }

    public void setSlist(SinglyLinkedList<String> words) {
        this.words = words;
    }



    public void printVocab(){

        System.out.println("Topic: "+ topic );

        for(String word: words){
            System.out.println(word);
            
        }
    }

    

    
}
