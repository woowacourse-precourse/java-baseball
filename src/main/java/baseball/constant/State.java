package baseball.constant;

import baseball.validator.InputValidator;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum State {
    RESTART("1", true),
    SHUTDOWN("2", false);

    private String number;
    private boolean start;

    State(String number, boolean start) {
        this.number = number;
        this.start = start;
    }

    public String getNumber() {
        return number;
    }

    public boolean isStart() {
        return start;
    }

    private static final Map<String, State> numbers = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(State::getNumber, Function.identity())));

    public static boolean isValidNumber(String number) {
        return Optional.ofNullable(numbers.get(number)).isPresent();
    }

    public static State getState(String number) {
        InputValidator.validateStateNumber(number);
        return Optional.ofNullable(numbers.get(number)).get();
    }
}