package baseball.testcase;

import baseball.decision.DecisionMaker;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

public class DecisionMakerTest extends NsTest {

    DecisionMaker decisionMaker = new DecisionMaker();

    @DisplayName("유저가 재 진행을 원할 경우 Play라는 의사 결정을 반환한다")
    @Test
    void Play_의사결정_반환_테스트() {
        command("1");
        assertThat(decisionMaker.getDecision()).isEqualTo("Play");
    }

    @DisplayName("유저가 종료를 원할 경우 Stop라는 의사 결정을 반환한다")
    @Test
    void Stop_의사결정_반환_테스트() {
        command("2");
        assertThat(decisionMaker.getDecision()).isEqualTo("Stop");
    }


    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    protected void runMain() {

    }
}
