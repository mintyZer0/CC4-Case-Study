import java.util.HashMap;

public class Hospital {

  private PatientNode dummy;
  private PatientNode tail = null;
  private int len;

  public Hospital() {
    dummy = new PatientNode(null, null, null);
    tail = dummy;
    len += 1;
  }

  public void AddPatientEnd(String id, String name, String condition) {
    PatientNode newNode = new PatientNode(id, name, condition);
    tail.next = newNode;
    tail = newNode;
  }

  public void AddPatientFront(String id, String name, String condition) {
    PatientNode newNode = new PatientNode(id, name, condition);
    newNode.next = dummy.next;
    dummy.next = newNode;
    len += 1;
  }

  public void AddCriticalPatient(String id, String name) {
    AddPatientFront(id, name, "Critical");
  }

  public void AddPatientAfter(
    String existingID,
    String id,
    String name,
    String condition
  ) {
    PatientNode newNode = new PatientNode(id, name, condition);
    PatientNode cur = dummy.next;
    for (int i = 0; i < len; i++) {
      if (cur.data.id.equals(existingID)) {
        newNode.next = cur.next;
        cur.next = newNode;
        len += 1;
        break;
      }
      cur = cur.next;
    }
  }

  public void RemovePatient(String id) {
    PatientNode cur = dummy.next;
    PatientNode prev = dummy;
    for (int i = 0; i < len; i++) {
      if (cur.data.id.equals(id)) {
        if (cur == tail) {
          prev.next = null;
          tail = prev;
          len -= 1;
          break;
        } else {
          prev.next = prev.next.next;
          len -= 1;
          break;
        }
      }
      prev = cur;
      cur = cur.next;
    }
  }

  public void DisplayQueue() {
    PatientNode cur = dummy.next;
    for (int i = 0; i < len; i++) {
      String string = String.format(
        "Patient #%d, %s %s, %s",
        i + 1,
        cur.data.name,
        cur.data.id,
        cur.data.condition
      );
      System.out.println(string);
      cur = cur.next;
    }
  }

  private static class PatientNode {

    public record Patient(String id, String name, String condition) {}

    public final Patient data;
    public PatientNode next;

    public PatientNode(String id, String name, String condition) {
      this.data = new Patient(id, name, condition);
    }
  }
}
