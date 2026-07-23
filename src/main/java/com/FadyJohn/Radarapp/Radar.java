import java.util.*;

public class Radar {
    private List<Rule> rules = new ArrayList<>();
    private List<Fine> issuedFines = new ArrayList<>();

    public void addRule(Rule rule)
    {rules.add(rule);}

    public void processObservation(Observation obs)
    {
        List<Violation> detectViolations = new ArrayList<>();

        for (Rule rule : rules)
        {
            Violation violation = rule.evaluate(obs);
            if (violation != null) detectViolations.add(violation);
        }
        if (!detectViolations.isEmpty())
        {
            Fine fine = new Fine(obs.carNumber, detectViolations);
            issuedFines.add(fine);
            fine.printTicket();
        }
    }

    public Map<String, Integer> getAllPossibleFines() {
        Map<String, Integer> finesMap = new HashMap<>();
        for (Fine fine : issuedFines) {
            finesMap.put(fine.plateNumber, (int) (finesMap.getOrDefault(fine.plateNumber, 0) + fine.totalFineAmount));
        }
        return finesMap;
    }

    public Map<String, Integer> getViolatedRulesCount() {
        Map<String, Integer> rulesCount = new HashMap<>();
        for (Fine fine : issuedFines) {
            for (Violation v : fine.violations) {
                rulesCount.put(v.ruleName, (int) (rulesCount.getOrDefault(v.ruleName, 0) + 1));
            }
        }
        return rulesCount;
    }

}
