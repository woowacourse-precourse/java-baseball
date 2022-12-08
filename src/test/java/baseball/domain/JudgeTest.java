package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class JudgeTest {

    Answer computer = new Answer(List.of(1, 2, 3));

    Judge judge = new Judge(computer);

    @Nested
    class getScoreBoard_메소드는_Answer를_인자로받아_ScoreBoard를_반환한다 {

        @Test
        void 결과값은_3스트라이크() {
            Answer userBy_3S = new Answer(List.of(1, 2, 3));
            ScoreBoard scoreBoard = judge.getScoreBoard(userBy_3S);
            ScoreBoard expected = new ScoreBoard(0, 3);

            Assertions.assertThat(scoreBoard.equals(expected)).isTrue();
        }

        @Test
        void 기대값은_1볼_1스트라이크() {
            Answer userBy_1S_1B = new Answer(List.of(2, 4, 3));
            ScoreBoard scoreBoard = judge.getScoreBoard(userBy_1S_1B);
            ScoreBoard expected = new ScoreBoard(1, 1);

            Assertions.assertThat(scoreBoard.equals(expected)).isTrue();
        }

        @Test
        void 기대값은_2볼() {
            Answer userBy_2B = new Answer(List.of(2, 3, 4));
            ScoreBoard scoreBoard = judge.getScoreBoard(userBy_2B);
            ScoreBoard expected = new ScoreBoard(2, 0);

            Assertions.assertThat(scoreBoard.equals(expected)).isTrue();
        }
    }

}