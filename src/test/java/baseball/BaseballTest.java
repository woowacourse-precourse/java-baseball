package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {

    Baseball baseball;

    @BeforeEach
    void setUp() { baseball = new Baseball(); }

    @Test
    void input_유효한_경우_테스트(){
        int input = 123;
        boolean result = baseball.isValidNum(input);

        assertThat(result).isTrue();
    }

    @Test
    void input_0이_포함된_경우_테스트(){
        int input = 103;
        boolean result = baseball.isValidNum(input);

        assertThat(result).isFalse();
    }

    @Test
    void input_사이즈가_잘못된_경우_테스트(){
        int input = 23;
        boolean result = baseball.isValidNum(input);

        assertThat(result).isFalse();
    }

    @Test
    void input_사이즈가_잘못된_경우_2_테스트(){
        int input = 1235;
        boolean result = baseball.isValidNum(input);

        assertThat(result).isFalse();
    }

    @Test
    void input_겹치는_수_존재하는_경우_2_테스트(){
        int input = 998;
        boolean result = baseball.isValidNum(input);

        assertThat(result).isFalse();
    }

//    @Test
//    void setGuessNumberTest() {
//        baseball.setGuessNumber(123);
//
//        GuessResult guessResult = baseball.getGuessResult();
//        assertThat(guessResult).isEqualTo(GuessResult.END);
//    }
}
