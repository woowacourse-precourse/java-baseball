package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("컴퓨터 랜덤 숫자 사이즈 테스트")
    void computerRandomNumberTest() {
        List<Integer> computerNumbers = ComputerNumber.generateRandomNumber();
        assertThat(3).isEqualTo(computerNumbers.size());
    }

    @Test
    @DisplayName("유저 숫자 테스트")
    void userNumberTest() {
        UserNumber userNumber = new UserNumber("123");
        List<Integer> userNumbers = userNumber.getUserNumbers();
        assertThat(3).isEqualTo(userNumbers.size());
    }

    @Test
    @DisplayName("볼 개수 테스트")
    void ballCountTest() {
        NumberCheck numberCheck = new NumberCheck();
        UserNumber userNumbers = new UserNumber("123");
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(3, 1, 2));
        numberCheck.checkLocationNumbers(userNumbers, computerNumbers);
        assertThat(3).isEqualTo(3);
    }

    @Test
    @DisplayName("스트라이크 개수 테스트")
    void strikeCountTest() {
        NumberCheck numberCheck = new NumberCheck();
        UserNumber userNumbers = new UserNumber("123");
        List<Integer> computerNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        numberCheck.checkLocationNumbers(userNumbers, computerNumbers);
        assertThat(3).isEqualTo(3);
    }

    @Test
    @DisplayName("입력이 공백인 경우 테스트")
    void validateBlankTest() {
        String input = "   ";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력에 공백이 포함되어있습니다.");
    }

    @Test
    @DisplayName("입력이 3개보다 작을 경우 테스트")
    void validateMinLengthTest() {
        String input = "12";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력해야 할 숫자가 3개보다 작습니다.");
    }

    @Test
    @DisplayName("입력이 3개보다 큰 경우 테스트")
    void validateMaxLengthTest() {
        String input = "1234";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력해야 할 숫자가 3개보다 많습니다.");
    }

    @Test
    @DisplayName("입력에 중복이 포함되어 있을 경우 테스트")
    void validateOverlapTest() {
        String input = "112";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복 숫자가 포함되어있습니다.");
    }

    @Test
    @DisplayName("입력해야 할 숫자가 범위를 벗어 난 경우 테스트")
    void validateNumberRangeTest() {
        String input = "102";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 숫자가 1~9 범위를 벗어났습니다.");
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(() -> {
            run("246", "135", "1", "597", "589", "2");
            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
        }, 1, 3, 5, 5, 8, 9);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
