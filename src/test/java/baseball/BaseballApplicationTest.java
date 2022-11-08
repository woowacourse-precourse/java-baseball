package baseball;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import baseball.gametype.BaseballType;
import baseball.question.BaseballQuestion;
import mock.MockInput;
import mock.MockOutput;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import java.time.Duration;
import java.util.List;

public class BaseballApplicationTest {

    @Test
    void BaseballApplicationRestartTest() {
        try (MockedConstruction<BaseballQuestion> mock = mockBaseballQuestion_restartTest()) {
            List<Integer> inputData = List.of(213, 1, 213, 1, 213, 2);
            BaseballApplication application = new BaseballApplication(new MockInput(inputData), new MockOutput());


            assertTimeout(Duration.ofMillis(1000), () -> {
               application.run(BaseballType.THREE_DIGITS);
            });
        }

    }

    @Test
    void BaseballApplicationRestartErrorTest() {
        try (MockedConstruction<BaseballQuestion> mock = mockBaseballQuestion_restartTest()) {
            List<Integer> inputData = List.of(213, 5);
            BaseballApplication application = new BaseballApplication(new MockInput(inputData), new MockOutput());


            assertThrows(IllegalArgumentException.class, () -> {
                application.run(BaseballType.THREE_DIGITS);
            });
        }
    }

    MockedConstruction<BaseballQuestion> mockBaseballQuestion_restartTest() {
        return mockConstruction(BaseballQuestion.class,
                withSettings().defaultAnswer(RETURNS_MOCKS),
                (mock, context) -> {
                    when(mock.ask(anyInt())).thenReturn("3스트라이크");
                    when(mock.isCorrect(anyInt())).thenReturn(true);
                });
    }

    @Test
    void BaseballApplicationCorrectTest() {
        try (MockedConstruction<BaseballQuestion> mock = mockBaseballQuestion_correctTest()) {
            List<Integer> inputData = List.of(213, 213, 213, 2);
            BaseballApplication application = new BaseballApplication(new MockInput(inputData), new MockOutput());


            assertTimeout(Duration.ofMillis(1000), () -> {
                application.run(BaseballType.THREE_DIGITS);
            });
        }

    }

    MockedConstruction<BaseballQuestion> mockBaseballQuestion_correctTest() {
        return mockConstruction(BaseballQuestion.class,
                withSettings().defaultAnswer(RETURNS_MOCKS),
                (mock, context) -> {
                    when(mock.ask(anyInt())).thenReturn("1볼","1볼", "3스트라이크");
                    when(mock.isCorrect(anyInt())).thenReturn(false, false, true);
                });
    }


}
