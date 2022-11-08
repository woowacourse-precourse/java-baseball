package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.Application.*;
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

    @Test
    void 세자리_숫자_확인(){
        List<Integer> computerNumber = makeRandom();
        Assertions.assertThat(makeRandom().size()).isEqualTo(3);
    }

    @Test
    void 쓰리_스트라이크(){
        List<Integer> userNumber = List.of(1,2,3);
        List<Integer> computerNumber = List.of(1,2,3);
        Assertions.assertThat(countBallAndStrike(userNumber, computerNumber).get("strike")).isEqualTo(3);
    }

    @Test
    void 원_스트라이크(){
        List<Integer> userNumber = List.of(1,2,3);
        List<Integer> computerNumber = List.of(1,4,7);
        Assertions.assertThat(countBallAndStrike(userNumber, computerNumber).get("strike")).isEqualTo(1);
    }

    @Test
    void 볼(){
        List<Integer> userNumber = List.of(1,2,3);
        List<Integer> computerNumber = List.of(3,4,5);
        Assertions.assertThat(countBallAndStrike(userNumber, computerNumber).get("ball")).isEqualTo(1);
    }

    @Test
    void 볼_스트라이크(){
        List<Integer> userNumber = List.of(1,2,3);
        List<Integer> computerNumber = List.of(3,2,5);
        Assertions.assertThat(countBallAndStrike(userNumber, computerNumber).get("strike")).isEqualTo(1);
        Assertions.assertThat(countBallAndStrike(userNumber, computerNumber).get("ball")).isEqualTo(1);
    }

    @Test
    void 낫싱(){
        List<Integer> userNumber = List.of(1,2,3);
        List<Integer> computerNumber = List.of(4,5,6);
        Assertions.assertThat(countBallAndStrike(userNumber, computerNumber).get("strike")).isEqualTo(0);
        Assertions.assertThat(countBallAndStrike(userNumber, computerNumber).get("ball")).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
