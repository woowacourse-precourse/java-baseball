package study;

import baseball.PlayGame;
import baseball.PrepareGame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayGameTest {
    Integer[] examComputerNumber = {1, 3, 5};
    Integer[] examUserNumber = {3, 2, 5};
    List<Integer> computerNumberTest = new ArrayList<>(Arrays.asList(examComputerNumber));
    List<Integer> userNumberTest = new ArrayList<>(Arrays.asList(examUserNumber));

    PlayGame playGameTest = new PlayGame(computerNumberTest, userNumberTest);

    PrepareGame prepareGame = new PrepareGame();

    @Test
    void 볼_스트라이크_세는_기능() {
        List<Integer> answer = List.of(1, 1);

        assertThat(playGameTest.checkStrikeAndBallForTest()).isEqualTo(answer);
    }

    @Test
    void 볼_스트라이크_출력_테스트() {
        String answer = "1볼 2스트라이크";
        assertThat(playGameTest.outputResultForTest(1, 2)).isEqualTo(answer);
    }

    @Test
    void 볼_스트라이크_출력_테스트_낫싱() {
        String answer = "낫싱";
        assertThat(playGameTest.outputResultForTest(0, 0)).isEqualTo(answer);
    }

    @Test
    void 게임을_다시_시작할_경우_테스트() {
        assertThat(prepareGame.isGameExitForTest("1")).isEqualTo(true);
    }

    @Test
    void 게임을_종료할_경우_테스트() {
        assertThat(prepareGame.isGameExitForTest("2")).isEqualTo(false);
    }
}
