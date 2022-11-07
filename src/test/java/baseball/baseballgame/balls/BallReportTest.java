package baseball.baseballgame.balls;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BallReportTest {

    @Test
    void add() {
        BallReport ballReport1 = new BallReport();
        ballReport1.add(JudgementType.STRIKE);
        ballReport1.add(JudgementType.STRIKE);

        BallReport ballReport2 = new BallReport();
        ballReport2.add(JudgementType.STRIKE, 2);

        assertThat(ballReport1).isEqualTo(ballReport2);
    }

    @Test
    void type_count() {
        BallReport ballReport1 = new BallReport();
        ballReport1.add(JudgementType.STRIKE);
        ballReport1.add(JudgementType.BALL);

        assertThat(ballReport1.reportToList()).isEqualTo(List.of(1, 1, 0));

        BallReport ballReport2 = new BallReport();
        ballReport2.add(JudgementType.STRIKE, 3);

        assertThat(ballReport2.reportToList()).isEqualTo(List.of(3, 0, 0));
    }
}
