package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 특정숫자_인덱스_체크() {
        List<Integer> userInputNumber = new ArrayList<>();
        userInputNumber.add(10);
        userInputNumber.add(20);
        userInputNumber.add(30);

        int numberIndex = BullsAndCows.findNumberIndex(userInputNumber, 20);
        assertThat(numberIndex).isEqualTo(1);
    }

    @Test
    void 특정숫자_인덱스_체크_특정숫자_없는_경우() {
        List<Integer> userInputNumber = new ArrayList<>();
        userInputNumber.add(10);
        userInputNumber.add(20);
        userInputNumber.add(30);

        int numberIndex = BullsAndCows.findNumberIndex(userInputNumber, 2);
        assertThat(numberIndex).isEqualTo(-1);
    }

}
