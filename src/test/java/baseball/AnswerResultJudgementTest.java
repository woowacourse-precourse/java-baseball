package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AnswerResultJudgementTest {
    AnswerResultJudgement answerResultJudgement;
    String[] input;
    String[] output;

    @BeforeEach
    void setup(){
        answerResultJudgement=new AnswerResultJudgement("123");
        input=new String[]{"123", "321", "789", "312"};
        output=new String[]{"3스트라이크", "2볼 1스트라이크", "낫싱", "3볼"};
    }
    @Test
    void 결과값이_맞는지_확인() {
        for(int i=0; i<input.length; i++) {
            assertThat(answerResultJudgement.getResult(input[i])).isEqualTo(output[i]);
        }
    }
}