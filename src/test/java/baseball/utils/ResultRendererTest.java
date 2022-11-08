package baseball.utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultRendererTest {

    @Nested
    class Describe_getResult {

        @Nested
        class Context_when_gives_2_strike_1_ball {
            private int strike = 2;
            private int ball = 1;
            @Test
            void It_returns_string() {
                String result = ResultRenderer.getResult(strike, ball);

                assertThat(result).isEqualTo("1볼 2스트라이크");
            }
        }

        @Nested
        class Context_when_gives_no_strike_1_ball {
            private int strike = 0;
            private int ball = 1;
            @Test
            void It_returns_string() {
                String result = ResultRenderer.getResult(strike, ball);

                assertThat(result).isEqualTo("1볼");
            }
        }

        @Nested
        class Context_when_gives_2_strike_no_ball {
            private int strike = 2;
            private int ball = 0;
            @Test
            void It_returns_string() {
                String result = ResultRenderer.getResult(strike, ball);

                assertThat(result).isEqualTo("2스트라이크");
            }
        }

        @Nested
        class Context_when_gives_no_strike_no_ball {
            private int strike = 0;
            private int ball = 0;
            @Test
            void It_returns_string() {
                String result = ResultRenderer.getResult(strike, ball);

                assertThat(result).isEqualTo("낫싱");
            }
        }

    }

}
