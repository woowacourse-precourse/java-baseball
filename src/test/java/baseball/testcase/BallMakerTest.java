package baseball.testcase;

import baseball.game.BallMaker;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Test
    @DisplayName("BallMaker가 UserBall을 제대로 확인 하는지 확인")
    void BALLMAKER가_USERBALL를_제대로_생성하는지_확인() {
        command("123","321","589","485");
        List<Integer> firstBall = ballMaker.getUserBall();
        List<Integer> secondBall = ballMaker.getUserBall();
        List<Integer> thirdBall = ballMaker.getUserBall();
        List<Integer> fourthBall = ballMaker.getUserBall();

        String first = firstBall.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
        String second = secondBall.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
        String third = thirdBall.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
        String fourth = fourthBall.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());

        boolean firstCheck = first.equals("123");
        boolean secondCheck = second.equals("321");
        boolean thirdCheck = third.equals("589");
        boolean fourthCheck = fourth.equals("485");

        assertThat(firstCheck && secondCheck && thirdCheck && fourthCheck).isTrue();
    }

    private void command(final String... args){
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    protected void runMain() {

    }
}
