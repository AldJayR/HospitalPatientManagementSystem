
public interface Subject {
    void registerObserver(HospitalObserver observer);
    void removeObserver(HospitalObserver observer);
    void notifyObservers(String message);
}
