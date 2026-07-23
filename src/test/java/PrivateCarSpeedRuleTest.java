import com.FadyJohn.Radarapp.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrivateCarSpeedRuleTest {

    @Test
    public void testPrivateCarSpeeding_ShouldReturnViolation() {
        PrivateCarSpeedRule rule = new PrivateCarSpeedRule();
        Observation obs = new Observation("ABC123", "2026-07-23", CarType.PRIVATE, 95, true);

        Violation violation = rule.evaluate(obs);

        assertNotNull(violation);
        assertEquals(300, violation.fineAmount);
        assertEquals("Private Car Speed Rule", violation.ruleName);
    }

    @Test
    public void testPrivateCarWithinLimit_ShouldReturnNull() {
        PrivateCarSpeedRule rule = new PrivateCarSpeedRule();
        Observation obs = new Observation("ABC123", "2026-07-23", CarType.PRIVATE, 80, true);

        Violation violation = rule.evaluate(obs);

        assertNull(violation);
    }

    @Test
    public void testTruckSpeeding_ShouldBeIgnoredByThisRule() {
        PrivateCarSpeedRule rule = new PrivateCarSpeedRule();
        Observation obs = new Observation("TRK123", "2026-07-23", CarType.TRUCK, 95, true);

        Violation violation = rule.evaluate(obs);

        assertNull(violation);
    }
}