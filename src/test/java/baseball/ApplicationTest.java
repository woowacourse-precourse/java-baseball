package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    /**
     * 정상 인풋 테스트
     * 1. 종료 후 재시작
     * 2. 종료
     *
     * 비정상 인풋 테스트
     * 1. 0 인풋
     * 2. 영어 인풋
     * 3. 한글 인풋
     * 4. 종료 후 재시작 시 비정상 인풋 발생
     * 5. 길이 3 초과
     * 6. 길이 3 미만
     * 7. 게임 종료 인풋 비정상
     */

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
    void 게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("153", "135", "2");
                    assertThat(output()).contains("2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 예외_테스트_길이_3_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임종료_후_재시작_비정상_인풋_발생() {
        try {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "23597", "589", "2");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );
        } catch (IllegalArgumentException E){
            System.out.println("비정상 인풋 발생");
        }
    }
    @Test
    void 게임종료_비정상_인풋_발생() {
        try {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "9");
                        assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );
        } catch (IllegalArgumentException E){
            System.out.println("비정상 인풋 발생");
        }
    }
    @Test
    void 예외_테스트_길이_3_미만() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("34"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0_넣기() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_한글_넣기() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12ㅁ"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_영어_넣기() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
