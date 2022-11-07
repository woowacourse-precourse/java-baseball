package baseball.domain.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BallScoreTest {
    private Score score;
    
    @BeforeEach
    void setUp() {
        score = new BallScore();
    }
    
    @DisplayName("올바른 스코어인지 확인")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {1, 2, 3})
    void correct_score(int score) {
        assertThatNoException()
                .isThrownBy(() -> new BallScore(score));
    }
    
    @Test
    @DisplayName("예외 처리 : BALL 개수가 종료 조건에 영향을 미칠 경우")
    void is_end() {
        assertThatThrownBy(score::isGameEnd)
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("BALL 의 개수는 게임 종료의 조건이 되지 않습니다.");
    }
    
    @Test
    @DisplayName("스코어 증가")
    void increase() {
        score = score.increase();
        assertThat(score.score()).isEqualTo(1);
    }
    
    @ParameterizedTest
    @DisplayName("예외 처리 : 스코어 범위(0~3) 벗어났을 경우")
    @ValueSource(ints = {-1, 4})
    void out_of_range_exception(int score) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BallScore(score))
                .withMessage("스코어는 0~3의 범위를 벗어날 수 없습니다.");
    }
}