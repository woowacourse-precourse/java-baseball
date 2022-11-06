package baseball.input.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleValidatorTest {
    private final Validator validator = new ConsoleValidator();

    @Test
    void answerNormal() {
        String target = "123";
        validator.validateAnswer(target);
    }

    @Test
    void answerNoMoreThan3() {
        String target = "1234";
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateAnswer(target)
        );
    }

    @Test
    void answerNoLessThan3() {
        String target = "12";
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateAnswer(target)
        );
    }

    @Test
    void answerNoDuplicateNumber2() {
        String target = "122";
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateAnswer(target)
        );
    }

    @Test
    void answerNoDuplicateNumber3() {
        String target = "733";
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateAnswer(target)
        );
    }

    @Test
    void answerOnlyNumeric() {
        String target = "abc";
        assertThrows(IllegalArgumentException.class,
                () -> validator.validateAnswer(target)
        );
    }

    @Test
    void retryableOnly1and2() {
        String target1 = "1";
        String target2 = "2";

        validator.validateRetryable(target1);
        validator.validateRetryable(target2);
    }

    @Test
    void retryableOnlyNumeric() {
        String target = "a";

        assertThrows(IllegalArgumentException.class,
                () -> validator.validateAnswer(target)
        );
    }

    @Test
    void retryableOnlyLength1() {
        String target = "12";

        assertThrows(IllegalArgumentException.class,
                () -> validator.validateAnswer(target)
        );
    }
}