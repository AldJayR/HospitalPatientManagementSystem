
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Doctor {

    private String doctorId;
    private String name;
    private String specialization;
    private List<Visit> visits;

    public Doctor(String doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.visits = new ArrayList<>();
    }

    public String getDoctorId() {
        return this.doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return this.name;
    }

    public void setDoctorName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void assignVisit(Visit visit) {
        if (visit == null) {
            throw new IllegalArgumentException("Visit cannot be null");
        }

        visits.add(visit);
    }

    public List<Visit> getAssignedVisits() {
        return this.visits;
    }

    public void removeVisit(Visit visit) {
        if (visit == null) {
            throw new IllegalArgumentException("Visit cannot be null");
        }
        visits.remove(visit);
    }

    public List<Visit> findVisitsByDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return visits.stream()
                .filter(v -> v.getVisitDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Visit> findVisitsByPatient(String patientId) {
        if (patientId == null || patientId.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient ID cannot be null or empty");
        }
        return visits.stream()
                .filter(v -> v.getPatientId().equals(patientId))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorId + "\n"
                + "Name: " + name + "\n"
                + "Specialization: " + specialization + "\n"
                + "Number of Visits: " + visits.size();
    }
}
