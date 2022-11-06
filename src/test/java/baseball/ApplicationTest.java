package baseball;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.GameNumberCalculatorService;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
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
    void 숫자_길이초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자이외의_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_중복_값_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 컴퓨터_랜덤번호생성_테스트() {
        // given
        Computer computer = new Computer();

        // when
        computer.setupGameNumbers();

        // then
        assertThat(computer.getComputerGameNumbers().size()).isEqualTo(3);
    }

    @Test
    void 유저_입력값_생성_테스트() {
        // given
        User user = new User();
        List<Integer> userInputNumbers = List.of(1, 2, 3);
        final int PERMITTED_LENGTH = 3;

        // when
        user.setUserGameNumbers(userInputNumbers);

        // then
        assertThat(user.getUserGameNumbers().size()).isEqualTo(PERMITTED_LENGTH);
    }

    @Test
    void 스트라이크_값_얻기_테스트() {
        // given
        GameNumberCalculatorService gameNumberCalculatorService = new GameNumberCalculatorService();
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers = List.of(1, 2, 3);
        final int THREE_STRIKE = 3;

        // when
        int strikeCount = gameNumberCalculatorService.getStrikeCount(userNumbers, computerNumbers);

        // then
        assertThat(strikeCount).isEqualTo(THREE_STRIKE);
    }
}
