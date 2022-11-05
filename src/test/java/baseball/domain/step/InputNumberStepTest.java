package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import baseball.domain.number.BaseBallGameNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DisplayName("InputNumberStep 은 ")
class InputNumberStepTest {

    private final BaseBallGameContext context = mock(BaseBallGameContext.class);

    @BeforeEach
    public void init() {
        doNothing().when(context).changePlayerNumbers(any());
    }

    @Test
    @DisplayName("실행 가능하다")
    public void isExecutable() {
        // given
        InputNumberStep inputNumberStep = new InputNumberStep();

        // when
        boolean executable = inputNumberStep.executable();

        // then
        assertThat(executable).isTrue();
    }

    @Test
    @DisplayName("다음 단계로 [게임 진행 단계]를 갖는다")
    public void nextIsGameProgressStep() {
        // given
        InputNumberStep inputNumberStep = new InputNumberStep();

        // when
        Step next = inputNumberStep.next();

        // then
        assertThat(next).isExactlyInstanceOf(GameProgressStep.class);
    }

    @Test
    @DisplayName("실행 시 숫자 입력 문구를 출력한다.")
    public void printInputNumberMessageWhenExecuted() {
        // given
        String userInput = "123";
        when(context.readLine()).thenReturn(userInput);

        String inputNumberMessage = "숫자를 입력해주세요 : ";
        InputNumberStep inputNumberStep = new InputNumberStep();

        // when
        inputNumberStep.execute(context);

        // then
        verify(context, times(1)).print(inputNumberMessage);
    }

    @Test
    @DisplayName("실행 시 사용자로부터 입력을 받아와 3자리 숫자로 변경 후, Context에 저장된 사용자의 입력 정보를 갱신한다.")
    public void makePersonUsingInput() {
        // given
        String userInput = "123";
        when(context.readLine()).thenReturn(userInput);

        InputNumberStep inputNumberStep = new InputNumberStep();

        // when
        inputNumberStep.execute(context);

        // then
        verify(context, times(1)).changePlayerNumbers(any(BaseBallGameNumbers.class));
    }

    @Test
    @DisplayName("3자리 숫자로 변경 과정에서 IllegalArgumentException이 발생하였다면 catch 하지 않고 던진다.")
    public void throwExceptionWhenConstructPersonUsingInput() {
        // given
        String invalidUserInput = "0321";
        when(context.readLine()).thenReturn(invalidUserInput);

        InputNumberStep inputNumberStep = new InputNumberStep();

        // when, then
        assertThrows(IllegalArgumentException.class, () -> inputNumberStep.execute(context));
    }
}