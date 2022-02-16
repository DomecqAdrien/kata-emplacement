import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var filePath = Main.class.getClassLoader().getResource("csv.txt").toString();
        var pointsOfInterest = PlanningParser.parsePlanningFile(filePath);

        System.out.println(PlanningCalcul.findAmountOfPOIByZone(pointsOfInterest, Zone.of(6.5, -7)));
        System.out.println(PlanningCalcul.findHighestDensity(pointsOfInterest, 2));
    }
}
