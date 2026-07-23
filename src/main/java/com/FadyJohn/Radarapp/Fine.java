import java.util.List;

public class Fine {
    
    public String plateNumber;
    public List<Violation> violations;
    public float totalFineAmount;

    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = violations;
        this.totalFineAmount = violations.stream().mapToInt(v -> v.fineAmount).sum();
    }

    public void printTicket() {
        System.out.println("Traffic  ");
        System.out.println("for car " + plateNumber);
        System.out.println("Total amount: " + totalFineAmount + " EGP");
        System.out.print("Violations:");
        for (Violation v : violations) {
            System.out.print(" - " + v.description + " : " + v.fineAmount + " EGP");
        }
        System.out.println("\n");
    }
}
