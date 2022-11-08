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
    Game game = new Game();
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
    void strike() {
        /*given*/
        int strikeTest = 1;
        List<Integer> userInput = new ArrayList<>();
        userInput.add(1);
        userInput.add(2);
        userInput.add(3);
        List<Integer> computerInput = new ArrayList<>();
        computerInput.add(1);
        computerInput.add(5);
        computerInput.add(7);

        /*when*/
        int testOuput = game.strike(userInput, computerInput);

        /*then*/
        assertThat(testOuput).isEqualTo(strikeTest);
    }

    @Test
    void ball() {
        int ballTest = 1;
        List<Integer> userInput = new ArrayList<>();
        userInput.add(1);
        userInput.add(7);
        userInput.add(3);
        List<Integer> computerInput = new ArrayList<>();
        computerInput.add(1);
        computerInput.add(5);
        computerInput.add(7);

        /*when*/
        int testOuput = game.ball(userInput, computerInput);

        /*then*/
        assertThat(testOuput).isEqualTo(ballTest);
    }

    @Test
    void counting() {
        /*given*/
        String nothing = "낫싱";
        String strike = "3스트라이크";
        String ballStrike = "1볼 1스트라이크";

        /*when*/
        String nothingTest = game.counting(0, 0);
        String strikeTest = game.counting(3, 0);
        String ballStrikeTest = game.counting(1, 1);

        /*then*/
        assertThat(nothingTest).isEqualTo(nothing);
        assertThat(strikeTest).isEqualTo(strike);
        assertThat(ballStrikeTest).isEqualTo(ballStrike);
    }

    @Test
    void allStrike() {
        /*given*/
        String end = "게임종료";

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
