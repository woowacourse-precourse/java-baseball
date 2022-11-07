package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class UserTest {

    User user = new User();

    @Test
    @DisplayName("사용자의 컴퓨터 수 추측")
    void testGuessComputerNumbers() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String userEnteredValues = "123";
            when(Console.readLine()).thenReturn(userEnteredValues);

            user.guessComputerNumbers();

            List<Integer> nums = List.of(1, 2, 3);
            assertThat(user.getVerifiedValueList()).hasSize(3)
                    .isEqualTo(nums);
        }
    }

    @Test
    @DisplayName("중복되는 수 입력 시 예외처리")
    void testCheckEnteredValuesOverlap() {
        String testUserEnteredValues = "133";

        assertThatThrownBy(() -> user.checkEnteredValuesOverlap(testUserEnteredValues))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 수는 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("세자리 숫자가 입력되지 않을 시 예외처리")
    void testCheckEnteredValuesLength() {
        String testUserEnteredValues = "12";

        assertThatThrownBy(() -> user.checkEnteredValuesLength(testUserEnteredValues))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리 숫자가 입력 되어야 합니다.");
    }

    @Test
    @DisplayName("1에서 9까지의 숫자가 아닌 값이 입력될 시 예외처리")
    void testCheckEnteredValueIsNum() {
        Character testEnteredValue = 'a';

        assertThatThrownBy(() -> user.checkEnteredValueIsNum(testEnteredValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1에서 9까지의 숫자가 아닌 값이 입력 되었습니다.");
    }

    @Test
    @DisplayName("사용자가 입력한 수 초기화")
    void testInit() {
        user.init();

        assertThat(user.getVerifiedValueList()).isEmpty();
    }

    @Test
    @DisplayName("게임 종료 코드 입력")
    void testIsEndGame() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testExitCode = "1";
            when(Console.readLine()).thenReturn(testExitCode);

            user.isEndGame();

            assertThat(user.isEndGame()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("게임 종료 코드 이외의 값 입력될 시 예외처리")
    void testIsEndGameException() {
        try (MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class)) {
            String testExitCode = "3";
            when(Console.readLine()).thenReturn(testExitCode);

            assertThatThrownBy(() -> user.isEndGame())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1 또는 2를 입력하세요.");
        }
    }

}
