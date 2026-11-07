package camelfestival;

//the contianer that holds all the camels
public class CamelLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private static class Node {

        Camel camel;    //  camel will be inside this box
        Node next;  //  points to next box

        Node(Camel c) {
            camel = c;
            next = null;
        }
    }

    public void addLast(Camel c) {

        Node newNode = new Node(c);    // build a new node 

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;       //     hook it behind the current last node
            tail = newNode;            //     the new node is now the last
        }
        size++;
    }

    public int size() {
        return size; // we already were counting in the addLast
    }

    public Camel[] toArray() {
        Camel[] arr = new Camel[size];   // an array with exactly 'size' spaces
        Node current = head;
        int i = 0;                        // the next free space in the array
        while (current != null) {
            arr[i] = current.camel;       // puts the node camel in the array
            i++;
            current = current.next;
        }
        return arr;
    }

    public Camel search(String camelId) {
        Node current = head;
        while (current != null) {
            if (current.camel.getCamelId().equals(camelId)) {   // same ID?
                return current.camel;                           // when found stop here
            }
            current = current.next;
        }
        return null;
    }

    public boolean delete(String camelId) {
        if (head == null) {                          //if empty then nothing to delete
            return false;
        }

        if (head.camel.getCamelId().equals(camelId)) {
            head = head.next;                        // the list now starts at node 2
            if (head == null) {                      // it was the only node
                tail = null;
            }
            size--;
            return true;
        }

        Node previous = head;
        Node current = head.next;
        while (current != null) {
            if (current.camel.getCamelId().equals(camelId)) {
                previous.next = current.next;        // hook past the removed node
                if (current == tail) {               // we removed the last node
                    tail = previous;                 // so tail moves back one
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }
}
