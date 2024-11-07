
import java.time.LocalDate;

public class Visit {

    private String visitId;
    private String patientId;
    private LocalDate visitDate;
    private String doctorName;
    private String department;
    private String diagnosis;
    private String treatment;

    public Visit(String visitId, String patientId, LocalDate visitDate, String doctorName, String department,
            String diagnosis, String treatment) {
        this.visitId = visitId;
        this.patientId = patientId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.department = department;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String getVisitId() {
        return this.visitId;
    }

    public void setVisitId(String visitId) {
        if (visitId == null || visitId.trim().isEmpty()) {
            throw new IllegalArgumentException("Visit ID cannot be null or empty");
        }
        this.visitId = visitId;
    }

    public LocalDate getVisitDate() {
        return this.visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        if (visitDate == null) {
            throw new IllegalArgumentException("Visit date cannot be null");
        }
        if (visitDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Visit date cannot be in the future");
        }
        this.visitDate = visitDate;
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    public void setDoctorName(String doctorName) {
        if (doctorName == null || doctorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor name cannot be null or empty");
        }
        this.doctorName = doctorName;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }
        this.department = department;
    }

    public String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.trim().isEmpty()) {
            throw new IllegalArgumentException("Diagnosis cannot be null or empty");
        }
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return this.treatment;
    }

    public void setTreatment(String treatment) {
        if (treatment == null || treatment.trim().isEmpty()) {
            throw new IllegalArgumentException("Treatment cannot be null or empty");
        }
        this.treatment = treatment;
    }
    
    public String getPatientId() {
        return this.patientId;
    }
    
    public void setPatientId(String patientId) {
        if (patientId == null || patientId.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient ID cannot be null or empty");
        }
        this.patientId = patientId;
    }
    

    @Override
    public String toString() {
        return "Visit ID: " + visitId + "\n"
                + "Visit Date: " + visitDate + "\n"
                + "Doctor Name: " + doctorName + "\n"
                + "Department: " + department + "\n"
                + "Diagnosis: " + diagnosis + "\n"
                + "Treatment: " + treatment;
    }
}
