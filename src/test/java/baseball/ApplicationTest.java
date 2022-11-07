package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void computerSelectNumbers_컴퓨터가_1에서_9까지_서로_다른_임의의_수_3개_선택(){
        assertThat(Game.computerSelectNumbers())
                .isInstanceOf(List.class)
                .hasSize(Game.ANSWER_SIZE)
                .doesNotHaveDuplicates()
                .map(num -> assertThat(num).isBetween(Game.MIN_NUMBER_OF_ANSWER, Game.MAX_NUMBER_OF_ANSWER));
    }

    @Test
    void isInputSizeEqualToAnswerSize_입력의_자리수가_게임정답의_자리수와_동일한_경우_참(){

        List<String> playerInput = List.of("123", "12");
        List<Boolean> expectedOutput = List.of(true, false);

        List<Boolean> realOutput = playerInput.stream()
                .map(input -> Player.isInputSizeEqualToAnswerSize(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
