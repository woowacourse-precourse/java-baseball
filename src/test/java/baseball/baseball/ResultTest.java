package baseball.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Nested
    class isNothing {

        @Test
        @DisplayName("낫싱인 경우")
        void caseTrue() {
            Result result = new Result(0, 0);

            assertThat(result.isNothing()).isEqualTo(true);
        }

        @Test
        @DisplayName("낫싱이 아닌 경우")
        void caseFalse() {
            Result result = new Result(0, 2);

            assertThat(result.isNothing()).isEqualTo(false);
        }
    }

    @Nested
    class isComplete {

        @Test
        @DisplayName("완벽인 경우")
        void caseTrue() {
            Result result = new Result(3, 0);

            assertThat(result.isComplete()).isEqualTo(true);
        }

        @Test
        @DisplayName("완벽이 아닌 경우")
        void caseFalse() {
            Result result = new Result(2, 0);

            assertThat(result.isComplete()).isEqualTo(false);
        }
    }

    @Nested
    class testToString {

        @Test
        @DisplayName("3스트라이크인 경우")
        void caseStrike3() {
            Result result = new Result(3, 0);

            assertThat(result.toString()).isEqualTo("3스트라이크");
        }

        @Test
        @DisplayName("3볼인 경우")
        void caseBall3() {
            Result result = new Result(0, 3);

            assertThat(result.toString()).isEqualTo("3볼");
        }

        @Test
        @DisplayName("2볼 1스크라이크인 경우")
        void caseStrike1Ball2() {
            Result result = new Result(1, 2);

            assertThat(result.toString()).isEqualTo("2볼 1스트라이크");
        }

        @Test
        @DisplayName("낫싱인 경우")
        void caseNothing() {
            Result result = new Result(0, 0);

            assertThat(result.toString()).isEqualTo("낫싱");
        }
    }
}