package baseball.question;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

import baseball.answer.BaseballAnswer;
import baseball.gametype.BaseballType;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

public class BaseballQuestionTest {


    @Test
    void askTest_ifFormatIsNotCorrect(){
        try (MockedConstruction<BaseballAnswer> mockBaseballAnswer = mockConstruction(BaseballAnswer.class)) {

            BaseballType mockBaseballType = mock(BaseballType.class);
            when(mockBaseballType.isFormatCorrect(anyInt())).thenReturn(false);

            assertThrows(IllegalArgumentException.class, () -> {
               new BaseballQuestion(mockBaseballType).ask(123);
            });
        }
    }

    @Test
    void askTest_ifFormatInCorrect(){
        try (MockedConstruction<BaseballAnswer> mockBaseballAnswer = mockConstruction(BaseballAnswer.class)) {

            BaseballType baseballType = mock(BaseballType.class);
            when(baseballType.isFormatCorrect(anyInt())).thenReturn(true);
            final BaseballAnswer baseballAnswer = new BaseballAnswer(baseballType);
            when(baseballAnswer.response(anyInt())).thenReturn(null);

            assertThat(new BaseballQuestion(baseballType).ask(123)).isEqualTo(null);
        }
    }
}
