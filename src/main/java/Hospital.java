
import java.util.List;
import java.util.ArrayList;

public class Hospital {

    private String hospitalName;
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Department> departments;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    public String getHospitalName() {
        return this.hospitalName;
    }

    public void addPatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Invalid patient.");
        }
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public Patient findPatientById(String patientId) {
        return patients.stream()
                .filter(p -> p.getPatientId().equals(patientId))
                .findFirst()
                .orElse(null);
    }

    public void addDoctor(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException("Invalid doctor.");
        }
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public Doctor findDoctorById(String doctorId) {
        return doctors.stream()
                .filter(d -> d.getDoctorId().equals(doctorId))
                .findFirst()
                .orElse(null);
    }

    public void addDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Invalid department.");
        }
        if (!departments.contains(department)) {
            departments.add(department);
        }
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public Department findDepartmentByName(String departmentName) {
        return departments.stream()
                .filter(d -> d.getDepartmentName().equals(departmentName))
                .findFirst()
                .orElse(null);
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors);
    }

    public List<Department> getAllDepartments() {
        return new ArrayList<>(departments);
    }

    @Override
    public String toString() {
        return "Hospital: " + hospitalName + "\n"
                + "Number of Departments: " + departments.size() + "\n"
                + "Number of Doctors: " + doctors.size() + "\n"
                + "Number of Patients: " + patients.size();
    }
}
