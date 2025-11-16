import java.util.Scanner;

public class Sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital queue = new Hospital();
        int choice;
        
        do {
            System.out.println("===== Hospital Patient Queue System =====");
            System.out.println("1. Add Patient (End)");
            System.out.println("2. Add Critical Patient (Front)");
            System.out.println("3. Add Patient After Another");
            System.out.println("4. Remove Patient");
            System.out.println("5. Display Queue");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Condition (Normal/Urgent/Critical): ");
                    String condition = sc.nextLine();
                    queue.AddPatientEnd(id, name, condition);
                    break;
                }

                case 2: {
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    queue.AddCriticalPatient(id, name);
                    break;
                }

                case 3: {
                    System.out.print("Enter Existing Patient ID: ");
                    String existingID = sc.nextLine();
                    System.out.print("Enter New Patient ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Condition (Normal/Urgent/Critical): ");
                    String condition = sc.nextLine();
                    queue.AddPatientAfter(existingID, id, name, condition);
                    break;
                }

                case 4: {
                    System.out.print("Enter Patient ID to Remove: ");
                    String id = sc.nextLine();
                    queue.RemovePatient(id);
                    break;
                }

                case 5: 
                    queue.DisplayQueue();
                    break;

                case 0: 
                    System.out.println("Exiting... Thank you!");
                    break;

                default: System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);

    }
}