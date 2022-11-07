package baseball;

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
    void 동일한_인풋값이_두번_들어온_경우_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("115"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 서로다른_랜덤_숫자_생성_테스트() {
        int[] randomNumber = RandomUtil.createRandomComputerNumbers();
        assertThat(randomNumber[0]).isNotEqualTo(randomNumber[1]).isNotEqualTo(randomNumber[2]);
    }
    @Test
    void 게임실행_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "789", "123", "2");
                    assertThat(output()).contains("낫싱", "낫싱", "3스트라이크", "게임 종료");
                },
                1, 2, 3
        );
    }
    @Test
    void 문자열_입력이_들어온_경우_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("S12"))
                            .isInstanceOf(IllegalArgumentException.class);
                }, 1, 2, 3
        );
    }
    @Test
    void 두개의_입력만_들어온_경우_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("11"))
                            .isInstanceOf(IllegalArgumentException.class);
                }, 1, 2, 3
        );
    }
}
