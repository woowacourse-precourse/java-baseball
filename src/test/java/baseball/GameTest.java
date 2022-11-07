package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void setAnswer_메서드_사용하면_answer가_서로_다른_3자리의_1에서_9의_숫자로_설정() {
        Game game = new Game();
        game.setAnswer();
        List<Integer> answer = game.getAnswer();
        Set<Integer> numberSet = new HashSet<>(answer);

        assertAll(
                () -> assertThat(answer.size()).isEqualTo(3),
                () -> assertThat(numberSet.size()).isEqualTo(3),
                () -> assertThat(answer).allMatch(number -> number >= 1 && number <= 9)
        );
    }

    @Test
    void getBallAndStrikeList_메서드_사용하면_ball과_strike의_개수_반환() {
        Game game = new Game();
        List<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> noBallThreeStrikeNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> twoBallOneStrikeNumber = new ArrayList<>(Arrays.asList(1, 3, 2));
        List<Integer> threeBallNoStrikeNumber = new ArrayList<>(Arrays.asList(3, 1, 2));
        List<Integer> noBallTwoStrikeNumber = new ArrayList<>(Arrays.asList(1, 2, 4));
        List<Integer> oneBallOneStrikeNumber = new ArrayList<>(Arrays.asList(1, 4, 2));
        List<Integer> twoBallNoStrikeNumber = new ArrayList<>(Arrays.asList(4, 1, 2));
        List<Integer> noBallOneStrikeNumber = new ArrayList<>(Arrays.asList(1, 4, 5));
        List<Integer> oneBallNoStrikeNumber = new ArrayList<>(Arrays.asList(4, 5, 1));
        List<Integer> noBallNoStrikeNumber = new ArrayList<>(Arrays.asList(4, 5, 6));

        assertAll(
                () -> assertThat(game.getBallAndStrikeList(answer, noBallThreeStrikeNumber)).containsExactly(0, 3),
                () -> assertThat(game.getBallAndStrikeList(answer, twoBallOneStrikeNumber)).containsExactly(2, 1),
                () -> assertThat(game.getBallAndStrikeList(answer, threeBallNoStrikeNumber)).containsExactly(3, 0),
                () -> assertThat(game.getBallAndStrikeList(answer, noBallTwoStrikeNumber)).containsExactly(0, 2),
                () -> assertThat(game.getBallAndStrikeList(answer, oneBallOneStrikeNumber)).containsExactly(1, 1),
                () -> assertThat(game.getBallAndStrikeList(answer, twoBallNoStrikeNumber)).containsExactly(2, 0),
                () -> assertThat(game.getBallAndStrikeList(answer, noBallOneStrikeNumber)).containsExactly(0, 1),
                () -> assertThat(game.getBallAndStrikeList(answer, oneBallNoStrikeNumber)).containsExactly(1, 0),
                () -> assertThat(game.getBallAndStrikeList(answer, noBallNoStrikeNumber)).containsExactly(0, 0)
        );
    }
}
