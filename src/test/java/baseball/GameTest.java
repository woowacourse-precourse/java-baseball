package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest extends NsTest {
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    public Game makeGameInstance() {
        return new Game();
    }

    @Test
    void 게임_안내_문구_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "2");
                    assertThat(output())
                            .contains("숫자 야구 게임을 시작합니다.", "숫자를 입력해주세요 : ", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 스트라이크_테스트_1() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "145";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("1스트라이크");
    }

    @Test
    void 스트라이크_테스트_2() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "125";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("2스트라이크");
    }

    @Test
    void 스트라이크_테스트_3() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "123";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("3스트라이크");
    }

    @Test
    void 볼_테스트_1() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "345";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("1볼");
    }

    @Test
    void 볼_테스트_2() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "315";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("2볼");
    }

    @Test
    void 볼_테스트_3() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "312";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("3볼");
    }

    @Test
    void 볼_스트라이크_테스트_3() {
        String gamePlayerInput = "382";
        String computerRandomNumbers = "328";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("2볼 1스트라이크");
    }

    @Test
    void 낫싱_테스트() {
        String gamePlayerInput = "123";
        String computerRandomNumbers = "456";

        assertThat(makeGameInstance().getResult(computerRandomNumbers, gamePlayerInput)).contains("낫싱");
    }

}
