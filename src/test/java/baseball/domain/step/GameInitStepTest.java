package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("GameInitStep 은 ")
class GameInitStepTest {

    @Test
    @DisplayName("실행 가능하다")
    void isExecutable() {
        // given
        GameInitStep gameInitStep = new GameInitStep();

        // when
        boolean executable = gameInitStep.executable();

        // then
        assertThat(executable).isTrue();
    }

    @Test
    @DisplayName("다음 단계로 [숫자 입력 단계]를 갖는다")
    void nextIsInputNumberStep() {
        // given
        GameInitStep gameInitStep = new GameInitStep();

        // when
        Step next = gameInitStep.next();

        // then
        assertThat(next).isExactlyInstanceOf(InputNumberStep.class);
    }

    @Test
    @DisplayName("실행 시 게임의 상태를 초기화한다")
    void initContextWhenExecuted() throws Exception {
        // given
        GameInitStep gameInitStep = new GameInitStep();
        BaseBallGameContext context = mock(BaseBallGameContext.class);

        // when
        gameInitStep.execute(context);

        // then
        verify(context, times(1)).init();
    }
}