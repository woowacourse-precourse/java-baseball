package baseball.controller;

import static baseball.Rendering.ERROR;
import static baseball.controller.Separator.SEPARATOR;
import static baseball.model.Number.LENGTH;

import java.util.stream.Stream;

public class Validator {

    public Validator(String readLine) {
        checkRange(readLine);
        checkNumeric(readLine);
        checkDistinct(readLine);
    }

    private void checkRange(String readLine) {
        if (readLine.length() != LENGTH.getNumber()) {
            throw new IllegalArgumentException(ERROR.render());
        }
    }

    private void checkNumeric(String readLine) {
        Stream.of(readLine)
                .filter(element -> element.matches("[0-9]*$"))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR.render()));
    }

    private void checkDistinct(String readLine) {
        readLine.chars()
                .mapToObj(element -> (char) element)
                .distinct()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR.render()));
    }
}
