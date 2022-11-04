package baseball;


import baseball.Output.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HintGenerationTest {
    static class HintTestCase
    {
        List<Integer> randomNumber;
        String answer;

        HintTestCase(List<Integer> randomNumber, String answer)
        {
            this.randomNumber = randomNumber;
            this.answer = answer;
        }

    }

    @Test
    void 생성된_힌트를_검사하는_테스트()
    {
        Integer userInput = 634;
        List<HintTestCase> testCase = List.of(
                new HintTestCase(List.of(1,2,3),Message.getBallMessage(1)),
                new HintTestCase(List.of(7,4,8),Message.getBallMessage(1)),
                new HintTestCase(List.of(5,8,1),Message.getNothingMessage()),
                new HintTestCase(List.of(6,7,4),Message.getStrikeMessage(2)),
                new HintTestCase(List.of(6,3,4),Message.getStrikeMessage(3)),
                new HintTestCase(List.of(4,3,6),Message.getBallAndStrikeMessage(2,1))
        );

        for (int i = 0; i < testCase.size(); i++)
        {
            HintTestCase hintTestCase = testCase.get(i);
            Assertions.assertThat(HintGenerator.generateHint(userInput,hintTestCase.randomNumber)).isEqualTo(hintTestCase.answer);
        }
    }

}
