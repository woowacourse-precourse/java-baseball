package baseball;

import static baseball.utils.BaseballConstants.*;
import static org.assertj.core.api.Assertions.*;

import baseball.random.NumberGenerator;
import baseball.utils.NumberChecker;
import org.junit.jupiter.api.Test;


public class NumberGeneratorTest {

    @Test
    void 정답_세자리_수_숫자_검증(){
        String generated_number = NumberGenerator.generateAnswerNumber();

        assertThat(generated_number.length()).isEqualTo(BALL_NUMBER);
        assertThat(generated_number.charAt(0) == generated_number.charAt(1) ||
                generated_number.charAt(1) == generated_number.charAt(2) ||
                generated_number.charAt(0) == generated_number.charAt(2)).isEqualTo(false);
        assertThat(generated_number.matches("[1-9][1-9][1-9]")).isEqualTo(true);
    }
}
