package baseball.baseballgame.balls;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.balls.BallReport;
import baseball.model.balls.JudgementType;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BallReportTest {

    @Test
    void type_count() {
        BallReport ballReport1 = new BallReport();
        ballReport1.add(JudgementType.STRIKE);
        ballReport1.add(JudgementType.BALL);

        assertThat(ballReport1.reportToList()).isEqualTo(List.of(1, 1, 0));

        ballReport1.add(JudgementType.STRIKE);

        assertThat(ballReport1.reportToList()).isEqualTo(List.of(2, 1, 0));
    }
}
