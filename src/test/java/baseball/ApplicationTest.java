package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 입력_예외테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void checkBall_인덱스에_해당하는_값이_볼이면_1반환_아니면_0반환() {
        int index = 0;
        int value = 2;
        List<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
        int ballCount = baseball.Application.checkBall(index, value, computer);

        assertThat(ballCount).isEqualTo(1);
    }

    @Test
    void checkBall_case2() {
        int index = 0;
        int value = 4;
        List<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
        int ballCount = baseball.Application.checkBall(index, value, computer);

        assertThat(ballCount).isEqualTo(0);
    }

    @Test
    void checkStrike_인덱스에_해당하는_값이_스트라이크이면_1반환_아니면_0반환() {
        int index = 0;
        int value = 1;
        List<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
        int strikeCount = baseball.Application.checkStrike(index, value, computer);

        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void checkStrike_case2() {
        int index = 2;
        int value = 1;
        List<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));
        int strikeCount = baseball.Application.checkStrike(index, value, computer);

        assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    void getResult_입력과_랜덤생성_수를_이용하여_숫자야구_게임의_결과를_반환() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));

        HashMap<String, Integer> expect = new HashMap<>() {{
            put("strike", 1);
            put("ball", 1);
        }};
        HashMap<String, Integer> result = baseball.Application.getResult(input, computer);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void getResult_case2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));

        HashMap<String, Integer> expect = new HashMap<>() {{
            put("strike", 3);
            put("ball", 0);
        }};
        HashMap<String, Integer> result = baseball.Application.getResult(input, computer);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void getResult_case3() {
        List<Integer> input = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> computer = new ArrayList<>(Arrays.asList(1, 2, 3));

        HashMap<String, Integer> expect = new HashMap<>() {{
            put("strike", 0);
            put("ball", 0);
        }};
        HashMap<String, Integer> result = baseball.Application.getResult(input, computer);

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void isPlay_게임을_새로_시작하려면_1반환() {
        String input = "1";
        boolean isPlay = Application.isPlay(input);

        assertThat(isPlay).isEqualTo(true);
    }
    @Test
    void isPlay_게임을_종료하려면_2를_반환() {
        String input = "2";
        boolean isPlay = Application.isPlay(input);

        assertThat(isPlay).isEqualTo(false);
    }
    @Test
    void isPlay_잘못된_입력() {
        assertThrows(IllegalArgumentException.class,() ->{
            String input = "abc";
            boolean isPlay = Application.isPlay(input);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
