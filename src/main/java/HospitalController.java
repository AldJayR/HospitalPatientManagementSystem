
import java.util.List;

public class HospitalController {

    private final HospitalModel model;
    private final HospitalView view;

    public HospitalController(HospitalModel model, HospitalView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        boolean running = true;
        
        while (running) {
            view.displayMenu();
            int choice = view.getChoice();
            
            switch (choice) {
                case 1:
                    model.addPatient();
                    break;
                case 2:
                    handleCreateVisit();
                    break;
                case 3:
                    List<Patient> patients = model.getAllPatients();
                    view.displayPatients(patients);
                    break;
                case 4:
                    List<Department> departments = model.getAllDepartments();
                    view.displayDepartments(departments);
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    return;
                 default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private void handleCreateVisit() {
        List<Patient> patients = model.getAllPatients();
        if (patients.isEmpty()) {
            view.displayMessage("No patients registered in the system.");
            return;
        }
        view.displayPatients(patients);

        String patientId = view.getPatientId();

        List<Doctor> doctors = model.getAllDoctors(); 
        if (doctors.isEmpty()) {
            view.displayMessage("No doctors available in the system.");
            return;
        }
        view.displayDoctors(doctors); 

        String doctorId = view.getDoctorId();

        try {
            model.createVisit(patientId, doctorId);
            view.displayMessage("Visit created successfully!");
        } catch (Exception e) {
            view.displayMessage("Failed to create visit: " + e.getMessage());
        }
    }
}
