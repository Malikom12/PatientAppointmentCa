import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private Node tail;

    private int numberOfElements;

    private final int maxSize;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.numberOfElements = 0;
        this.maxSize = 10;
    }
    public LinkedList(int maxSize) {
        this.head = null;
        this.tail = null;
        this.numberOfElements = 0;
        this.maxSize = maxSize;
    }


    public int size() {
        return this.numberOfElements;
    }

    public boolean isFull() {
        return numberOfElements == maxSize;
    }
    public Appointment get(int position) {
        if (position < 0 || position >= this.numberOfElements) {
            return null;
        }

        Node currentNode = this.head;
        for (int i = 0; i < position; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getData();
    }


    public int indexOf(Appointment appointmentToBeFound) {
        Node current = this.head;
        int index = 0;

        while (current!= null) {
            if (current.getData().equals(appointmentToBeFound)) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1;
    }


    public boolean add(Appointment toBeAdded) {
        Node newNode = new Node(toBeAdded);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.getNext()!= null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }

        this.numberOfElements++;
        return true;
    }

    public Appointment set(Appointment toBeAdded, int position) {
        if (position < 0 || position >= this.numberOfElements) {
            throw new IllegalArgumentException("Invalid position");
        }

        Node current = this.head;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }

        Appointment temp = current.getData();
        current.setData(toBeAdded);
        return temp;
    }


    public boolean remove(Appointment toBeRemoved) {
        if (toBeRemoved == null) {
            return false;
        }

        Node current = this.head;
        Node previous = null;

        while (current!= null) {
            if (current.getData().equals(toBeRemoved)) {
                if (previous == null) {
                    this.head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                this.numberOfElements--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }

        return false;
    }


    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public Appointment poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        Appointment firstAppointment = head.getData();
        head = head.getNext();
        numberOfElements--;
        return firstAppointment;
    }

    public Appointment peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        return head.getData();
    }


    public Appointment remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        Appointment firstAppointment = head.getData();
        head = head.getNext();
        numberOfElements--;
        return firstAppointment;
    }




































    protected static class Node {
        // Fields
        private Appointment data;
        private Node next;

        public Node(Appointment data) {
            this.data = data;
            this.next = null;
        }

        //Setters and Getters

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        public void setData(Appointment data) {
            this.data = data;
        }

        public Appointment getData() {
            return this.data;
        }
    }

}
