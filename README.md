# CC4-Case-Study

## Hospital Patient Queue Management System (Linked List)

### Scenario / Background:

A hospital emergency department manages patient arrivals dynamically. New patients can be added anytime, while others may leave or be prioritized for urgent care.

### Problem Description:

Develop a linked list-based patient management system. Each node represents a patient containing:

- Patient ID
- Name
- Condition Level (Normal, Urgent, Critical)

### Required Operations to Implement:

1. AddPatientEnd(id, name, condition) – Add a patient to the end of the list.
2. AddCriticalPatient(id, name) – Add a critical patient to the front.
3. AddPatientAfter(existingID, id, name, condition) – Insert a patient after another.
4. RemovePatient(id) – Remove a patient when attended.
5. DisplayQueue() – List all waiting patients.
