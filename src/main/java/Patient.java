import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;

public class Patient {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate joinedThePractice;
    private LinkedList<Appointment> appointments;

    public Patient() {

    }

    public Patient(String firstName, String lastName, LocalDate dateOfBirth, LocalDate joinedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.joinedThePractice = joinedThePractice;
        this.appointments = new LinkedList<>();
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if (firstName != null) {
            this.firstName = firstName;
        }
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if (lastName != null){
            this.lastName = lastName;
        }
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.isEqual(LocalDate.now()) || dateOfBirth.isBefore(LocalDate.now())){
            this.dateOfBirth = dateOfBirth;
        }
    }
    public LocalDate getJoinedThePractice() {
        return joinedThePractice;
    }
    public void setJoinedThePractice(LocalDate joinedThePractice) {
        this.joinedThePractice = joinedThePractice;
    }
    public LinkedList<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(LinkedList<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public boolean equals(Object otherPatient) {
        //Checks if the object is an instance of the class
        if (this == otherPatient) return true;
        //Checks for null or if they are not the same class
        if (otherPatient == null || getClass() != otherPatient.getClass()) return false;

        Patient patient = (Patient) otherPatient;
        //Checks if the first name, last name, and date of birth are the same
        return Objects.equals(firstName, patient.firstName) &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(dateOfBirth, patient.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth);
    }











}