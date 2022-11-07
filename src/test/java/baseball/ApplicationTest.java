package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    void 중복_숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("133"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("13*2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void changeStringToIntegerListTest() {
        List<Integer> opponent = new ArrayList<>(Arrays.asList(1,3,2));
        String numberString = "123";
        List<Integer> integerList = Application.changeStringToIntegerList(numberString);

        assertThat(integerList).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    void checkOpponentAndPlayerTest() {
        List<Integer> opponent = new ArrayList<>(Arrays.asList(1,3,2));
        List<Integer> player = new ArrayList<>(Arrays.asList(1,3,5));

        List<Integer> ballAndStrike = Application.checkOpponentAndPlayer(opponent,player);

        assertThat(ballAndStrike).isEqualTo(Arrays.asList(0,2));
    }

    @Test
    void printBallAndStrikeTest() {
        Application.printBallAndStrike(Arrays.asList(1,1));
        Application.printBallAndStrike(Arrays.asList(3,0));
        Application.printBallAndStrike(Arrays.asList(0,3));

        assertThat(output()).contains("1볼 1스트라이크","3볼","3스트라이크");
    }

    @Test
    void checkGameOverTest() {
        Application.checkGameOver(Arrays.asList(0,1));
        Application.checkGameOver(Arrays.asList(2,2));
        Application.checkGameOver(Arrays.asList(0,3));

        assertThat(output()).contains("1스트라이크","2볼 2스트라이크","3스트라이크","3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
