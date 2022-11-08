package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GameTest {
    @Test
    void getComputerRandomNumber_메서드로_서로_다른_3자리_수_반환() {
        Player computer = new Player();
        List<Integer> numbers = computer.getComputerRandomNumber();

        assertAll(
                () -> assertThat(numbers.size()).isEqualTo(3),
                () -> assertThat(numbers).allMatch(number -> number >= 1 && number <= 9),
                () -> assertThat(numbers.size()).isEqualTo(numbers.stream().distinct().count())
        );
    }

    @Test
    void getGameScore_매서드로_ball_과_strike_개수_리스트_반환() {
        List<Integer> computerNumber = new ArrayList<>(Arrays.asList(1, 2, 3));

        List<Integer> nothing1 = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> nothing2 = new ArrayList<>(Arrays.asList(7, 8, 9));

        List<Integer> oneBall = new ArrayList<>(Arrays.asList(2, 5, 6));
        List<Integer> twoBall = new ArrayList<>(Arrays.asList(2, 3, 6));
        List<Integer> threeBall = new ArrayList<>(Arrays.asList(2, 3, 1));

        List<Integer> oneStrike = new ArrayList<>(Arrays.asList(1, 7, 5));
        List<Integer> twoStrike = new ArrayList<>(Arrays.asList(1, 7, 3));
        List<Integer> threeStrike = new ArrayList<>(Arrays.asList(1, 2, 3));

        List<Integer> oneBallOneStrike = new ArrayList<>(Arrays.asList(1, 3, 6));
        List<Integer> twoBallOneStrike = new ArrayList<>(Arrays.asList(1, 3, 2));

        assertAll(
                () -> assertThat(GameScore.getGameScore(nothing1, computerNumber)).containsExactly(0, 0),
                () -> assertThat(GameScore.getGameScore(nothing2, computerNumber)).containsExactly(0, 0),
                () -> assertThat(GameScore.getGameScore(oneBall, computerNumber)).containsExactly(1, 0),
                () -> assertThat(GameScore.getGameScore(twoBall, computerNumber)).containsExactly(2, 0),
                () -> assertThat(GameScore.getGameScore(threeBall, computerNumber)).containsExactly(3, 0),
                () -> assertThat(GameScore.getGameScore(oneStrike, computerNumber)).containsExactly(0, 1),
                () -> assertThat(GameScore.getGameScore(twoStrike, computerNumber)).containsExactly(0, 2),
                () -> assertThat(GameScore.getGameScore(threeStrike, computerNumber)).containsExactly(0, 3),
                () -> assertThat(GameScore.getGameScore(oneBallOneStrike, computerNumber)).containsExactly(1, 1),
                () -> assertThat(GameScore.getGameScore(twoBallOneStrike, computerNumber)).containsExactly(2, 1)

        );
    }

    @Test
    void getGameResult_매서드로_게임결과_반환() {
        String nothing = "낫싱";

        String oneBall = "1볼";
        String twoBall = "2볼";
        String threeBall = "3볼";


        String oneStrike = "1스트라이크";
        String twoStrike = "2스트라이크";
        String threeStrike = "3스트라이크";

        String oneBallOneStrike = "1볼 1스트라이크";
        String twoBallOneStrike = "2볼 1스트라이크";

        assertAll(
                () -> assertThat(GameScore.getGameResult(0, 0)).isEqualTo(nothing),
                () -> assertThat(GameScore.getGameResult(1, 0)).isEqualTo(oneBall),
                () -> assertThat(GameScore.getGameResult(2, 0)).isEqualTo(twoBall),
                () -> assertThat(GameScore.getGameResult(3, 0)).isEqualTo(threeBall),
                () -> assertThat(GameScore.getGameResult(0, 1)).isEqualTo(oneStrike),
                () -> assertThat(GameScore.getGameResult(0, 2)).isEqualTo(twoStrike),
                () -> assertThat(GameScore.getGameResult(0, 3)).isEqualTo(threeStrike),
                () -> assertThat(GameScore.getGameResult(1, 1)).isEqualTo(oneBallOneStrike),
                () -> assertThat(GameScore.getGameResult(2, 1)).isEqualTo(twoBallOneStrike)
        );
    }

    @Test
    void checkThreeStrike_메서드_3스트라이크_이면_true_반환() {
        Game game = new Game();

        assertThat(game.checkThreeStrike("3스트라이크")).isEqualTo(true);
    }
}
