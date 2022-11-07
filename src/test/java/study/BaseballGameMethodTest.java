package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballGameMethodTest {

    @Test
    void checkBall_사용자답변_볼의개수_로직() {
        String result = "";
        String userAnswer = "123";
        String computer = "321";
        char[] userNumber = userAnswer.toCharArray();
        char[] computerNumber = computer.toCharArray();

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == j) {
                    continue;
                }else if(userNumber[i] == computerNumber[j]) {
                    result += "O";
                }
            }
        }

        assertThat(result).isEqualTo("OO");
    }

    @Test
    void checkStrike_사용자답변_스트라이크의개수_로직() {
        String result = "";
        String userAnswer = "123";
        String computer = "321";
        char[] userNumber = userAnswer.toCharArray();
        char[] computerNumber = computer.toCharArray();

        for(int i = 0; i < 3; i++) {
            if(userNumber[i] == computerNumber[i]) {
                result += "O";
            }
        }

        assertThat(result).isEqualTo("O");
    }

}
