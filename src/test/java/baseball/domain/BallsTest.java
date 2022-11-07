package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class BallsTest {
    @DisplayName("같은 숫자가 존재하지 않는 Balls 입력 값인지 확인")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"123", "456", "789"})
    void correct_balls(String balls) {
        assertThatNoException()
                .isThrownBy(() -> new Balls(balls));
    }
    
    @Test
    @DisplayName("3개의 각 공이 strike, ball, nothing 중 어디에 속하는지 계산")
    void compare_balls() {
        Balls balls = new Balls("125");
        assertAll(
                () -> {
                    List<BallStatus> pitchResult = List.of(BallStatus.STRIKE, BallStatus.BALL, BallStatus.BALL);
                    assertThat(balls.compareBalls(new Balls("152"))).isEqualTo(pitchResult);
                },
                () -> {
                    List<BallStatus> pitchResult = List.of(BallStatus.STRIKE, BallStatus.NOTHING, BallStatus.BALL);
                    assertThat(balls.compareBalls(new Balls("132"))).isEqualTo(pitchResult);
                }
        );
    }
    
    @Test
    @DisplayName("예외 처리 : 같은 숫자가 존재할 경우")
    void exist_same_number_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Balls("515"))
                .withMessage("같은 번호를 여러개 입력할 수 없습니다.");
    }
}
