
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Department {

    private String departmentName;
    private List<Doctor> doctors;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.doctors = new ArrayList<>();
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public List<Doctor> getDepartmentDoctors() {
        return new ArrayList<>(this.doctors);
    }

    public void addDoctor(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor cannot be null");
        }
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void removeDoctor(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor cannot be null");
        }
        doctors.remove(doctor);
    }

    public Doctor findDoctorById(String doctorId) {
        if (doctorId == null || doctorId.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor ID cannot be null or empty");
        }
        return doctors.stream()
                .filter(d -> d.getDoctorId().equals(doctorId))
                .findFirst()
                .orElse(null);
    }

    public Doctor findDoctorByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return doctors.stream()
                .filter(d -> d.getDoctorName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Department: " + departmentName + "\n"
                + "Number of Doctors: " + doctors.size() + "\n"
                + "Doctors: " + doctors.stream()
                        .map(Doctor::getDoctorName)
                        .collect(Collectors.joining(", "));
    }
}
