package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("중복없이 랜덤숫자 3개 뽑기")
    void 중복없이_랜덤숫자_3개_뽑기() {
        int count = 3;
        Numbers numbers = new NumbersGenerator().generate(count);
        List<Integer> answer = numbers.getNumbers();

        assertThat(answer.stream().distinct().count()).isEqualTo(count);
    }

    @Test
    @DisplayName("사용자 입력값이 3자리 수보다 큰 경우 예외 발생")
    void 사용자_입력값이_3자리보다_클_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("사용자 입력값이 3자리 수보다 작은 경우 예외 발생")
    void 사용자_입력값이_3자리보다_작을_때_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("사용자 입력값에 0포함인 경우 예외 발생")
    void 사용자_입력값에_0포함인_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("사용자 입력값 중복포함인 경우 예외 발생")
    void 사용자_입력값에_중복_포함인_경우_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("재시작이나 종료 외의 명령 선택 시 예외 발생")
    void 재시작이나_종료_외의_명령_선택_시_예외_발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> OrderType.getMenuType("3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("게임종료 후 재시작")
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
    @DisplayName("게임종료")
    void 게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
