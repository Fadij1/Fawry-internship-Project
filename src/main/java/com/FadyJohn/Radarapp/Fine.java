import java.util.List;

public class Fine {
    
    public String plateNumber;
    public List<Violation> violations;
    public float totalFineAmount;

    public Fine(String plateNumber, List<Violation> violations, float totalFineAmount) {
        this.plateNumber = plateNumber;
        this.violations = violations;
        this.totalFineAmount = totalFineAmount;
    }
}
