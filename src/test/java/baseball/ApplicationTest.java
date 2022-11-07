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
    Game game = new Game();
    @Test
    void randomPick_출력_size_동일한지_확인() {
        /*랜덤값이 나중에 들어오므로 테스트할 때마다 바뀐다. 그래서 given값과 size가 3으로 동일한지 확인*/
        /*given*/
        List<Integer> givenNumber = new ArrayList<>();
        givenNumber.add(1);
        givenNumber.add(2);
        givenNumber.add(3);

        /*when*/
        List<Integer> testGame = game.randomPick();

        /*then*/
        assertThat(testGame.size()).isEqualTo(givenNumber.size());
    }

    @Test
    void inputNumber() {
        /*given*/
        List<Integer> givenNumber = new ArrayList<>();
        givenNumber.add(2);
        givenNumber.add(4);
        givenNumber.add(6);

        /*when*/

        /*then*/
    }

    @Test
    void checkException() {
        /*given*/
        /*when*/
        /*then*/
    }

    @Test
    void strike() {
        /*given*/
        /*when*/
        /*then*/
    }

    @Test
    void ball() {
        /*given*/
        /*when*/
        /*then*/
    }

    @Test
    void counting() {
        /*given*/
        /*when*/
        /*then*/
    }

    @Test
    void allStrike() {
        /*given*/
        /*when*/
        /*then*/
    }

    @Test
    void answer() {
        /*given*/
        /*when*/
        /*then*/
    }
}
