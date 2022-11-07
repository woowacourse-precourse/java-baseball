package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class GetBallAndStrikeCountTest extends NsTest {
    GetBallAndStrikeCount getBallAndStrikeCount = new GetBallAndStrikeCount();

    List<String> randomNumber = List.of("1", "2", "3");
    List<String> userNumber = List.of("1", "3", "4");

    @Test
    void 스트라이크_카운트() {
        int expectedStrikeValue = 1;
        int strikeCount = getBallAndStrikeCount.strikeCount(randomNumber,userNumber);
        assertThat(strikeCount).isEqualTo(expectedStrikeValue);
    }

    @Test
    void 볼_카운트() {
        int expectedBallValue = 1;
        int ballCount = getBallAndStrikeCount.ballCount(randomNumber, userNumber);
        assertThat(ballCount).isEqualTo(expectedBallValue);
    }

    @Override
    protected void runMain() {
    }
}