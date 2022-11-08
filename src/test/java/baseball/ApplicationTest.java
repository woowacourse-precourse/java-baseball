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
            String[] answer = input.split("");
            assertThat(answer.length).isEqualTo(3);
            assertThat(answer[0]).isNotEqualTo(answer[1]);
            assertThat(answer[1]).isNotEqualTo(answer[2]);
            assertThat(answer[2]).isNotEqualTo(answer[0]);
            assertThat(answer).doesNotContain("0");
        }
    }

    @Test
    void 입력값_검사_true값_테스트(){

        String[] testArr = {"123","518","241","253","456"};
        for (String testStr: testArr) {
            assertThat(Application.inputValidator(testStr)).isEqualTo(true);
        }
    }
    @Test
    void 입력값_검사_false값_테스트(){

        String[] testArr = {"1a1", "aaa","1234","1111", "abc","106","045"};
        for (String testStr: testArr) {
            assertThatIllegalArgumentException().isThrownBy(()-> Application.inputValidator(testStr));
        }
    }

    @Test
    void 볼_스트라이크_검사함수_테스트(){

        assertThat(Application.compareInput("123", "124")).isEqualTo("2스트라이크");
        assertThat(Application.compareInput("123", "143")).isEqualTo("2스트라이크");
        assertThat(Application.compareInput("123", "341")).isEqualTo("2볼");
        assertThat(Application.compareInput("123", "781")).isEqualTo("1볼");
        assertThat(Application.compareInput("123", "213")).isEqualTo("2볼 1스트라이크");
        assertThat(Application.compareInput("123", "132")).isEqualTo("2볼 1스트라이크");
        assertThat(Application.compareInput("123", "456")).isEqualTo("낫싱");
        assertThat(Application.compareInput("123", "789")).isEqualTo("낫싱");

    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
