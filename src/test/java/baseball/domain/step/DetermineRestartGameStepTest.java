package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DisplayName("DetermineRestartGameStep 은 ")
class DetermineRestartGameStepTest {

    private final BaseBallGameContext context = mock(BaseBallGameContext.class);

    @Test
    @DisplayName("실행 가능하다")
    void isExecutable() {
        // given
        DetermineRestartGameStep determineRestartGameStep = new DetermineRestartGameStep();

        // when
        boolean executable = determineRestartGameStep.executable();

        // then
        assertThat(executable).isTrue();
    }

    @Test
    @DisplayName("실행 시 게임 재실행 여부 문구를 출력한다")
    void printRestartGameMessageWhenExecuted() {
        // given
        final String input = "1";
        final String restartGameMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        DetermineRestartGameStep determineRestartGameStep = new DetermineRestartGameStep();
        when(context.readLine()).thenReturn(input);

        // when
        determineRestartGameStep.execute(context);

        // then
        verify(context, times(1)).println(restartGameMessage);
    }

    @ParameterizedTest(name = "사용자가 잘못된 입력( EX[ {argumentsWithNames} ] )을 입력한 경우 IllegalArgumentException을 발생시킨다")
    @ValueSource(strings = {"-1", "3", "c", "Asdwq", "01", "10", "00"})
    void throwExceptionWhenInvalidInput(final String input) {
        // given
        DetermineRestartGameStep determineRestartGameStep = new DetermineRestartGameStep();
        when(context.readLine()).thenReturn(input);

        // when, then
        assertThrows(IllegalArgumentException.class, () -> determineRestartGameStep.execute(context));
    }

    @Test
    @DisplayName("1을 입력받은 경우 다음 단계로 [게임 초기화 단계]를 갖는다")
    void nextIsGameProgressStepWhenInputIs1() {
        // given
        final String input = "1";
        DetermineRestartGameStep determineRestartGameStep = new DetermineRestartGameStep();
        when(context.readLine()).thenReturn(input);

        determineRestartGameStep.execute(context);

        // when,
        Step next = determineRestartGameStep.next();

        // then
        assertThat(next).isExactlyInstanceOf(GameInitStep.class);
    }

    @Test
    @DisplayName("2을 입력받은 경우 다음 단계로 [애플리케이션 종료 단계]를 갖는다.")
    void nextIsApplicationEndStepWhenInputIs0() {
        // given
        final String input = "2";
        DetermineRestartGameStep determineRestartGameStep = new DetermineRestartGameStep();
        when(context.readLine()).thenReturn(input);

        determineRestartGameStep.execute(context);

        // when,
        Step next = determineRestartGameStep.next();

        // then
        assertThat(next).isExactlyInstanceOf(ApplicationExitStep.class);
    }
}