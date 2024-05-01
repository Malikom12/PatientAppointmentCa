import java.time.LocalDate;
import java.util.Objects;

public class Appointment implements Comparable<Appointment>{
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String issue;
    private LocalDate date;
    private int triageLevel;
    private String doctorName;

    public Appointment(String firstName, String lastName, LocalDate dateOfBirth, String issue, LocalDate date, int triageLevel, String doctorName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.issue = issue;
        this.date = date;
        this.triageLevel = triageLevel;
        this.doctorName = doctorName;
    }

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

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        if (issue != null){
            this.issue = issue;
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now())) {
            this.date = date;
        }
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel) {
        if (triageLevel >= 1 && triageLevel <= 5){
            this.triageLevel = triageLevel;
        }
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        if (doctorName != null){
            this.doctorName = doctorName;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return triageLevel == that.triageLevel && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(issue, that.issue) && Objects.equals(date, that.date) && Objects.equals(doctorName, that.doctorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth, issue, date, triageLevel, doctorName);
    }

    @Override
    public int compareTo(Appointment other) {
        int triageComparison = Integer.compare(this.triageLevel, other.triageLevel);
        if (triageComparison != 0) {
            return triageComparison;
        }
//committing
        return this.date.compareTo(other.date);
    }
}
