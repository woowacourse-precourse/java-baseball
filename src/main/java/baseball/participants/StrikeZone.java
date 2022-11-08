package baseball.participants;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StrikeZone {
    private String zone;

    public StrikeZone(String zone) {
        validateLength(zone);
        validateNumberRange(zone);
        this.zone = zone;
    }

    public StrikeZone(List<Integer> zone) {
        validateLength(zone);
        validateNumberRange(zone);
        this.zone = zone.stream()
                .map(i -> Integer.toString(i))
                .collect(Collectors.joining(""));

    }

    public String toString() {
        return zone;
    }

    private void validateNumberRange(String zone) {
        String pattern = "[1-9]{3}";
        if (!Pattern.matches(pattern, zone)) {
            throw new IllegalArgumentException("each zone number should be between 1 and 9");
        }
    }

    private void validateNumberRange(List<Integer> zone) {
        for (int i : zone) {
            if (i < 1 || i > 9) {
                throw new IllegalArgumentException("each zone number should be between 1 and 9");
            }
        }
    }

    private void validateLength(String zone) {
        if (zone.length() != 3) {
            throw new IllegalArgumentException("swing or pitch zone should be of 3 numbers");
        }
    }

    private void validateLength(List<Integer> zone) {
        if (zone.size() != 3) {
            throw new IllegalArgumentException("swing or pitch zone should be of 3 numbers");
        }
    }
}
