
import java.util.List;
import java.util.ArrayList;

public class HospitalManager implements Subject {

    private static HospitalManager instance;
    private final Hospital hospital;
    private final List<HospitalObserver> observers;
    
     private HospitalManager() {
        this.hospital = new Hospital("Main Hospital");
        this.observers = new ArrayList<>();
    }
     
    public static HospitalManager getInstance() {
        if (instance == null) {
            instance = new HospitalManager();
        }
        return instance;
    }
    
    @Override
    public void registerObserver(HospitalObserver observer) {
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(HospitalObserver observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers(String message) {
        for (HospitalObserver observer : observers) {
            observer.update(message);
        }
    }
    
    public Hospital getHospital() {
        return hospital;
    }
    
    public void addDoctor(Doctor doctor) {
        hospital.addDoctor(doctor);
        notifyObservers("New doctor added: " + doctor.getDoctorName());
    }
    
    public void addPatient(Patient patient) {
        hospital.addPatient(patient);
        notifyObservers("New patient admitted: " + patient.getName());
    }
    
    public void addDepartment(Department department) {
        hospital.addDepartment(department);
        notifyObservers("New department created: " + department.getDepartmentName());
    }
}
