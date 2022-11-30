//package baseball.testcase;
//
//import baseball.decision.Decision;
//import baseball.decision.DecisionMaker;
//import camp.nextstep.edu.missionutils.test.NsTest;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import java.io.ByteArrayInputStream;
//
//import static org.assertj.core.api.Assertions.*;
//
//public class DecisionMakerTest extends NsTest {
//
//    DecisionMaker decisionMaker = new DecisionMaker();
//
//    @DisplayName("유저가 재 진행을 원할 경우 Play라는 의사 결정을 반환한다")
//    @Test
//    void Play_의사결정_반환_테스트() {
//        command("1");
//        assertThat(decisionMaker.getDecision()).isEqualTo(Decision.PLAY);
//    }
//
//    @DisplayName("유저가 종료를 원할 경우 Stop라는 의사 결정을 반환한다")
//    @Test
//    void Stop_의사결정_반환_테스트() {
//        command("2");
//        assertThat(decisionMaker.getDecision()).isEqualTo(Decision.STOP);
//    }
//
//    @DisplayName("1, 2외의 값을 입력했을 경우 예외를 발생시킨다")
//    @ParameterizedTest
//    @ValueSource(strings = { "3", "hello", "야호", "012"})
//    void DecisionMaker_예외_발생_테스트(String stringArg) {
//        command(stringArg);
//        assertThatThrownBy(()->decisionMaker.getDecision()).isInstanceOf(IllegalArgumentException.class);
//    }
//
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
