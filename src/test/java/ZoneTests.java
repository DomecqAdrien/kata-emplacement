import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZoneTests {
    @ParameterizedTest
    @CsvSource(value = {
            "-48.6|-37.7|-49|-38",
            "6.8|-6.9|6.5|-7",
            "0.1|-0.1|0|-0.5",
            "-2.1|38.1|-2.5|38",
    }, delimiter = '|')
    void shouldKnowIfACoordinateIsInZone(
            double latitude, double longitude,
            double expectedZoneMinLatitude, double expectedZoneMinLongitude) {
        var zone = Zone.of(expectedZoneMinLatitude, expectedZoneMinLongitude);

        assertTrue(zone.isInZone(latitude, longitude));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-49.6|-37.7|-49|-38",
            "6.8|-16.9|6.5|-7",
            "0.1|-0.6|0|-0.5",
            "-2.1|40.1|-2.5|38",
    }, delimiter = '|')
    void shouldKnowIfACoordinateIsNotInZone(
            double latitude, double longitude,
            double expectedZoneMinLatitude, double expectedZoneMinLongitude) {
        var zone = Zone.of(expectedZoneMinLatitude, expectedZoneMinLongitude);

        assertFalse(zone.isInZone(latitude, longitude));
    }
}
