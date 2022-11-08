package baseball;

import baseball.model.Judge;
import baseball.model.Judgement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class JudgeTest{
    private Judge judge;

    @BeforeEach
    void setUp() {
        judge = new Judge();
    }

    @Test
    void 결과_판단() {
        List<Integer> quizNumber = List.of(7, 1, 3);
        List<Integer> userNumber = List.of(1, 2, 3);

        Judgement judgement = judge.doJudge(quizNumber, userNumber);
        assertThat(judgement.getBall()).isEqualTo(1);
        assertThat(judgement.getStrike()).isEqualTo(1);
    }
}
