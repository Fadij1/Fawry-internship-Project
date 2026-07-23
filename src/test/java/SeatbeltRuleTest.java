import com.FadyJohn.Radarapp.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeatbeltRuleTest {

    @Test
    public void testSeatbeltUnfastened_ShouldReturnViolation() {
        SeatbeltRule rule = new SeatbeltRule();
        Observation obs = new Observation("ABC123", "2026-07-23", CarType.PRIVATE, 60, false);
        
        Violation violation = rule.evaluate(obs);
        
        assertNotNull(violation);
        assertEquals(100, violation.fineAmount);
        assertEquals("Seatbelt Rule", violation.ruleName);
    }

    @Test
    public void testSeatbeltFastened_ShouldReturnNull() {
        SeatbeltRule rule = new SeatbeltRule();
        Observation obs = new Observation("ABC123", "2026-07-23", CarType.PRIVATE, 60, true);
        
        Violation violation = rule.evaluate(obs);
        
        assertNull(violation);
    }
}