package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockedStatic;

import camp.nextstep.edu.missionutils.Randoms;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServiceTest {
    private BaseballGameService baseballGameService = new BaseballGameService();

    @BeforeAll
    void setGame() {
        assertRandomNumberInRangeTest(
                () -> {
                    baseballGameService.setGame();
                },
                1, 2, 3);
    }

    @Nested
    class Guess {

        @Test
        void _3스트라이크() {
            List<Integer> input = new ArrayList<>(List.of(1, 2, 3));
            Hint result = baseballGameService.guess(input);
            assertThat(result.getBall()).isEqualTo(0);
            assertThat(result.getStrike()).isEqualTo(3);
            assertThat(result.toString()).isEqualTo("3스트라이크");
        }

        @Test
        void _2스트라이크() {
            List<Integer> input = new ArrayList<>(List.of(1, 2, 4));
            Hint result = baseballGameService.guess(input);
            assertThat(result.getBall()).isEqualTo(0);
            assertThat(result.getStrike()).isEqualTo(2);
            assertThat(result.toString()).isEqualTo("2스트라이크");
        }

        @Test
        void _1스트라이크() {
            List<Integer> input = new ArrayList<>(List.of(1, 4, 5));
            Hint result = baseballGameService.guess(input);
            assertThat(result.getBall()).isEqualTo(0);
            assertThat(result.getStrike()).isEqualTo(1);
            assertThat(result.toString()).isEqualTo("1스트라이크");
        }

        @Test
        void _2볼() {
            List<Integer> input = new ArrayList<>(List.of(2, 1, 4));
            Hint result = baseballGameService.guess(input);
            assertThat(result.getBall()).isEqualTo(2);
            assertThat(result.getStrike()).isEqualTo(0);
            assertThat(result.toString()).isEqualTo("2볼");
        }

        @Test
        void _1볼() {
            List<Integer> input = new ArrayList<>(List.of(2, 4, 5));
            Hint result = baseballGameService.guess(input);
            assertThat(result.getBall()).isEqualTo(1);
            assertThat(result.getStrike()).isEqualTo(0);
            assertThat(result.toString()).isEqualTo("1볼");
        }

        @Test
        void _2볼_1스트라이크() {
            List<Integer> input = new ArrayList<>(List.of(1, 3, 2));
            Hint result = baseballGameService.guess(input);
            assertThat(result.getBall()).isEqualTo(2);
            assertThat(result.getStrike()).isEqualTo(1);
            assertThat(result.toString()).isEqualTo("2볼 1스트라이크");
        }

        @Test
        void _1볼_1스트라이크() {
            List<Integer> input = new ArrayList<>(List.of(1, 3, 4));
            Hint result = baseballGameService.guess(input);
            assertThat(result.getBall()).isEqualTo(1);
            assertThat(result.getStrike()).isEqualTo(1);
            assertThat(result.toString()).isEqualTo("1볼 1스트라이크");
        }

        @Test
        void 낫싱() {
            List<Integer> input = new ArrayList<>(List.of(4, 5, 6));
            Hint result = baseballGameService.guess(input);
            assertThat(result.getBall()).isEqualTo(0);
            assertThat(result.getStrike()).isEqualTo(0);
            assertThat(result.toString()).isEqualTo("낫싱");
        }
    }
}
