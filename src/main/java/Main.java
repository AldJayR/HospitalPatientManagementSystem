
public class Main {

    public static void main(String[] args) {
        HospitalView view = new HospitalView();
        HospitalModel model = new HospitalModel(view);
        HospitalController controller = new HospitalController(model, view);

        initializeSampleData(model);

        controller.start();
    }

    private static void initializeSampleData(HospitalModel model) {
        try {
            Doctor doctor1 = new Doctor("D001", "Dr. John Smith", "Cardiology");
            Doctor doctor2 = new Doctor("D002", "Dr. Sarah Johnson", "Pediatrics");
            Doctor doctor3 = new Doctor("D003", "Dr. Michael Brown", "Orthopedics");

            Department cardiology = new Department("Cardiology");
            Department pediatrics = new Department("Pediatrics");
            Department orthopedics = new Department("Orthopedics");

            HospitalManager manager = HospitalManager.getInstance();
            manager.addDoctor(doctor1);
            manager.addDoctor(doctor2);
            manager.addDoctor(doctor3);

            manager.addDepartment(cardiology);
            manager.addDepartment(pediatrics);
            manager.addDepartment(orthopedics);

            cardiology.addDoctor(doctor1);
            pediatrics.addDoctor(doctor2);
            orthopedics.addDoctor(doctor3);

        } catch (Exception e) {
            System.err.println("Error initializing sample data: " + e.getMessage());
        }
    }
}
