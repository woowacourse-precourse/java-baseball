package baseball;

import static baseball.Model.Player.Player.validateChoice;

import baseball.Model.Computer.Answer;
import baseball.Model.Player.BaseBallNumber;
import baseball.Model.Player.Player;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Nested
    @DisplayName("Player Class")
    class PlayerKoTest {

        @Nested
        @DisplayName("validateChoice method is")
        class DescribeValidateChoice {

            @Test
            @DisplayName("inpuf of 0")
            void validateChoiceZero() {
                Assertions.assertThatThrownBy(() -> {
                    validateChoice(0);
                }).isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("inpuf of 3")
            void validateChoiceThree() {
                Assertions.assertThatThrownBy(() -> {
                    validateChoice(3);
                }).isInstanceOf(IllegalArgumentException.class);
            }

            @Test
            @DisplayName("inpuf of 4")
            void validateChoiceFour() {
                Assertions.assertThatThrownBy(() -> {
                    validateChoice(4);
                }).isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("guess method is")
        class DescribeGuess {

            private static final boolean THREE_STRIKE = true;

            // for Test
            public boolean guessTest(BaseBallNumber baseBallNumber, Answer answer) {
                return answer.compare(baseBallNumber) == THREE_STRIKE;
            }

            @Test
            @DisplayName("answer correct")
            void guessAnswerCorrect() {
                Assertions.assertThat(guessTest(
                    new BaseBallNumber(List.of('1', '2', '3')),
                    new Answer(List.of('1', '2', '3')))).isTrue();
            }

            @Test
            @DisplayName("answer wrong")
            void guessAnswerWrong() {
                Assertions.assertThat(guessTest(
                    new BaseBallNumber(List.of('1', '2', '4')),
                    new Answer(List.of('1', '2', '3')))).isFalse();
            }
        }

        @Nested
        @DisplayName("choose method is")
        class DescribeChoose {

            private static final int ONE_MORE_GAME = 1;
            private static final int END_GAME = 2;

            // for Test
            public int chooseTest(int choice) {
                validateChoice(choice);
                if (choice == END_GAME) {
                    return END_GAME;
                }
                return ONE_MORE_GAME;
            }

            @Test
            @DisplayName("one more game")
            void chooseOneMoreGame() {
                int oneMoreGame = 1;
                Assertions.assertThat(chooseTest(oneMoreGame)).isEqualTo(1);
            }

            @Test
            @DisplayName("end game")
            void chooseEndGame() {
                Player dayun = new Player();
                int endGame = 2;
                Assertions.assertThat(chooseTest(endGame)).isEqualTo(2);
            }
        }
    }
}