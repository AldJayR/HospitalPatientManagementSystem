
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class HospitalView {

    private static int patientIdCounter = 0;
    private Scanner scanner;

    public HospitalView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n=== Hospital Patient Management System ===");
        System.out.println("1. Add Patient");
        System.out.println("2. Create Visit");
        System.out.println("3. List Patients");
        System.out.println("4. List Departments");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public int getChoice() {
        while (true) {
            try {
                return Integer.valueOf(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid choice");
            }
        }
    }

    public Patient getPatientInfo() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        System.out.print("Enter patient address: ");
        String address = scanner.nextLine();

        System.out.print("Enter patient contact number: ");
        String contactInfo = scanner.nextLine();

        System.out.print("Enter patient date of birth (MM/DD/YYYY): ");
        String dateInput = scanner.nextLine();

        LocalDate dateBirth = parseDate(dateInput);

        System.out.print("Enter patient gender: ");
        String gender = scanner.nextLine();

        return new Patient(String.valueOf(++patientIdCounter), name, address, contactInfo, dateBirth, gender);

    }

    private static LocalDate parseDate(String dateInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        try {
            return LocalDate.parse(dateInput, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public void displayPatients(List<Patient> patients) {
        System.out.println("\n=== Patients List ===");
        patients.forEach(System.out::println);
    }

    public void displayDepartments(List<Department> departments) {
        System.out.println("\n=== Departments List ===");
        departments.forEach(System.out::println);
    }

    public void displayMessage(String message) {
        System.out.println("\n" + message);
    }

    public void displayDoctors(List<Doctor> doctors) {
        System.out.println("\n=== Available Doctors ===");
        doctors.forEach(System.out::println);
    }

    public String getPatientId() {
        while (true) {
            try {
                System.out.print("\nEnter patient ID: ");
                String patientId = scanner.nextLine().trim();

                if (patientId.isEmpty()) {
                    System.out.println("Patient ID cannot be empty. Please try again.");
                    continue;
                }

                return patientId;

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public String getDoctorId() {
        while (true) {
            try {
                System.out.print("\nEnter doctor ID: ");
                String doctorId = scanner.nextLine().trim();

                if (doctorId.isEmpty()) {
                    System.out.println("Doctor ID cannot be empty. Please try again.");
                    continue;
                }

                return doctorId;

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

}
