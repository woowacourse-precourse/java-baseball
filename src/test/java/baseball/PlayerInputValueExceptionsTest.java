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
    @DisplayName("입력된 세자리 수에 중복이 있으면 예외 발생")
    void haveDuplicateNumbers() {
        //given
        ArrayList<String> userSelectedNumbers = new ArrayList<>(
                Arrays.asList("1", "3", "3")
        );

        //then
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayerInputValueExceptions.haveDuplicateNumbers(userSelectedNumbers); //when
        });
        assertEquals("서로 다른 3자리의 수를 입력하세요", exception.getMessage());
    }

    @Test
    @DisplayName("종료 시 입력된 수가 1 또는 2가 아니면 예외 발생")
    void whenExitingIsNumberOneOrTwo() {
        //given
        String userSelectedNumbers = "3";

        //then
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayerInputValueExceptions.whenExitingIsNumberOneOrTwo(userSelectedNumbers); //when
        });
        assertEquals("1 또는 2만 입력하세요", exception.getMessage());
    }

}