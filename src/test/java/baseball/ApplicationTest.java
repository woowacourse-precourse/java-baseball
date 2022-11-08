package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 입력_예외처리_메소드_테스트1() {
        String str = "1";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Application.handleException(str))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 스트라이크_볼_낫싱_판단_메소드_테스트1(){
        String expected = "3스트라이크";
        String solution = "123";
        List<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3));
        String result = Application.BaseBallJudge(answer,solution);
        assertThat(result).contains(expected);
    }
    @Test
    void 스트라이크_볼_낫싱_판단_메소드_테스트2(){
        String expected = "3볼";
        String solution = "312";
        List<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3));
        String result = Application.BaseBallJudge(answer,solution);
        assertThat(result).contains(expected);
    }

    @Test
    void 스트라이크_볼_낫싱_판단_메소드_테스트3(){
        String expected = "낫싱";
        String solution = "789";
        List<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3));
        String result = Application.BaseBallJudge(answer,solution);
        assertThat(result).contains(expected);
    }
    @Test
    void 스트라이크_볼_낫싱_판단_메소드_테스트4(){
        String expected = "1볼 1스트라이크";
        String solution = "152";
        List<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3));
        String result = Application.BaseBallJudge(answer,solution);
        assertThat(result).contains(expected);
    }
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
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
