import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TripCalculatorTest {

    @Test
    void fuelNeeded() {
        TripCalculator calculator = new TripCalculator();

        assertEquals(5.0, calculator.fuelNeeded(100), 0.001, "5.0 liters of fuel");
        assertEquals(10.0, calculator.fuelNeeded(200), 0.001, "10.0 liters of fuel");
        assertEquals(0.0, calculator.fuelNeeded(0), 0.001, "0.0 liters of fuel");
        assertEquals(2.5, calculator.fuelNeeded(50), 0.001, "2.5 liters of fuel");
    }

    @Test
    void totalPrice() {
        TripCalculator calculator = new TripCalculator();

        assertEquals(7.5, calculator.totalPrice(5.0, 1.5), 0.001, "should cost 7.5");
        assertEquals(0.0, calculator.totalPrice(0.0, 1.5), 0.001, "should cost 0.0");
        assertEquals(0.0, calculator.totalPrice(5.0, 0.0), 0.001, "should cost 0.0");
        assertEquals(20.0, calculator.totalPrice(10.0, 2.0), 0.001, "liter should cost 20.0");
    }

    @Test
    void main() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        try {
            String input = "100\n1.5\n";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            System.setOut(new PrintStream(outputStreamCaptor));

            TripCalculator.main(new String[]{});

            String output = outputStreamCaptor.toString();
            assertTrue(output.contains("Fuel needed to travel: 5.0"), "Output should contain fuel needed message");
            assertTrue(output.contains("Trip total cost: 7.5"), "Output should contain trip cost message");
        }
        catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
