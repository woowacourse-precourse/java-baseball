package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import baseball.domain.result.CompareResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("GameProgressStep 은 ")
class GameProgressStepTest {

    private final BaseBallGameContext context = mock(BaseBallGameContext.class);

    private CompareResult answerResult() {
        CompareResult compareResult = new CompareResult();
        compareResult.addStrike();
        compareResult.addStrike();
        compareResult.addStrike();
        return compareResult;
    }

    @Test
    @DisplayName("실행 가능하다")
    void isExecutable() {
        // given
        GameProgressStep gameProgressStep = new GameProgressStep();

        // when
        boolean executable = gameProgressStep.executable();

        // then
        assertThat(executable).isTrue();
    }

    @Test
    @DisplayName("실행 시 사용자의 숫자와 컴퓨터의 숫자를 비교한다.")
    void comparePlayerAndComputerWhenExecuted() {
        // given
        GameProgressStep gameProgressStep = new GameProgressStep();

        when(context.comparePlayerAndComputer()).thenReturn(answerResult());

        // when
        gameProgressStep.execute(context);

        // then
        verify(context, times(1))
                .comparePlayerAndComputer();
    }

    @Test
    @DisplayName("비교 결과가 정답이라면 다음 단계로 [게임 종료 단계]를 갖는다.")
    void nextIsGameEndStepWhenCompareResultIsAnswer() {
        // given
        GameProgressStep gameProgressStep = new GameProgressStep();

        when(context.comparePlayerAndComputer()).thenReturn(answerResult());

        gameProgressStep.execute(context);

        // when
        Step next = gameProgressStep.next();

        // then
        assertThat(next).isExactlyInstanceOf(GameEndStep.class);
    }

    @Test
    @DisplayName("비교 결과가 오답이라면 다음 단계로 [숫자 입력 단계]를 갖는다.")
    void nextIsInputNumberStepWhenCompareResultIsNotAnswer() {
        // given
        GameProgressStep gameProgressStep = new GameProgressStep();

        when(context.comparePlayerAndComputer()).thenReturn(new CompareResult());

        gameProgressStep.execute(context);

        // when
        Step next = gameProgressStep.next();

        // then
        assertThat(next).isExactlyInstanceOf(InputNumberStep.class);
    }

    @Test
    @DisplayName("비교 결과를 출력한다.")
    void printCompareResult() {
        // given
        GameProgressStep gameProgressStep = new GameProgressStep();

        CompareResult compareResult = new CompareResult();
        when(context.comparePlayerAndComputer()).thenReturn(compareResult);

        // when
        gameProgressStep.execute(context);

        // then
        verify(context, times(1))
                .println(compareResult.toString());
    }
}