package org.example;

public class Hospital {

  private PatientNode dummy;
  private PatientNode tail = null;
  private int len;

  public Hospital() {
    dummy = new PatientNode(null, null, null);
    tail = dummy;
    len = 0;
  }

  public void AddPatientEnd(String id, String name, String condition) {
    PatientNode newNode = new PatientNode(id, name, condition);
    tail.next = newNode;
    tail = newNode;
    len++;
  }

  public void AddPatientFront(String id, String name, String condition) {
    PatientNode newNode = new PatientNode(id, name, condition);
    newNode.next = dummy.next;
    dummy.next = newNode;
    if (tail == dummy) {
      tail = newNode;
    }
    len++;
  }

  public void AddCriticalPatient(String id, String name) {
    AddPatientFront(id, name, "Critical");
  }

  public void AddPatientAfter(String existingID, String id, String name, String condition) {
      PatientNode newNode = new PatientNode(id, name, condition);
      PatientNode cur = dummy.next;
      boolean found = false;
      
      while (cur != null) {     
        if (cur.data.id().equals(existingID)) {  
          newNode.next = cur.next;
          cur.next = newNode;
          if (cur == tail) tail = newNode; // updates tail if it's at the end
          len++;
          found = true;
          break;
        }
        cur = cur.next;
      }

      if (!found) {
        System.out.println("Patient with ID " + existingID + " not found."); 
      }
    }

  public void RemovePatient(String id) {    
    PatientNode cur = dummy.next;
    PatientNode prev = dummy;
    boolean found = false;
    while (cur != null) {    
      if (cur.data.id().equals(id)) {       
        prev.next = cur.next;
        if (cur == tail) tail = prev;
        len--;    
        found = true;      
        break;    
      }     
      prev = cur;  
      cur = cur.next;
    }
    if (!found) {
      System.out.println("No patient found with ID: " + id);
    }    
    if (dummy.next == null) {
      tail = dummy;
    }   
  }

    public String getDisplayQueue() {
        if (dummy.next == null) {
            return "No patients in queue.\n";
        }

        PatientNode cur = dummy.next;
        int i = 1;
        String output = "";
        while (cur != null) {
             output += String.format("Patient #%d, %s %s, %s\n", i++, cur.data.name, cur.data.id, cur.data.condition);
            cur = cur.next;
        }
        return output;
    }


  public void DisplayQueue() {
    if (dummy.next == null) {
      System.out.println("No patients in queue.\n");
      return;
    }

    PatientNode cur = dummy.next;
    int i = 1;
    while (cur != null) {
      System.out.printf("Patient #%d, %s %s, %s\n", i++, cur.data.name, cur.data.id, cur.data.condition);
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
