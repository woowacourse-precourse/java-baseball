package baseball.model.numbergenerator;

import baseball.model.numbers.Numbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class NextStepNumberGeneratorTest {

    private NumberGenerator numberGenerator = new NextStepNumberGenerator();

    @Test
    public void generateRandomNumber_메서드_사용시_3자리_숫자를_반환() {
        //given
        Numbers answer = numberGenerator.generateRandomNumber(3);
        List<Integer> answerNumberList = answer.getNums();

        //when
        long distinctCount = answerNumberList.stream().distinct().count();
        long numberCount = answerNumberList.stream().filter(number -> number >= 1 && number <= 9).count();

        //then
        Assertions.assertThat(distinctCount).isEqualTo(3);
        Assertions.assertThat(numberCount).isEqualTo(3);
    }
}