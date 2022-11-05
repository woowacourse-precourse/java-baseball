package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class AnswerGeneratorTest {
    @Test
    void 랜덤_숫자_생성_테스트() {
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();
        InputValidator inputValidator = new InputValidator();

        //when
        List<Integer> tempNums = answerGenerator.generateAnswer();
        boolean result = inputValidator.hasValidInput(tempNums);

        //then
        assertThat(result).isEqualTo(true);
    }
}
