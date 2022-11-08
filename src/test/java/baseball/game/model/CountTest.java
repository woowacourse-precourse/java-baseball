package baseball.game.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountTest {

    @Nested
    class OnlyStrikeCount {
        @Test
        void 스트라이크가_3인_경우 () {
            List<Integer> computerNumbers = Arrays.asList(1,2,3);
            List<Integer> userNumbers = Arrays.asList(1,2,3);

            Count count = new Count(computerNumbers, userNumbers);

            assertTrue(count.isCorrect());
        }

        @Test
        void 스트라이크가_2인_경우 () {
            List<Integer> computerNumbers = Arrays.asList(1,2,3);
            List<Integer> userNumbers = Arrays.asList(4,2,3);

            Count count = new Count(computerNumbers, userNumbers);

            assertThat(count.toString()).contains("2스트라이크");
        }

        @Test
        void 스트라이크가_1인_경우 () {
            List<Integer> computerNumbers = Arrays.asList(1,2,3);
            List<Integer> userNumbers = Arrays.asList(4,5,3);

            Count count = new Count(computerNumbers, userNumbers);

            assertThat(count.toString()).contains("1스트라이크");
        }
    }

    @Nested
    class OnlyBallCount {
        @Test
        void 볼이_1인_경우 () {
            List<Integer> computerNumbers = Arrays.asList(1,2,3);
            List<Integer> userNumbers = Arrays.asList(3,4,5);

            Count count = new Count(computerNumbers, userNumbers);

            assertThat(count.toString()).contains("1볼");
        }

        @Test
        void 볼이_2인_경우 () {
            List<Integer> computerNumbers = Arrays.asList(1,2,3);
            List<Integer> userNumbers = Arrays.asList(3,1,4);

            Count count = new Count(computerNumbers, userNumbers);

            assertThat(count.toString()).contains("2볼");
        }

        @Test
        void 볼이_3인_경우 () {
            List<Integer> computerNumbers = Arrays.asList(1,2,3);
            List<Integer> userNumbers = Arrays.asList(2,3,1);

            Count count = new Count(computerNumbers, userNumbers);

            assertThat(count.toString()).contains("3볼");
        }
    }

    @Nested
    class ComplexityCount {

        @Test
        void 볼이_1이고_스트라이크_1인_경우 () {
            List<Integer> computerNumbers = Arrays.asList(1,2,3);
            List<Integer> userNumbers = Arrays.asList(4,1,3);

            Count count = new Count(computerNumbers, userNumbers);

            assertThat(count.toString()).contains("1볼 1스트라이크");
        }

        @Test
        void 볼이_2이고_스트라이크_1인_경우 () {
            List<Integer> computerNumbers = Arrays.asList(1,2,3);
            List<Integer> userNumbers = Arrays.asList(2,1,3);

            Count count = new Count(computerNumbers, userNumbers);

            assertThat(count.toString()).contains("2볼 1스트라이크");
        }
    }


    @Test
    void 모든_숫자가_불일치한_경우 () {
        List<Integer> computerNumbers = Arrays.asList(1,2,3);
        List<Integer> userNumbers = Arrays.asList(4,5,6);
        Count count = new Count(computerNumbers, userNumbers);

        boolean result = count.isNothing();

        assertTrue(result);
    }

}