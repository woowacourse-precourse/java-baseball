package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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

    @Test
    void 랜덤숫자_길이확인() {
        Computer computer = new Computer();
        assertThat(computer.createAnswerString().length()).isEqualTo(3);
    }

    @Test
    void 랜덤숫자_랜덤확인() {
        Computer computer = new Computer();
        assertThat(computer.createAnswerString()).isNotEqualTo(computer.createAnswerString());
    }

    @Test
    void 낫싱_확인() {
        Computer result = new Computer();

        assertThat(result.getStatus("000"))
                .isEqualTo("낫싱");

    }

    @Test
    void 볼_갯수_3개_확인() {
        Computer result = new Computer();
        StringBuilder sb = new StringBuilder();

        sb.append(result.getAnswer().charAt(2))
                .append(result.getAnswer().charAt(0))
                .append(result.getAnswer().charAt(1));

        assertThat(result.countBall(sb.toString()))
                .isEqualTo(3);

    }

    @Test
    void 스트라이크_점수확인_3점() {
        Computer result = new Computer();

        assertThat(result.countStrike(result.getAnswer()))
                .isEqualTo(3);
    }

    @Test
    void 스트라이크3_3개_메세지_확인() {
        Computer result = new Computer();

        assertThat(result.getStatus(result.getAnswer()))
                .isEqualTo("3스트라이크");

    }

    @Test
    void 스트라이크_점수확인_0점() {
        Computer result = new Computer();

        assertThat(result.countStrike("000")).isEqualTo(0);

    }

    @Test
    void 볼_3개_메세지_확인() {
        Computer result = new Computer();
        StringBuilder sb = new StringBuilder();

        sb.append(result.getAnswer().charAt(2))
                .append(result.getAnswer().charAt(0))
                .append(result.getAnswer().charAt(1));

        assertThat(result.getStatus(sb.toString()))
                .isEqualTo("3볼");

    }

    @Test
    void 점수_확인_2볼_1스트라이크() {
        Computer result = new Computer();
        StringBuilder sb = new StringBuilder();

        sb.append(result.getAnswer().charAt(2))
                .append(result.getAnswer().charAt(1))
                .append(result.getAnswer().charAt(0));

        assertThat(result.getStatus(sb.toString()))
                .isEqualTo("2볼 1스트라이크");

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
