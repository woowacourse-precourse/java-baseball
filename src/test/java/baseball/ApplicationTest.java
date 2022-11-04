package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Map;

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
    void 볼스트라이크스코어1스트라이크1볼(){
        Integer computerNumber = 583;
        Integer userNumber = 532;
        Map<String, Integer> score = Application.score(computerNumber, userNumber);
        assertThat(score.get(Application.StringConst.STRIKE)).isEqualTo(1);
        assertThat(score.get(Application.StringConst.BALL)).isEqualTo(1);
    }

    @Test
    void 볼스트라이크스코어0스트라이크3볼(){
        Integer computerNumber = 123;
        Integer userNumber = 231;
        Map<String, Integer> score = Application.score(computerNumber, userNumber);
        assertThat(score.get(Application.StringConst.STRIKE)).isEqualTo(0);
        assertThat(score.get(Application.StringConst.BALL)).isEqualTo(3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
