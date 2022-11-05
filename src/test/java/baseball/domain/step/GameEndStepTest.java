package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("GameEndStep 은 ")
class GameEndStepTest {

    @Test
    @DisplayName("실행 가능하다")
    void isExecutable() {
        // given
        GameEndStep gameEndStep = new GameEndStep();

        // when
        boolean executable = gameEndStep.executable();

        // then
        assertThat(executable).isTrue();
    }

    @Test
    @DisplayName("실행 시 정답을 맞추었다는 문구를 출력한다")
    void printRightAnswerMessageWhenExecuted() {
        // given
        final String rightAnswerMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        GameEndStep gameEndStep = new GameEndStep();
        BaseBallGameContext context = mock(BaseBallGameContext.class);

        // when
        gameEndStep.execute(context);

        // then
        verify(context, times(1)).println(rightAnswerMessage);
    }

    @Test
    @DisplayName("다음 단계로 [게임 재실행 여부 판단 단계]를 갖는다")
    void nextIsGameInitStep() {
        // given
        GameEndStep gameEndStep = new GameEndStep();

        // when
        Step next = gameEndStep.next();

        // then
        assertThat(next).isExactlyInstanceOf(DetermineRestartGameStep.class);
    }
}