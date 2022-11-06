package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

public class IntentionOfContinuingGameTest {
    final static int CONTINUE = 1;
    final static int STOP = 2;
    static IntentionOfContinuingGame intentionContinue;
    static IntentionOfContinuingGame intentionStop;


    @BeforeAll
    static void getIntention(){
        intentionContinue = IntentionOfContinuingGame.getMatchIntention(CONTINUE);
        intentionStop= IntentionOfContinuingGame.getMatchIntention(STOP);

        Assertions.assertThat(intentionContinue).isEqualTo(IntentionOfContinuingGame.CONTINUE);
        Assertions.assertThat(intentionStop).isEqualTo(IntentionOfContinuingGame.STOP);
    }

    @Test
    @DisplayName("Continue 인 경우 wantContinue 가 true 인지 확인")
    void validateWantContinue(){
        Assertions.assertThat(intentionContinue.wantContinue()).isEqualTo(true);
    }

    @Test
    @DisplayName("Stop 인 경우 wantContinue 가 false 인지 확인")
    void validateWantStop(){
        Assertions.assertThat(intentionStop.wantContinue()).isEqualTo(false);
    }

    @Test
    @DisplayName("잘못된 값을 입력하는 경우 오류 반환 확인")
    void validateThrowExceptionWhenGotWrongArgument(){
        int wrongArgument = 3;
        Assertions.assertThatThrownBy(() -> IntentionOfContinuingGame.getMatchIntention(wrongArgument))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
