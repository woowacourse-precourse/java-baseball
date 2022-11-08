package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CalculateNumTest {

    private static Calculator calculator;

    @BeforeEach
    public void beforeEach() {
        calculator = new Calculator();
    }

    @Test
    void 볼_스트라이크_계산(){
        calculator.calculateNum("123","234");
        assertThat(calculator.getBallNum()).isEqualTo(2);
        assertThat(calculator.getStrikeNum()).isEqualTo(0);
    }

    @Test
    void 볼_증가(){
        int ballnum =  calculator.getBallNum();
        calculator.addBall();
        assertThat(calculator.getBallNum()).isEqualTo(ballnum+1);
    }

    @Test
    void 스트라이크_증가(){
        int strikeNum =  calculator.getStrikeNum();
        calculator.addStrike();
        assertThat(calculator.getStrikeNum()).isEqualTo(strikeNum+1);
    }
}
