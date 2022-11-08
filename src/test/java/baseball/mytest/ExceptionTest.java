package baseball.mytest;

import baseball.Exceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {

    @Test
    void 통합_예외처리_테스트() {
        String invalidLengthInput = "1234";
        String notNumeralInput = "12a";
        String unUniqueInput = "121";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Exceptions.isValidInputUserNums(invalidLengthInput));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Exceptions.isValidInputUserNums(notNumeralInput));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Exceptions.isValidInputUserNums(unUniqueInput));
    }

    @Test
    void 입력값_길이_예외처리_메시지_테스트() {
        String invalidLengthInput = "1234";
        assertThatThrownBy(() -> Exceptions.isValidInputUserNums(invalidLengthInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력하신 값의 길이가 3이 아닙니다.");

    }

    @Test
    void 숫자가_아닌_입력값_예외처리_메시지_테스트() {
        String notNumeralInput = "12a";
        assertThatThrownBy(() -> Exceptions.isValidInputUserNums(notNumeralInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력하신 값이 숫자가 아닙니다. 프로그램을 종료합니다.");

    }

    @Test
    void 중복된_숫자_입력값_예외처리_메시지_테스트() {
        String unUniqueInput = "121";
        assertThatThrownBy(() -> Exceptions.isValidInputUserNums(unUniqueInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 값을 입력하셨습니다. 프로그램을 종료합니다.");

    }

    @Test
    void 잘못된_재게임_입력값_예외처리_테스트1() {
        String reGameAnswer = "3";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Exceptions.isValidReGameAnswer(reGameAnswer));
    }

    @Test
    void 잘못된_재게임_입력값_예외처리_테스트2() {
        String reGameAnswer = "a";
        assertThatThrownBy(() -> Exceptions.isValidReGameAnswer(reGameAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 재게임 입력입니다. 프로그램을 종료합니다.");
    }

    @Test
    void 잘못된_재게임_입력값_예외처리_메시지_테스트() {
        String reGameAnswer = "3";
        assertThatThrownBy(() -> Exceptions.isValidReGameAnswer(reGameAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 재게임 입력입니다. 프로그램을 종료합니다.");
    }
}
