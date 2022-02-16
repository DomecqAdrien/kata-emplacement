import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanningParserTests {
    @Test
    void shouldBeAbleToParseFile() throws IOException {
        var expected = List.of(
            new Coordinates(-48.6, -37.7),
            new Coordinates(-27.1, 8.4),
            new Coordinates(6.6, -6.9));

        var filePath = PlanningParserTests.class.getClassLoader().getResource("test.csv").toString();

        var actual = PlanningParser.parsePlanningFile(filePath);

        assertEquals(expected, actual);
    }
}
