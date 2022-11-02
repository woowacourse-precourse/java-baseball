package baseball.domain.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameStartStep 은 ")
class GameStartStepTest {

    @Test
    @DisplayName("실행 가능하다")
    public void isExecutable() {
        // given
        GameStartStep gameStartStep = new GameStartStep();

        // when
        boolean executable = gameStartStep.executable();

        // then
        assertThat(executable).isTrue();
    }

    @Test
    @DisplayName("다음 단계로 [게임 초기화 단계]를 갖는다")
    public void nextIsGameInitStep() {
        // given
        GameStartStep gameStartStep = new GameStartStep();

        // when
        Step next = gameStartStep.next();

        // then
        assertThat(next).isExactlyInstanceOf(GameInitStep.class);
    }
}