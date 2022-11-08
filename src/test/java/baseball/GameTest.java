package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    void computerSelectNumbers_컴퓨터가_1에서_9까지_서로_다른_임의의_수_3개_선택(){
        assertThat(Game.computerSelectNumbers())
                .isInstanceOf(List.class)
                .hasSize(Game.ANSWER_SIZE)
                .doesNotHaveDuplicates()
                .map(num -> assertThat(num).isBetween(Game.MIN_NUMBER_OF_ANSWER, Game.MAX_NUMBER_OF_ANSWER));
    }

    @Test
    void getBallStrikeCnt_볼_스트라이크_개수를_리스트로_반환(){
        Game game = new Game(List.of(1, 2, 3));
        List<List<Integer>> playerInput = List.of(
                List.of(1, 2, 3),
                List.of(1, 5, 3),
                List.of(3, 1 ,2),
                List.of(3, 2, 1),
                List.of(9, 8, 7)
        );
        List<List<Integer>> expectedOutput = List.of(
                List.of(0, 3),
                List.of(0, 2),
                List.of(3, 0),
                List.of(2, 1),
                List.of(0, 0)
        );

        List<List<Integer>> realOutput = playerInput.stream()
                .map(input -> game.getBallStrikeResult(input))
                .collect(Collectors.toList());

        assertThat(expectedOutput).isEqualTo(realOutput);

    }
}
