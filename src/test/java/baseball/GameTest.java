package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class GameTest {
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
        Assertions.assertThat(testGame.size()).isEqualTo(givenNumber.size());
    }

    @Test
    void inputNumber() {
        /*given*/
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