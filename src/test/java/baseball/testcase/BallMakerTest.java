//package baseball.testcase;
//
//import baseball.game.Ball;
//import baseball.game.BallMaker;
//import camp.nextstep.edu.missionutils.test.NsTest;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import java.io.ByteArrayInputStream;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import static org.assertj.core.api.Assertions.*;
//
//
//public class BallMakerTest extends NsTest {
//
//    BallMaker ballMaker;
//
//    @BeforeEach
//    void mockSetting() {
//        ballMaker = new BallMaker();
//    }
//
//    @Test
//    @DisplayName("BallMaker가 랜덤한 3개의 Ball을 반환하는지 확인")
//    @RepeatedTest(10)
//    void BALLMAKER의_RANDOMBALL의_갯수와_중복되지않음을_확인() {
//        //given
//        Ball ball = ballMaker.getRandomBall();
//        List<Integer> ballData = ball.getBallData();
//        Set<Integer> ballSet = new HashSet<>(ballData);
//
//        //when
//        boolean isUniqueBalls = ballData.size() == ballSet.size();
//
//        //then
//        assertThat(isUniqueBalls && ballData.size() == 3)
//                .isTrue();
//    }
//
//    @Test
//    @DisplayName("BallMaker가 UserBall을 제대로 확인 하는지 확인")
//    void BALLMAKER가_USERBALL를_제대로_생성하는지_확인() {
//        command("123", "321", "589", "485");
//        Ball firstBall = ballMaker.getUserBall();
//        Ball secondBall = ballMaker.getUserBall();
//        Ball thirdBall = ballMaker.getUserBall();
//        Ball fourthBall = ballMaker.getUserBall();
//
//        List<Integer> firstBallData = firstBall.getBallData();
//        List<Integer> secondBallData = secondBall.getBallData();
//        List<Integer> thirdBallData = thirdBall.getBallData();
//        List<Integer> fourthBallData = fourthBall.getBallData();
//
//        String first = firstBallData.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
//        String second = secondBallData.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
//        String third = thirdBallData.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
//        String fourth = fourthBallData.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
//
//        boolean firstCheck = first.equals("123");
//        boolean secondCheck = second.equals("321");
//        boolean thirdCheck = third.equals("589");
//        boolean fourthCheck = fourth.equals("485");
//
//        assertThat(firstCheck && secondCheck && thirdCheck && fourthCheck).isTrue();
//    }
//
//    @DisplayName("BallMaker가 UserBall을 만드는 과정에서 잘못된 입력을 받는다면 BallMaker는 IllegalArgumentException를 던진다")
//    @ParameterizedTest
//    @ValueSource(strings = {"1234", "hello", "12", "012"})
//    void BALLMAKER의_GETUSERBALL_메서드_예외_발생_테스트(String stringArg) {
//        command(stringArg);
//        assertThatThrownBy(() -> ballMaker.getUserBall()).isInstanceOf(IllegalArgumentException.class);
//    }
//
//    private void command(final String... args) {
//        final byte[] buf = String.join("\n", args).getBytes();
//        System.setIn(new ByteArrayInputStream(buf));
//    }
//
//    @Override
//    protected void runMain() {
//
//    }
//}
