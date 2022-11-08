package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void createNumber_메서드로_값의_개수가_3개인지_판별() {
        List<Integer> computerCreateNumber = new ArrayList<>();
        createRandomNumber(computerCreateNumber);
        assertThat(computerCreateNumber.size()).isEqualTo(3);
    }

    @Test
    void inputUserNumber_메서드로_값을_입력_받을수_있는지_검증() {
        List<Integer> userInputNumber = new ArrayList<>();
        String input = "321";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        userInputNumber = inputUserNumber();
        List<Integer> expectResultInputNumber = new ArrayList<>();
        expectResultInputNumber.add(3);
        expectResultInputNumber.add(2);
        expectResultInputNumber.add(1);
        assertThat(userInputNumber.get(0)).isEqualTo(expectResultInputNumber.get(0));
        assertThat(userInputNumber.get(1)).isEqualTo(expectResultInputNumber.get(1));
        assertThat(userInputNumber.get(2)).isEqualTo(expectResultInputNumber.get(2));
    }

    @Test
    void numberBaseballGame_메서드로_스트라이크_볼_낫싱_개수_비교() {
        List<Integer> computerCreateNumber = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<Integer> userInputNumber = new ArrayList<>(Arrays.asList(3, 4, 2));
        List<Integer> userInputNumberNotMatch = new ArrayList<>(Arrays.asList(5, 6, 7));
        int matchStrike = numberBaseballGame(computerCreateNumber, userInputNumber);
        int notMatchStrike = numberBaseballGame(computerCreateNumber, userInputNumberNotMatch);
        assertThat(matchStrike).isEqualTo(1);
        assertThat(notMatchStrike).isEqualTo(0);
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
        main(new String[]{});
    }
}
