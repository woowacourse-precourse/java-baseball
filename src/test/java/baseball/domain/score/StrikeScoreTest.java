package baseball.domain.score;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StrikeScoreTest {
    @DisplayName("올바른 스코어인지 확인")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(ints = {1, 2, 3})
    void correct_score(int score) {
        assertThatNoException()
                .isThrownBy(() -> new StrikeScore(score));
    }
    
    @Test
    @DisplayName("3스트라이크 => 게임 종료인지 확인")
    void is_end() {
        Score score = new StrikeScore(3);
        
        assertThat(score.isGameEnd()).isTrue();
    }
    
    @Test
    @DisplayName("스코어 증가")
    void increase() {
        Score score = new StrikeScore(2);
        score = score.increase();
        
        assertThat(score.score()).isEqualTo(3);
    }
    
    @ParameterizedTest
    @DisplayName("예외 처리 : 스코어 범위(0~3) 벗어났을 경우")
    @ValueSource(ints = {-1, 4})
    void out_of_range_exception(int score) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StrikeScore(score))
                .withMessage("스코어는 0~3의 범위를 벗어날 수 없습니다.");
    }
}