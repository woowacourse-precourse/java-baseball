package baseball;

import baseball.Domain.Game;
import baseball.View.Message;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

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
    void 스트라이크_볼_3스트라이크() {
        Integer[] randomArr = {1, 2, 3};
        Integer[] userArr = {1, 2, 3};
        ArrayList<Integer> randomList = new ArrayList<>(Arrays.asList(randomArr));
        ArrayList<Integer> userList = new ArrayList<>(Arrays.asList(userArr));

        Game game = new Game();
        game.answerNumber = randomList;
        game.calculateStrike(userList);
        game.calculateBall(userList);

        Message.printResultMessage(game.strike,game.ball);
        String resultMsg = "3스트라이크";

        assertThat(resultMsg).isEqualTo(output().toString());
    }

    @Test
    void 스트라이크_볼_1스트라이크_1볼() {
        Integer[] randomArr = {1, 2, 3};
        Integer[] userArr = {7, 2, 1};
        ArrayList<Integer> randomList = new ArrayList<>(Arrays.asList(randomArr));
        ArrayList<Integer> userList = new ArrayList<>(Arrays.asList(userArr));

        Game game = new Game();
        game.answerNumber = randomList;
        game.calculateStrike(userList);
        game.calculateBall(userList);

        Message.printResultMessage(game.strike,game.ball);
        String resultMsg = "1볼 1스트라이크";

        assertThat(resultMsg).isEqualTo(output().toString());
    }

    @Test
    void 스트라이크_볼_계산_낫싱() {
        Integer[] randomArr = {1, 2, 3};
        Integer[] userArr = {4, 5, 6};
        ArrayList<Integer> randomList = new ArrayList<>(Arrays.asList(randomArr));
        ArrayList<Integer> userList = new ArrayList<>(Arrays.asList(userArr));

        Game game = new Game();
        game.answerNumber = randomList;
        game.calculateStrike(userList);
        game.calculateBall(userList);

        Message.printResultMessage(game.strike,game.ball);
        String resultMsg = "낫싱";

        assertThat(resultMsg).isEqualTo(output().toString());
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
