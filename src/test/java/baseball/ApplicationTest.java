package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void 랜덤숫자_테스트(){
        for (int i = 0; i < 100; i++) {
            String input = Integer.toString(Application.createRandomNum());
            System.out.println(input);
            String[] answer = input.split("");
            assertThat(answer.length).isEqualTo(3);
            assertThat(answer[0]).isNotEqualTo(answer[1]);
            assertThat(answer[1]).isNotEqualTo(answer[2]);
            assertThat(answer[2]).isNotEqualTo(answer[0]);
            assertThat(answer).doesNotContain("0");
        }
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
