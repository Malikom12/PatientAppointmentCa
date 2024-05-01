import java.time.LocalDate;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);
    private static final HashMap patients = new HashMap();
    private static BoundedPriorityQueue[] docQueue;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Whats the number of appointments a doctor can have? ");
        int apptNum = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the number of doctors rostered for today: ");
        int docNum = sc.nextInt();
        sc.nextLine();

        docQueue = new BoundedPriorityQueue[docNum];

        for (int i = 0; i < docNum; i++) {
            System.out.print("Enter the name of doctor: ");
            int doctorName = sc.nextInt();
            docQueue[i] = new BoundedPriorityQueue(doctorName);
        }

        boolean exit = false;


        while(!exit){
            System.out.println("Select from below:");
            System.out.println("1. Add a new patient to the practice");
            System.out.println("2. Delete a patient from the practice");
            System.out.println("3. Display all patients");
            System.out.println("4. Create a new appointment for a specific patient");
            System.out.println("5. Call the next patient in for a specified doctor");
            System.out.println("6. Exit");
            System.out.println("Please enter option: ");
            String choice = sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter the patient's first name: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String firstName = sc.nextLine();
                    System.out.print("Enter the patient's last name: ");
                    String lastName = sc.nextLine();
                    System.out.print("Enter the patient's date of birth: ");
                    LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());
                    System.out.print("Enter the date the patient joined the practice: ");
                    LocalDate joinedDate = LocalDate.parse(sc.nextLine());

                    Patient patient = new Patient(firstName, lastName, dateOfBirth, joinedDate);
                    String key = firstName+lastName+dateOfBirth;
                    if (patients.get(key) != null) {
                        System.out.println("Patient already exists in the practice.");
                    } else {
                        patients.put(key, patient);
                        System.out.println("Patient added successfully.");
                    }
                    break;
                case 2:
                    Scanner scanner = new Scanner(System.in);

                    System.out.print("Enter the patient's first name: ");
                    String firstName1 = scanner.nextLine();
                    System.out.print("Enter the patient's last name: ");
                    String lastName1 = scanner.nextLine();
                    System.out.print("Enter the patient's date of birth: ");
                    LocalDate dateOfBirth1 = LocalDate.parse(scanner.nextLine());

                    String key1 = firstName1 + lastName1 + dateOfBirth1;
                    Patient patient1 = patients.remove(key1);
                    if (patient1 != null) {
                        System.out.println("Patient deleted successfully.");
                    } else {
                        System.out.println("Patient not found in the practice.");
                    }
                    break;
                case 3:
                    displayPatients();
                    break;
                case 4:
                    createAppointment();
                    break;
                case 5:
                    callNextPatient();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        }
        

    }

