import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlanningParser {
    public static List<Coordinates> parsePlanningFile(String filePath) throws IOException {
        var path = Paths.get(URI.create(filePath));
        return Files.readAllLines(path)
                .stream()
                .skip(1)
                .map(PlanningParser::parseCoordinates)
                .toList();
    }

    private static Coordinates parseCoordinates(String line) {
        var splitLine = line.split(" ");

        return new Coordinates(
                Double.parseDouble(splitLine[1]),
                Double.parseDouble(splitLine[2])
        );
    }
}
