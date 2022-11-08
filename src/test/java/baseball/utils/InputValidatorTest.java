package baseball.utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.doNothing;

class InputValidatorTest {
    private static final String VALID_NUMBER = "268";
    private static final String INVALID_LENGTH_NUMBER = "2789";
    private static final String DUPLICATE_NUMBER = "223";
    private static final String NOT_NUMBER = "abc";
    private static final int MAX_LENGTH = 3;


    @Nested
    class Describe_validateUserInput {
        @Nested
        class Context_when_gives_valid_number {
            @Test
            void It_responds_nothing() {
                assertDoesNotThrow(() -> InputValidator.validateUserInput(VALID_NUMBER, MAX_LENGTH));
            }
        }

        @Nested
        class Context_when_gives_invalid_length_number {
            @Test
            void It_throws_exception() {
                assertThatThrownBy(() -> InputValidator.validateUserInput(INVALID_LENGTH_NUMBER, MAX_LENGTH))
                        .hasMessageContaining("You must enter only 3 numbers")
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        class Context_when_gives_duplicate_number {
            @Test
            void It_throws_exception() {
                assertThatThrownBy(() -> InputValidator.validateUserInput(DUPLICATE_NUMBER, MAX_LENGTH))
                        .hasMessageContaining("You must enter " +
                                MAX_LENGTH +
                                        "different numbers")
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        class Context_when_gives_not_a_number {
            @Test
            void It_throws_exception() {
                assertThatThrownBy(() -> InputValidator.validateUserInput(NOT_NUMBER, MAX_LENGTH))
                        .hasMessageContaining("You must enter only number")
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

}
