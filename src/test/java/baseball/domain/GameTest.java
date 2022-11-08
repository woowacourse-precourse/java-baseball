package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private final Game game = new Game();
    private static final String USER_INPUT = "123";
    private static final String INDEX_DIFF_NUMBER = "142";
    private static final String DIFF_NUMBER = "456";
    private static final String COMPUTER_NUMBER = "123";

    @Test
    void getterTest() {
        Assertions.assertAll(
                () -> assertThat(game.getStrike()).isEqualTo(0),
                () -> assertThat(game.getBall()).isEqualTo(0)
        );

    }

    @Nested
    class Describe_compare {
        @Nested
        class Context_when_gives_same_number {
            @Test
            void It_increase_strike_to_3() {
                game.compare(USER_INPUT, COMPUTER_NUMBER);

                assertThat(game.getStrike()).isEqualTo(3);
            }
        }

        @Nested
        class Context_when_gives_one_index_different_number {
            @Test
            void It_increase_strike_to_1_and_ball_to_1() {
                game.compare(INDEX_DIFF_NUMBER, COMPUTER_NUMBER);

                assertThat(game.getStrike()).isEqualTo(1);
                assertThat(game.getBall()).isEqualTo(1);
            }
        }

        @Nested
        class Context_when_gives_totally_different_number  {
            @Test
            void It_increase_strike_to_1_and_ball_to_1() {
                game.compare(DIFF_NUMBER, COMPUTER_NUMBER);

                assertThat(game.getStrike()).isEqualTo(0);
                assertThat(game.getBall()).isEqualTo(0);
            }

        }
    }

}
