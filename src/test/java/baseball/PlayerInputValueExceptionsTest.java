package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlayerInputValueExceptionsTest {

    @Test
    @DisplayName("입력된 수가 3자리 이상이면 예외 발생")
    void isThreeDigitsNumber() {
        //given
        ArrayList<String> userSelectedNumbers = new ArrayList<>(
                Arrays.asList("1", "2", "3", "4")
        );

        //then
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayerInputValueExceptions.isThreeDigitsNumber(userSelectedNumbers); //when
        });
        assertEquals("3자리만 입력하세요", exception.getMessage());
    }

    @Test
    void haveDuplicateNumbers() {
    }

    @Test
    void whenExitingIsNumberOneOrTwo() {
    }
}