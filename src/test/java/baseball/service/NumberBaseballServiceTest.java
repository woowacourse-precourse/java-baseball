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
}