package baseball;

import baseball.game.ScoreBoard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreBoardTest {

    @Test
    void 스코어보드_점수측정_테스트(){
        ScoreBoard scoreBoard1 = new ScoreBoard();
        List<Integer> targetNumbers = Arrays.asList(1,2,3);
        List<Integer> attackNumbers = Arrays.asList(1,2,3);
        scoreBoard1.calculate(targetNumbers, attackNumbers);

        Assertions.assertThat(scoreBoard1.getScore()).isEqualTo(Arrays.asList(3,0));

        ScoreBoard scoreBoard2 = new ScoreBoard();
        List<Integer> targetNumbers2 = Arrays.asList(2,4,8);
        List<Integer> attackNumbers2 = Arrays.asList(4,6,8);
        scoreBoard2.calculate(targetNumbers2, attackNumbers2);

        Assertions.assertThat(scoreBoard2.getScore()).isEqualTo(Arrays.asList(1,1));

    }
}
