package vocab;


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

        System.out.println(words.outputList());
    }

}
