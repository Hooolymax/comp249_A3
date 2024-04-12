package vocab;


import list.SinglyLinkedList;


public class Vocab {

    String topic;
    SinglyLinkedList words;

    public Vocab(){
        this.topic = "n/a";
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

    public void printVocab() {

        System.out.println("Topic: " + topic);

        System.out.println(words.outputList());
    }

}
