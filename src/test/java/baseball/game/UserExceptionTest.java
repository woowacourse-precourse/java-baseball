package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class UserExceptionTest {

    @Test
    @DisplayName("입력받은 값에 중복이 있는지 테스트")
    void isDuplicationTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        String userInputNumber = "133";
        Method isDuplication = UserException.class.getDeclaredMethod("isDuplication", String.class);
        isDuplication.setAccessible(true);

        // when
        boolean duplication = (boolean) isDuplication.invoke(UserException.class, userInputNumber);

        // then
        assertTrue(duplication);
    }

    @Test
    @DisplayName("입력받은 값의 길이가 3이 아닌지 테스트")
    void isNotLength3Test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        String userInputNumber = "1234";
        Method isNotLength3 = UserException.class.getDeclaredMethod("isNotLength3", String.class);
        isNotLength3.setAccessible(true);

        // when
        boolean overLength = (boolean) isNotLength3.invoke(UserException.class, userInputNumber);

        // then
        assertTrue(overLength);
    }

    @Test
    @DisplayName("입력받은 값이 숫자가 아닌지 테스트")
    void isNotIntTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        String userInputNumber = "가나다";
        Method isNotInt = UserException.class.getDeclaredMethod("isNotInt", String.class);
        isNotInt.setAccessible(true);

        // when
        boolean notInt = (boolean) isNotInt.invoke(UserException.class, userInputNumber);

        // then
        assertTrue(notInt);
    }

    @Test
    @DisplayName("입력받은 값에 0이 포함되는지 테스트")
    void isContainZeroTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        String userInputNumber = "103";
        Method isContainZero = UserException.class.getDeclaredMethod("isContainZero", String.class);
        isContainZero.setAccessible(true);

        // when
        boolean containZero = (boolean) isContainZero.invoke(UserException.class, userInputNumber);

        // then
        assertTrue(containZero);
    }

    @Test
    @DisplayName("게임을 시작할 때 입력받은 값이 예외를 잘 통과하는지 테스트")
    void userInputNoThrowExceptionTest() {
        // given
        String userInputNumber = "123";

        // when, then
        assertDoesNotThrow(() -> UserException.checkUserInputException(userInputNumber));
    }

    @Test
    @DisplayName("게임을 시작할 때 입력받은 값이 예외를 던지는지 테스트")
    void userInputExceptionTest() {
        // given
        String userInputNumber = "557";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> UserException.checkUserInputException(userInputNumber));
    }

    @Test
    @DisplayName("게임을 종료할 때 입력받는 값이 예외를 잘 통과하는지 테스트")
    void gameOverNoThrowExceptionTest() {
        // given
        String gameOverNumber = "2";

        // when, then
        assertDoesNotThrow(() -> UserException.checkGameOverException(gameOverNumber));
    }

    @Test
    @DisplayName("게임을 종료할 때 입력받는 값이 예외를 던지는지 테스트")
    void gameOverExceptionTest() {
        // given
        String gameOverNumber = "3";

        // when, then
        assertThrows(IllegalArgumentException.class ,() -> UserException.checkGameOverException(gameOverNumber));
    }

}
