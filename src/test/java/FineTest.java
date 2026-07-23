import com.FadyJohn.Radarapp.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FineTest {

    @Test
    public void testTotalAmountCalculation() {
        Violation v1 = new Violation("Speeding", 300, "Speed Rule");
        Violation v2 = new Violation("No Seatbelt", 100, "Seatbelt Rule");
        List<Violation> violations = Arrays.asList(v1, v2);

        Fine fine = new Fine("ABC123", violations);

        // 300 + 100 = 400
        assertEquals(400, fine.totalFineAmount);
        assertEquals("ABC123", fine.plateNumber);
        assertEquals(2, fine.violations.size());
    }
}