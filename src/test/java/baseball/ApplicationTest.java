package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.Application.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName("랜덤으로 설정한 숫자는 3자리 수이고 각 자리 숫자는 1과 9사이다")
    void getRandomNumberTest() {
        String number = getRandomNumber();
        assertThat(number.length()).isEqualTo(3);
        assertThat(number.matches("[1-9][1-9][1-9]")).isEqualTo(true);

    }

    @Test
    @DisplayName("각 자리가 숫자이면서 1과 9사이의 숫자인지")
    void isNumericTest() {
        String string1 = "135";
        boolean result1 = true;
        assertThat(isNumeric(string1)).isEqualTo(result1);
        String string2 = "1-3";
        boolean result2 = false;
        assertThat(isNumeric(string2)).isEqualTo(result2);
        String string3 = "102";
        boolean result3 = false;
        assertThat(isNumeric(string3)).isEqualTo(result3);
    }

    @Test
    @DisplayName("각 자리 숫자에 중복이 있는지")
    void isDuplicateTest() {
        String string1 = "113";
        boolean result1 = true;
        assertThat(isDuplicate(string1)).isEqualTo(result1);
        String string2 = "987";
        boolean result2 = false;
        assertThat(isDuplicate(string2)).isEqualTo(result2);
    }

    @Test
    @DisplayName("유효하지 않은 숫자에 대해 예외 처리를 잘 하는지")
    void validateNumberExceptionTest() {
        List<String> userInputList = Arrays.asList("9873", "1121", "--1");
        for (int i = 0; i < 3; i++) {
            String userInput = userInputList.get(i);
            assertThatIllegalArgumentException().isThrownBy(() ->
                    validateNumber(userInput));
        }
    }

    @Test
    @DisplayName("두 수를 비교했을 때 스크라이크와 볼 개수를 잘 세는지")
    void getStrikeAndBallTest() {
        List<String> computer = Arrays.asList("987", "123");
        List<String> user = Arrays.asList("987", "321");
        int[][] results = {{3, 0}, {1, 2}};
        for (int iter = 0; iter < 2; iter++) {
            assertThat(getStrikeAndBall(computer.get(iter), user.get(iter)).equals(results[iter]));
        }
    }

    @Test
    @DisplayName("1과 2가 아닌 값을 입력했을 때 예외 처리를 잘 하는지")
    void validateRestartOrEndExceptionTest() {
        List<String> userInputList = Arrays.asList("0", "12", " ");
        for (int i = 0; i < 3; i++) {
            String userInput = userInputList.get(i);
            assertThatIllegalArgumentException().isThrownBy(() ->
                    validateRestartOrEnd(userInput));
        }
    }
}
