public class BoundedPriorityQueue extends LinkedList {
    public BoundedPriorityQueue() {

        super(10);

    }
    public BoundedPriorityQueue(int maxSize) {
        super(maxSize);

    }
    public int size() {return super.size();}

    public Appointment get(int position) {return super.get(position);}

    public int indexOf(Appointment appointmentToBeFound) {return super.indexOf(appointmentToBeFound);}

    public boolean add(Appointment toBeAdded) {return super.add(toBeAdded);}

    public Appointment set(Appointment toBeAdded, int position) {return super.set(toBeAdded, position);}

    public boolean remove(Appointment toBeRemoved) {return super.remove(toBeRemoved);}

    public boolean isEmpty() {return super.isEmpty();}
    public Appointment poll() {return super.poll();}
    public Appointment peek() {return super.peek();}
    public Appointment remove() {return super.remove();}



}
