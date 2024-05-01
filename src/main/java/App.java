import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Whats the number of appointments a doctor can have? ");
        int apptNum = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the number of doctors rostered for today: ");
        int docNum = sc.nextInt();
        sc.nextLine();

        docQueue = new Queue[docNum];

        for (int i = 0; i < docNum; i++) {
            System.out.print("Enter the name of doctor: ");
            String doctorName = sc.nextLine();
            docQueue[i] = new Queue<>(upperBound, doctorName);
        }
        

    }
}
