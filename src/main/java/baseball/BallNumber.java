package baseball;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BallNumber  {
    private static final int MAX = 9;
    private static final Map<Character, BallNumber> BALL_NUMBER_CHARACTER_MAP = new HashMap<>();

    static {
        IntStream.range(0, MAX)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList())
                .stream()
                .map(s -> s.codePoints().mapToObj(c -> (char) c))
                .flatMap(Stream::sorted)
                .forEach(ballNum -> BALL_NUMBER_CHARACTER_MAP.put(ballNum, new BallNumber(ballNum)));
    }

    private final char number;

    private BallNumber(char number) {
        this.number = number;
    }

    public static BallNumber ballNumber(char number) {
        return BALL_NUMBER_CHARACTER_MAP.get(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
