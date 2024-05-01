public class LinkedList {

    private Node head;
    private Node tail;

    private int numberOfElements;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.numberOfElements = 0;
    }

    public int size() {
        return this.numberOfElements;
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
