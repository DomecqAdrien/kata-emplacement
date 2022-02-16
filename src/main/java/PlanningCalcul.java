import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlanningCalcul {

    public static List<Zone> findHighestDensity(List<Coordinates> pointsOfInterest, int amount) {
        var zones = pointsOfInterest
                .stream()
                .map(poi -> Zone.of(poi.latitude(), poi.longitude()))
                .collect(Collectors.groupingBy(zone -> zone, Collectors.summingInt(zone -> 1)));

        return zones.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(amount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static long findAmountOfPOIByZone(List<Coordinates> pointsOfInterest, Zone zone) {
        return pointsOfInterest.stream().filter(poi -> zone.isInZone(poi.latitude(), poi.longitude())).count();
    }

}
