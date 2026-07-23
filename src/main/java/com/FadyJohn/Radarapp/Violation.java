public class Violation {
 
    public String description;
    public int fineAmount;
    public String ruleName;

    public Violation(String description, int fineAmount, String ruleName) {
        this.description = description;
        this.fineAmount = fineAmount;
        this.ruleName = ruleName;
    }
}