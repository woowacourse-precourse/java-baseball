package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.junit.jupiter.api.Test;

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
    void 스트라이크_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("145", "124", "123", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                },
                1, 2, 3
        );
    }


    @Test
    void 볼_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("312", "132", "345", "235", "231", "256", "123", "2");
                    assertThat(output()).contains("3볼", "2볼", "1볼");
                },
                1, 2, 3
        );
    }

    @Test
    void 낫싱_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "123", "2");
                    assertThat(output()).contains("낫싱");
                },
                1, 2, 3
        );
    }

}
