package baseball;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum State {
    RESTART("1"),
    SHUTDOWN("2");

    private String number;

    State(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    private static final Map<String, State> numbers = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(State::getNumber, Function.identity())));

    public static boolean isValidNumber(String number) {
        return Optional.ofNullable(numbers.get(number)).isPresent();
    }
}
