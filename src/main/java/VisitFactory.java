
import java.time.LocalDate;

public class VisitFactory {

    private static long visitCounter = 1;

    public static Visit createVisit(Patient patient, Doctor doctor) {
        if (patient == null || doctor == null) {
            throw new IllegalArgumentException("Patient and doctor cannot be null");
        }

        String visitId = "V" + visitCounter++;
        Visit visit = new Visit(
                visitId,
                patient.getPatientId(),
                LocalDate.now(),
                doctor.getDoctorName(),
                doctor.getSpecialization(),
                "",
                ""
        );
        HospitalManager.getInstance().notifyObservers(
            "New visit created: " + visitId + " for patient " + patient.getName()
        );
        
        return visit;
        
    }
}
