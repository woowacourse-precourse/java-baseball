package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @DisplayName("결과표시 기능1: 숫자와 자리까지 일치할 경우 스트라이크 개수 출력")
    @Test
    public  void  printStrikeCount() {
        final Result result = new Result(2, 0);
        assertThat(result.printStrike()).isEqualTo("2스트라이크 ");
    }

    @DisplayName("결과표시 기능2: 숫자만 일치할 경우 볼 개수 출력")
    @Test
    public  void  printBallCount() {
        final Result result = new Result(0, 2);
        assertThat(result.printBall()).isEqualTo("2볼 ");
    }

    @DisplayName("결과표시 기능3: 둘 다 일치하지 않을 경우 낫싱 출력")
    @Test
    public  void  printNothingCount() {
        final Result result = new Result(0, 0);
        assertThat(result.printNothing()).isEqualTo("낫싱");
    }
}
