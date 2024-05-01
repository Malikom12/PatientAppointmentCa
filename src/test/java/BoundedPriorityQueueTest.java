import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class BoundedPriorityQueueTest {

    @Test
    void testBoundedPriorityQueue() {
        BoundedPriorityQueue<Appointment> priorityQueue = new BoundedPriorityQueue<>(10);
        priorityQueue.add(new Appointment("John", "Doe", LocalDate.of(1990, 1, 1), "Cold", LocalDate.of(2022, 1, 1), 1, "Dr. Smith"));
        priorityQueue.add(new Appointment("Jane", "Doe", LocalDate.of(1995, 2, 2), "Flu", LocalDate.of(2022, 1, 2), 2, "Dr. Johnson"));
        priorityQueue.add(new Appointment("Jim", "Doe", LocalDate.of(1992, 3, 3), "Fever", LocalDate.of(2022, 1, 3), 3, "Dr. Brown"));

        assertEquals(priorityQueue.get(0).getFirstName(), "Jim");
        assertEquals(priorityQueue.get(1).getFirstName(), "John");
        assertEquals(priorityQueue.get(2).getFirstName(), "Jane");

        priorityQueue.remove(new Appointment("Jim", "Doe", LocalDate.of(1992, 3, 3), "Fever", LocalDate.of(2022, 1, 3), 3, "Dr. Brown"));
        priorityQueue.add(new Appointment("Jill", "Doe", LocalDate.of(1993, 4, 4), "Sore Throat", LocalDate.of(2022, 1, 4), 4, "Dr. Davis"));

        assertEquals(priorityQueue.get(0).getFirstName(), "John");
        assertEquals(priorityQueue.get(1).getFirstName(), "Jane");
        assertEquals(priorityQueue.get(2).getFirstName(), "Jill");

        priorityQueue.poll();
        priorityQueue.poll();
        priorityQueue.poll();

        assertEquals(priorityQueue.get(0).getFirstName(), "Jill");
        assertTrue(priorityQueue.isEmpty());
    }
}