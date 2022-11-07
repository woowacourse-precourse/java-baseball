package baseball.service;

import baseball.dto.StrikeBallCountDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class NumberBaseballServiceTest {

    @Test
    void generateAnswerNumber() {
        //given
        NumberBaseballService numberBaseballService = new NumberBaseballService();

        //when
        numberBaseballService.generateAnswerNumber();
        List<Integer> answer = numberBaseballService.getAnswer();

        //then
        Assertions.assertThat(answer.size()).isEqualTo(3);

        Set<Integer> answerSet = new HashSet<>(answer);
        Assertions.assertThat(answerSet.size()).isEqualTo(answer.size());

        Assertions.assertThat(answer).allMatch(num -> num >= 1 && num <= 9);
    }

    @Test
    void compareInputAndAnswer() {
        //given
        NumberBaseballService numberBaseballService = new NumberBaseballService();
        List<Integer> answer = numberBaseballService.getAnswer();

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
        StrikeBallCountDto result = numberBaseballService.compareInputAndAnswer(answer);
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(3);
        Assertions.assertThat(result.getBallCount()).isEqualTo(0);

        //input1 - 2 ball
        result = numberBaseballService.compareInputAndAnswer(input1);
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(0);
        Assertions.assertThat(result.getBallCount()).isEqualTo(2);

        //input2 - 3 ball
        result = numberBaseballService.compareInputAndAnswer(input2);
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(0);
        Assertions.assertThat(result.getBallCount()).isEqualTo(3);

        //input3 - nothing
        result = numberBaseballService.compareInputAndAnswer(input3);
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(0);
        Assertions.assertThat(result.getBallCount()).isEqualTo(0);

        //input4 - 1 strike 1 ball
        result = numberBaseballService.compareInputAndAnswer(input4);
        Assertions.assertThat(result.getStrikeCount()).isEqualTo(1);
        Assertions.assertThat(result.getBallCount()).isEqualTo(1);
    }

}