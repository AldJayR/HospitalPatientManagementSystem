
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient {

    private String patientId;
    private String name;
    private String address;
    private String contactInfo;
    private LocalDate dateOfBirth;
    private String gender;
    private List<Visit> visits;

    public Patient(String patientId, String name, String address, String contactInfo,
            LocalDate dateOfBirth, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.visits = new ArrayList<>();
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        this.address = address;
    }

    public String contactInfo() {
        return this.contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        if (contactInfo == null || contactInfo.trim().isEmpty()) {
            throw new IllegalArgumentException("Contact info cannot be null or empty");
        }
        this.contactInfo = contactInfo;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date of birth cannot be in the future");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Gender cannot be null or empty");
        }
        this.gender = gender;
    }

    public List<Visit> getVisits() {
        return new ArrayList<>(visits);
    }

    public void setVisits(List<Visit> visits) {
        if (visits == null) {
            throw new IllegalArgumentException("Visits list cannot be null");
        }
        this.visits = visits;
    }
    
    public void addVisit(Visit visit) {
        if (visit == null) {
            return;
        }
        
        visits.add(visit);
    }
    @Override
    public String toString() {
        return "ID: " + patientId + "\n"
                + "Patient Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "Contact Info: " + contactInfo + "\n"
                + "Date of Birth: " + dateOfBirth + "\n"
                + "Gender: " + gender + "\n"
                + "Visits: " + visits;
    }
}
