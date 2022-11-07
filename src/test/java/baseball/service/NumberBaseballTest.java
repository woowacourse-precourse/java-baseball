package baseball.service;

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
}