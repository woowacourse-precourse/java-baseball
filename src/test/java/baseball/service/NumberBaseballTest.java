package baseball.service;

import baseball.dto.StrikeBallCountDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballTest {

    @Test
    void generateAnswerNumber() {
        //given
        NumberBaseball numberBaseball = new NumberBaseball();

        //when
        numberBaseball.generateAnswerNumber();
        List<Integer> answer = numberBaseball.getAnswer();

        //then
        Assertions.assertThat(answer.size()).isEqualTo(3);

        Set<Integer> answerSet = new HashSet<>(answer);
        Assertions.assertThat(answerSet.size()).isEqualTo(answer.size());

        Assertions.assertThat(answer).allMatch(num -> num >= 1 && num <= 9);
    }

    @Test
    void compareInputAndAnswer() {
        //given
        NumberBaseball numberBaseball = new NumberBaseball();
        List<Integer> answer = numberBaseball.getAnswer();

        //when
        int digit0 = answer.get(0);
        int digit1 = answer.get(1);
        int digit2 = answer.get(2);

        List<Integer> input1 = Arrays.asList(digit1, digit2, 10);
        List<Integer> input2 = Arrays.asList(digit1, digit2, digit0);
        List<Integer> input3 = Arrays.asList(10, 10, 10);
        List<Integer> input4 = Arrays.asList(digit2, digit1, 10);

        //then
        //input == answer
        StrikeBallCountDto result = numberBaseball.compareInputAndAnswer(answer);
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(3);
        Assertions.assertThat(result.getBallCount()).isEqualTo(0);

        //input1 - 2 ball
        result = numberBaseball.compareInputAndAnswer(input1);
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(0);
        Assertions.assertThat(result.getBallCount()).isEqualTo(2);

        //input2 - 3 ball
        result = numberBaseball.compareInputAndAnswer(input2);
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(0);
        Assertions.assertThat(result.getBallCount()).isEqualTo(3);

        //input3 - nothing
        result = numberBaseball.compareInputAndAnswer(input3);
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(0);
        Assertions.assertThat(result.getBallCount()).isEqualTo(0);

        //input4 - 1 strike 1 ball
        result = numberBaseball.compareInputAndAnswer(input4);
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(1);
        Assertions.assertThat(result.getBallCount()).isEqualTo(1);
    }

}