import com.FadyJohn.Radarapp.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class RadarTest {

    private Radar radar;

    @BeforeEach
    public void setup() {
        radar = new Radar();
        radar.addRule(new SeatbeltRule());
        radar.addRule(new PrivateCarSpeedRule());
        radar.addRule(new TruckSpeedRule());
    }

    @Test
    public void testProcessObservation_WithViolations() {
        // Speeding (300) + No Seatbelt (100) = 400 total
        Observation obs = new Observation("ABC123", "2026-07-23", CarType.PRIVATE, 94, false);
        radar.processObservation(obs);

        Map<String, Integer> allFines = radar.getAllPossibleFines();
        assertEquals(1, allFines.size());
        assertEquals(400, allFines.get("ABC123"));
    }

    @Test
    public void testProcessObservation_NoViolations() {
        Observation obs = new Observation("SAFE99", "2026-07-23", CarType.PRIVATE, 70, true);
        radar.processObservation(obs);

        Map<String, Integer> allFines = radar.getAllPossibleFines();
        assertTrue(allFines.isEmpty());
    }

    @Test
    public void testAggregatedFines_MultipleObservationsSameCar() {
        Observation obs1 = new Observation("TRK99", "2026-07-23", CarType.TRUCK, 65, true); // 300
        Observation obs2 = new Observation("TRK99", "2026-07-24", CarType.TRUCK, 70, false); // 300 + 100 = 400

        radar.processObservation(obs1);
        radar.processObservation(obs2);

        Map<String, Integer> allFines = radar.getAllPossibleFines();
        // The car was ticketed twice, total should be 300 + 400 = 700
        assertEquals(700, allFines.get("TRK99"));
    }

    @Test
    public void testGetViolatedRulesCount() {
        Observation obs1 = new Observation("ABC123", "2026-07-23", CarType.PRIVATE, 94, false); // Private Speed, Seatbelt
        Observation obs2 = new Observation("TRK99", "2026-07-23", CarType.TRUCK, 50, false); // Seatbelt only

        radar.processObservation(obs1);
        radar.processObservation(obs2);

        Map<String, Integer> rulesCount = radar.getViolatedRulesCount();

        assertEquals(2, rulesCount.get("Seatbelt Rule"));
        assertEquals(1, rulesCount.get("Private Car Speed Rule"));
        assertNull(rulesCount.get("Truck Speed Rule")); // Never violated
    }
}