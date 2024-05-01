import java.time.LocalDate;
import java.util.LinkedList;

public class Patient {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate joinedThePractice;
    private LinkedList<Appointment> appointments;

    public Patient() {

    }


}