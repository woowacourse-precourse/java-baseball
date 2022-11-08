package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    void 랜덤숫자_길이확인(){
    void 랜덤숫자_길이확인() {
        Util util = new Util();
        assertThat(util.createAnswerString().length()).isEqualTo(3);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    void 랜덤숫자_랜덤확인() {  
    void 랜덤숫자_랜덤확인() {
        Util util = new Util();
        assertThat(util.createAnswerString()).isNotEqualTo(util.createAnswerString());
    }

    @Test
    void 볼갯수확인() {
        Computer computer = new Computer("123");
        assertThat(computer.countBall("452")).isEqualTo(1);
        assertThat(computer.countBall("412")).isEqualTo(2);
        assertThat(computer.countBall("312")).isEqualTo(3);
    }

    @Test
    void 스트라이크갯수확인() {
        Computer computer = new Computer("123");
        assertThat(computer.countStrike("425")).isEqualTo(1);
        assertThat(computer.countStrike("143")).isEqualTo(2);
        assertThat(computer.countStrike("123")).isEqualTo(3);
    }

    @Test
    void 게임결과확인() {
        Computer computer = new Computer("123");
        assertThat(computer.getResult("425")).isEqualTo("1 스트라이크");
        assertThat(computer.getResult("123")).isEqualTo("3 스트라이크");
        assertThat(computer.getResult("321")).isEqualTo("2 볼 1 스트라이크");
        assertThat(computer.getResult("312")).isEqualTo("3 볼");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
