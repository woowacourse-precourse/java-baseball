package baseball.utils;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnswerGeneratorTest {
    @Test
    void 랜덤_숫자_생성_테스트() {
        //given, when
        List<Integer> tempNums = AnswerGenerator.generateAnswer();

        //then
        Assertions.assertThatCode(() ->InputValidator.hasValidInput(tempNums))
                .doesNotThrowAnyException();
    }
}
