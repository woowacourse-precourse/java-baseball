package baseball.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputExceptionTest {

    @Test
    void containsNonDigit() {
        String normal = "123";
        String nonDigit = "4ab";
        String space = "1 3";

        Boolean bool1 = InputException.containsNonDigit(normal);
        Boolean bool2 = InputException.containsNonDigit(nonDigit);
        Boolean bool3 = InputException.containsNonDigit(space);

        assertThat(bool1).isFalse();
        assertThat(bool2).isTrue();
        assertThat(bool3).isTrue();

        assertThrows(IllegalArgumentException.class, () -> {
            InputException.validateInputNumber(nonDigit);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputException.validateInputNumber(space);
        });

    }

    @Test
    void isNotThreeDigits() {
        String threeDigits = "123";
        String twoDigits = "12";
        String fourDigits = "1234";

        Boolean bool1 = InputException.isNotThreeDigits(threeDigits);
        Boolean bool2 = InputException.isNotThreeDigits(twoDigits);
        Boolean bool3 = InputException.isNotThreeDigits(fourDigits);

        assertThat(bool1).isFalse();
        assertThat(bool2).isTrue();
        assertThat(bool3).isTrue();

        assertThrows(IllegalArgumentException.class, () -> {
            InputException.validateInputNumber(twoDigits);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputException.validateInputNumber(fourDigits);
        });
    }

    @Test
    void containsDuplicateDigits() {
        String normal = "123";
        String duplicate1 = "122";
        String duplicate2 = "333";

        Boolean bool1 = InputException.containsDuplicateDigits(normal);
        Boolean bool2 = InputException.containsDuplicateDigits(duplicate1);
        Boolean bool3 = InputException.containsDuplicateDigits(duplicate2);

        assertThat(bool1).isFalse();
        assertThat(bool2).isTrue();
        assertThat(bool3).isTrue();

        assertThrows(IllegalArgumentException.class, () -> {
            InputException.validateInputNumber(duplicate1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            InputException.validateInputNumber(duplicate2);
        });
    }

    @Test
    void isEmptyInput() {
        String normal = "123";
        String empty = "";

        Boolean bool1 = InputException.isEmptyInput(normal);
        Boolean bool2 = InputException.isEmptyInput(empty);

        assertThat(bool1).isFalse();
        assertThat(bool2).isTrue();

        assertThrows(IllegalArgumentException.class, () -> {
            InputException.validateInputNumber(empty);
        });
    }
}