package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    @Test
    void answer_랜덤_확인() {
        Computer test1 = new Computer();
        Computer test2 = new Computer();

        assertThat(test1.getAnswer()).isNotEqualTo(test2.getAnswer());
    }

    @Test
    void answer_숫자_길이_확인() {
        Computer result = new Computer();

        assertThat(result.getAnswer().length()).isEqualTo(3);
    }

    @Test
    void answer_숫자_중복_확인() {
        Computer result = new Computer();
        String resultNum = result.getAnswer();

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < resultNum.length(); i++) {
            set.add(resultNum.charAt(i));
        }

        assertThat(set.size()).isEqualTo(3);

    }

    @Test
    void strike_점수_확인_3점() {
        Computer result = new Computer();

        assertThat(result.countStrike(result.getAnswer()))
                .isEqualTo(3);

    }

    @Test
    void strike_점수_확인_0점() {
        Computer result = new Computer();

        assertThat(result.countStrike("000")).isEqualTo(0);

    }

    @Test
    void ball_점수_확인_3점() {
        Computer result = new Computer();

        assertThat(result.countBall(result.getAnswer(),0))
                .isEqualTo(3);

    }

    @Test
    void ball_점수_확인_0점() {
        Computer result = new Computer();

        assertThat(result.countBall("000",0))
                .isEqualTo(0);

    }

}