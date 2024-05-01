public class LinkedList {

    private Node head;
    private Node tail;




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
