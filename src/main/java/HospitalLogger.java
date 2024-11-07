
public class HospitalLogger implements HospitalObserver {

    @Override
    public void update(String message) {
        System.out.println("Hospital Log: " + message);
    }
}
