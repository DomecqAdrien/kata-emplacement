public record Zone(double minLat, double minLon, double maxLat, double maxLon) {

    public static Zone of(double lat, double lon) {
        var minLat = roundValue(lat);
        var minLon = roundValue(lon);

        return new Zone(minLat, minLon,minLat + 0.5,minLon + 0.5);
    }

    private static double roundValue(double position) {
        return Math.floor(position * 2) / 2.0;
    }

    public boolean isInZone(double lat, double lon) {
        return lat >= minLat && lat < maxLat && lon >= minLon && lon < maxLon;
    }

    @Override
    public String toString() {
        return "{" +
                "\"minLat\":" +
                minLat +
                ", \"maxLat\":" +
                maxLat +
                ", \"minLon\":" +
                minLon +
                ", \"maxLon\":" +
                maxLon +
                "}";
    }
}
