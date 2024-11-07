
import java.util.List;
import java.time.LocalDate;

public class HospitalModel {

    private HospitalManager manager;
    private HospitalView view;

    public HospitalModel(HospitalView view) {
        this.manager = HospitalManager.getInstance();
        this.manager.registerObserver(new HospitalLogger());
        this.view = view;
    }

    public void addPatient() {
        Patient patient = view.getPatientInfo();
        manager.addPatient(patient);
    }

    public void createVisit(String patientId, String doctorId) {
        Hospital hospital = manager.getHospital();
        Patient patient = hospital.findPatientById(patientId);
        Doctor doctor = hospital.findDoctorById(doctorId);

        if (patient != null && doctor != null) {
            Visit visit = VisitFactory.createVisit(patient, doctor);
            patient.addVisit(visit);
            doctor.assignVisit(visit);
        }
    }

    public List<Patient> getAllPatients() {
        return manager.getHospital().getAllPatients();
    }

    public List<Department> getAllDepartments() {
        return manager.getHospital().getAllDepartments();
    }
    
    public List<Doctor> getAllDoctors() {
        return manager.getHospital().getAllDoctors();
    }
}
