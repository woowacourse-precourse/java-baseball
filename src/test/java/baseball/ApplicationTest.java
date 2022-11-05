package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.Application.generateOpponentNumber;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void generateOpponentNumber_메서드의_리턴_값은_세_자리_수() {
        int opponentNumber = generateOpponentNumber();

        int length = (int) (Math.log10(opponentNumber) + 1);
        assertThat(length).isEqualTo(3);
    }

    @Test
    void generateOpponentNumber_메서드의_리턴_값의_각_숫자는_1부터_9까지의_숫자로_구성() {
        int opponentNumber = generateOpponentNumber();

        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        while (opponentNumber != 0) {
            int digit = opponentNumber % 10;
            assertThat(numList).contains(digit);
            opponentNumber /= 10;
        }
    }

    @Test
    void generateOpponentNumber_메서드의_리턴_값의_각_숫자는_중복되지_않음() {
        int opponentNumber = generateOpponentNumber();

        List<Integer> numList = new ArrayList<>();

        while (opponentNumber != 0) {
            int digit = opponentNumber % 10;
            assertThat(numList).doesNotContain(digit);
            numList.add(digit);
            opponentNumber /= 10;
        }
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
