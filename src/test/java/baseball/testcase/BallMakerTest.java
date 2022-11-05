package baseball.testcase;

import baseball.game.BallMaker;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BallMakerTest extends NsTest {

    BallMaker ballMaker;

    @BeforeEach
    void mockSetting() {
        ballMaker = new BallMaker();
    }

    @Test
    @DisplayName("BallMaker가 랜덤한 3개의 Ball을 반환하는지 확인")
    @RepeatedTest(10)
    void BALLMAKER의_RANDOMBALL의_갯수와_중복되지않음을_확인() {
        //given
        List<Integer> ball = ballMaker.getRandomBall();
        Set<Integer> ballSet = new HashSet<>(ball);

        //when
        boolean isUniqueBalls = ball.size() == ballSet.size();

        //then
        assertThat(isUniqueBalls && ball.size() == 3)
                .isTrue();
    }

    @Override
    protected void runMain() {

    }
}
