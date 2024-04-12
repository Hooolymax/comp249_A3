package list;



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

    /* public int size() {
        return size;
    }
 */
}