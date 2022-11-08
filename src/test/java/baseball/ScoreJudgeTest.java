package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class ScoreJudgeTest {
    private ScoreJudge scoreJudge;
    private InputStream sysInBackup = System.in;

    @BeforeEach
    void setUp() {
        this.scoreJudge = new ScoreJudge();
    }

    @AfterEach
    void tearDown() {
        this.scoreJudge = null;
        System.setIn(sysInBackup);
    }

    @Test
    void ThreeBall() {
        int[] arr = new int[]{1,2,3};
        ByteArrayInputStream in = new ByteArrayInputStream("231".getBytes());
        System.setIn(in);

        String judge = scoreJudge.judge(arr);
        assertThat(judge).isEqualTo("3볼");
    }

    @Test
    void TwoBallOneStrike() {
        int[] arr = new int[]{1,2,3};
        ByteArrayInputStream in = new ByteArrayInputStream("132".getBytes());
        System.setIn(in);

        String judge = scoreJudge.judge(arr);
        assertThat(judge).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void ThreeStrike() {
        int[] arr = new int[]{1,2,3};
        ByteArrayInputStream in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);

        String judge = scoreJudge.judge(arr);
        assertThat(judge).isEqualTo("3스트라이크");
    }

    @Test
    void Nothing() {
        int[] arr = new int[]{1,2,3};
        ByteArrayInputStream in = new ByteArrayInputStream("456".getBytes());
        System.setIn(in);

        String judge = scoreJudge.judge(arr);
        assertThat(judge).isEqualTo("낫싱");
    }
}
