import java.util.*;

class Patient {
    String id;
    String name;
    int age;
    String gender;

    Patient(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}

class Appointment {
    String patientId;
    String doctorName;
    String date;
    String time;

    Appointment(String patientId, String doctorName, String date, String time) {
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }

    public String toString() {
        return "Patient ID: " + patientId + ", Doctor: " + doctorName + ", Date: " + date + ", Time: " + time;
    }
}

class HospitalManagementSystem {
    Scanner scanner = new Scanner(System.in);
    List<Patient> patients = new ArrayList<>();
    List<Appointment> appointments = new ArrayList<>();

    void registerPatient() {
        System.out.println("Enter Patient ID:");
        String id = scanner.nextLine();
        System.out.println("Enter Patient Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Gender:");
        String gender = scanner.nextLine();
        patients.add(new Patient(id, name, age, gender));
        System.out.println("Patient registered successfully!\n");
    }

    void scheduleAppointment() {
        System.out.println("Enter Patient ID:");
        String patientId = scanner.nextLine();
        System.out.println("Enter Doctor's Name:");
        String doctorName = scanner.nextLine();
        System.out.println("Enter Appointment Date (YYYY-MM-DD):");
        String date = scanner.nextLine();
        System.out.println("Enter Appointment Time (HH:MM):");
        String time = scanner.nextLine();
        appointments.add(new Appointment(patientId, doctorName, date, time));
        System.out.println("Appointment scheduled successfully!\n");
    }

    void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.\n");
            return;
        }
        System.out.println("Registered Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
        System.out.println();
    }

    void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.\n");
            return;
        }
        System.out.println("Scheduled Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
        System.out.println();
    }

    void menu() {
        while (true) {
            System.out.println("Hospital Management System");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View Patients");
            System.out.println("4. View Appointments");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    scheduleAppointment();
                    break;
                case 3:
                    viewPatients();
                    break;
                case 4:
                    viewAppointments();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();
        hms.menu();
    }
}
