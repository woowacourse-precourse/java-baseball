package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class HintTest extends NsTest {

    Hint hint = new Hint();

    @Test
    void countMatchingNumbers_정답과_답안_인덱스를_비교해_일치하는_숫자_개수_저장() {
        List<Integer> correctAnswer = List.of(1, 2, 3);
        List<Integer> userAnswer = List.of(1, 2, 6);

        hint.countMatchingNumbers(correctAnswer, userAnswer);

        assertThat(hint.matchingNumber).isEqualTo(2);
    }

    @Test
    void countIncludeNumbers_답안에_정답이_포함된_개수_저장() {
        List<Integer> correctAnswer = List.of(1, 2, 3);
        List<Integer> userAnswer = List.of(3, 2, 9);

        hint.countIncludedNumbers(correctAnswer, userAnswer);

        assertThat(hint.includedNumber).isEqualTo(2);
    }

    @Test
    void getHintOfStrike_일치개수가_0이_아니면_hint_변수에_개수와_스트라이크힌트_저장() {
        hint.matchingNumber = 2;

        hint.getHintOfStrike();
        hint.show();

        assertThat(output()).contains("2스트라이크");
    }

    @Test
    void getHintOfBall_포함개수_빼기_일치개수_hint_변수에_숫자와_볼힌트_저장() {
        hint.matchingNumber = 3;
        hint.includedNumber = 1;

        hint.getHintOfBall();
        hint.show();

        assertThat(output()).contains("2볼");
    }

    @Test
    void getHintOfStrike_getHintOfBall_볼과_스트라이크가_모두_0일때_hint_변수_공백유지() {
        Hint.hint = "";
        hint.matchingNumber = 0;
        hint.includedNumber = 0;

        hint.getHintOfBall();
        hint.getHintOfStrike();

        assertThat(Hint.hint).isEmpty();
    }

    @Test
    void getHintOfNothing_hint_문자열이_비어있을때_낫싱힌트_저장() {
        Hint.hint = "";
        hint.getHintOfNothing();

        assertThat(Hint.hint).contains("낫싱");
    }

    @Test
    void 볼() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("513", "413", "241", "135", "2");
                    assertThat(output()).contains("3볼", "2볼", "1볼");
                },
                1, 3, 5
        );
    }


    @Test
    void 볼스트라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("157", "315", "135", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "2볼 1스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 스트라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("178", "139", "135", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크");
                },
                1, 3, 5
        );
    }

    @Test
    void 낫싱() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("789", "826", "135", "2");
                    assertThat(output()).contains("낫싱");
                },
                1, 3, 5
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
