package baseball.util;

import baseball.number.NumberDto;

import static baseball.util.Constant.NUMBER_LENGTH;

public abstract class Validation {
    public static boolean validateNumberNotRepeated(NumberDto numberDto) {
        return numberDto
                .getNumber()
                .stream()
                .distinct()
                .count() == NUMBER_LENGTH;
    }
}
