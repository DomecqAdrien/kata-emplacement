import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PlanningCalculTests {
    private final List<Coordinates> pointsOfInterest = List.of(
            new Coordinates(-48.6, -37.7),
            new Coordinates(-27.1, 8.4),
            new Coordinates(6.6, -6.9),
            new Coordinates(-2.3, 38.3),
            new Coordinates(6.8, -6.9),
            new Coordinates(-2.5, 38.3),
            new Coordinates(0.1, -0.1),
            new Coordinates(-2.1, 38.1));

    @Test
    void shouldReturnTwoPOI() {
        assertEquals(2, PlanningCalcul.findAmountOfPOIByZone(pointsOfInterest, Zone.of(6.5, -7)));
    }

    @Test
    void shouldReturnThreePOI() {
        assertEquals(3, PlanningCalcul.findAmountOfPOIByZone(pointsOfInterest, Zone.of(-2.5, 38)));
    }

    @Test
    void shouldReturnTheTwoHighestZones() {
        var expected = Arrays.asList(
            Zone.of(-2.5, 38),
            Zone.of(6.5, -7)
        );

        var actual = PlanningCalcul.findHighestDensity(pointsOfInterest, 2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTheHighestZone() {
        var expected = List.of(
            Zone.of(-2.5, 38)
        );

        var actual = PlanningCalcul.findHighestDensity(pointsOfInterest, 1);

        Assertions.assertEquals(expected, actual);
    }
}
