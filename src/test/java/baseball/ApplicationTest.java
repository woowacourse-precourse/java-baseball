package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.*;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 예외_테스트_영어() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("sky"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_한글() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("다람쥐"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_특수문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("?#$"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("131"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자비교_스트라이크(){
        List<Integer> computerNum = Arrays.asList(1, 2, 3);
        String myNum = "123";
        int myIdx = 1;
        List<Integer> result = Arrays.asList(0, 1);
        assertThat(Application.compareNumber(computerNum, myNum, myIdx)).isEqualTo(result);
    }

    @Test
    void 숫자비교_볼(){
        List<Integer> computerNum = Arrays.asList(2, 1, 3);
        String myNum = "123";
        int myIdx = 1;
        List<Integer> result = Arrays.asList(1, 0);
        assertThat(Application.compareNumber(computerNum, myNum, myIdx)).isEqualTo(result);
    }






    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
