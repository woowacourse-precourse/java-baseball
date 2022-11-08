package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("랜덤 숫자 생성 확인")
    void createComputerRandomNumberTest(){
        List<Integer> test = ComputerRandomNumbersFactory.createComputerRandomNumber();
        assertThat(3).isEqualTo(test.size());
    }

    @Test
    @DisplayName("랜덤 숫자 범위 확인")
    void createComputerRandomNumberRangeTest() {
        List<Integer> test = ComputerRandomNumbersFactory.createComputerRandomNumber();
        assertThat(test.stream().allMatch(v -> v >= 1 && v <= 9)).isTrue();
    }

    @Test
    @DisplayName("몇개의 숫자가 같은지 확인")
    void count(){
        assertThat(3).isEqualTo(MatchCounter.countAllMatched(new UserNumber("123"), Arrays.asList(3,1,2)));
    }

    @Test
    @DisplayName("스트라이크 수 확인")
    void strike(){
        assertThat(1).isEqualTo(MatchCounter.countStrike(new UserNumber("324"),Arrays.asList(3,1,2)));
    }

    @Test
    @DisplayName("입력값에 공백이 포함되는 경우 확인")
    void validateBlankTest() {
        String input = " ";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값의 공백이 포함 되어있습니다.");
    }

    @Test
    @DisplayName("입력이 아무것도 없는 경우 확인")
    void validateEmptyTest() {
        String input = "";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력을 하지 않았습니다.");
    }

    @Test
    @DisplayName("입력 숫자의 갯수가 다를 경우 확인")
    void validateNumberCountTest() {
        String input = "1234";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 갯수가 다릅니다.");
    }

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우 확인")
    void validateNumberTest() {
        String input = "!@a";
        assertThatThrownBy(() -> new UserNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닙니다.");
    }

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
}
