package baseball;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 컴퓨터숫자_랜덤_생성(){
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumber.setGameClearNumber();

        assertThat(computerNumber.getComputerNumber().length()).isEqualTo(3);
    }

    @Test
    void 숫자이외의_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumber.isDigitPlayerNumber("a23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_길이_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumber.isStringLengthCorrect("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_중복_값_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumber.isDifferentPlayerNumber("122"))
                        .isInstanceOf(IllegalArgumentException.class)
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
