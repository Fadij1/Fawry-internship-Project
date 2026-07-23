import com.FadyJohn.Radarapp.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TruckSpeedRuleTest {

    @Test
    public void testTruckSpeeding_ShouldReturnViolation() {
        TruckSpeedRule rule = new TruckSpeedRule();
        Observation obs = new Observation("TRK123", "2026-07-23", CarType.TRUCK, 65, true);

        Violation violation = rule.evaluate(obs);

        assertNotNull(violation);
        assertEquals(300, violation.fineAmount);
        assertEquals("Truck Speed Rule", violation.ruleName);
    }

    @Test
    public void testTruckWithinLimit_ShouldReturnNull() {
        TruckSpeedRule rule = new TruckSpeedRule();
        Observation obs = new Observation("TRK123", "2026-07-23", CarType.TRUCK, 60, true);

        Violation violation = rule.evaluate(obs);

        assertNull(violation);
    }
}