package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("IntentionOfContinuingGame 클래스의")
public class IntentionOfContinuingGameTest {


    @Nested
    @DisplayName("getMatchIntention 메서드는")
    class Describe_getMatchIntention {

        final static int CONTINUE = 1;
        final static int STOP = 2;

        @Test
        @DisplayName("사용자가 1을 입력할 경우 CONTINUE 객체를 반환한다")
        void it_returns_CONTINUE_Object() {
            IntentionOfContinuingGame intentionContinue = IntentionOfContinuingGame.getMatchIntention(
                CONTINUE);
            Assertions.assertThat(intentionContinue).isEqualTo(IntentionOfContinuingGame.CONTINUE);

        }

        @Test
        @DisplayName("사용자가 2를 입력할 경우 STOP 객체를 반환한다")
        void it_returns_STOP_Object() {
            IntentionOfContinuingGame intentionContinue = IntentionOfContinuingGame.getMatchIntention(
                STOP);
            Assertions.assertThat(intentionContinue).isEqualTo(IntentionOfContinuingGame.STOP);
        }

        @Test
        @DisplayName("사용자가 잘못된 값을 입력하는 경우 IllegalArgumentException 반환한다.")
        void throws_error_when_input_is_wrong() {
            int wrongArgument = 3;
            Assertions.assertThatThrownBy(
                    () -> IntentionOfContinuingGame.getMatchIntention(wrongArgument))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("wantContinue 메서드는")
    class Describe_wantContinue {

        @Test
        @DisplayName("CONTINUE 객체에서 사용되는 경우 true를 반환한다.")
        void it_returns_true_when_Object_is_CONTINUE() {
            Assertions.assertThat(IntentionOfContinuingGame.CONTINUE.wantContinue())
                .isEqualTo(true);
        }

        @Test
        @DisplayName("STOP 객체에서 사용되는 경우 false를 반환한다.")
        void it_returns_true_when_Object_is_STOP() {
            Assertions.assertThat(IntentionOfContinuingGame.STOP.wantContinue()).isEqualTo(false);
        }
    }


}
