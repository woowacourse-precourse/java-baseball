package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NumberCompareResultTest {

    @Nested
    @DisplayName("toString메서드는 NumberCompareResult 객체의 strike와 ball중")
    class Describe_toString {

        @Test
        @DisplayName("strike만 1 이상인 경우 [개수][스트라이크] 형태의 문자열을 반환한다")
        void it_returns_string_contains_numberOf_strike() {
            NumberCompareResult numberCompareResultStrike = new NumberCompareResult(1, 0);
            Assertions.assertThat(numberCompareResultStrike.toString()).isEqualTo("1스트라이크");
        }

        @Test
        @DisplayName("ball만 1 이상인 경우 [개수][볼] 형태의 문자열을 반환한다")
        void it_returns_string_contains_numberOf_ball() {
            NumberCompareResult numberCompareResultStrike = new NumberCompareResult(0, 1);
            Assertions.assertThat(numberCompareResultStrike.toString()).isEqualTo("1볼");
        }

        @Test
        @DisplayName("strike/ball 모두 1 이상인 경우 [개수][볼] [개수][스트라이크] 형태의 문자열을 반환한다")
        void it_returns_string_contains_numberOf_strike_and_ball() {
            NumberCompareResult numberCompareResultStrike = new NumberCompareResult(1, 1);
            Assertions.assertThat(numberCompareResultStrike.toString()).isEqualTo("1볼 1스트라이크");
        }

        @Test
        @DisplayName("strike/ball 모두 0인 경우 [nothing] 문자열을 반환한다")
        void it_returns_string_contains_nothing() {
            NumberCompareResult numberCompareResultStrike = new NumberCompareResult(1, 0);
            Assertions.assertThat(numberCompareResultStrike.toString()).isEqualTo("1스트라이크");
        }
    }
}
