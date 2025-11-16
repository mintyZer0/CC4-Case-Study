public class Main {

  public static void main(String[] args) {
    // Simple test driver for the Hospital class
    Hospital hospital = new Hospital();

    System.out.println("--- Empty Thing ---");
    hospital.DisplayQueue();

    // Add patients to the end
    hospital.AddPatientEnd("A001", "Alice", "Stable");
    hospital.AddPatientEnd("B002", "Bob", "Recovering");

    // Add a patient to the front (higher priority)
    hospital.AddPatientFront("C003", "Carol", "Observation");

    // Add a critical patient (convenience method)
    hospital.AddCriticalPatient("D004", "Dave");

    // Insert after an existing patient
    hospital.AddPatientAfter("A001", "E005", "Eve", "Stable");

    System.out.println("--- Patient queue (after additions) ---");
    hospital.DisplayQueue();

    // Remove a patient (tail or middle)
    System.out.println("\nRemoving patient B002 (Bob)...\n");
    hospital.RemovePatient("B002");

    System.out.println("\nRemoving patient D004 (Dave)...\n");
    hospital.RemovePatient("D004");

    System.out.println("--- Patient queue (after removal) ---");
    hospital.DisplayQueue();

    // Try removing a non-existent patient (no-op in current implementation)
    System.out.println("\nAttempting to remove non-existent patient Z999...");
    hospital.RemovePatient("Z999");

    System.out.println("--- Final queue ---");
    hospital.DisplayQueue();

    hospital.AddPatientAfter("M000", "F006", "Jeffrey", "Critical");
  }
}
