package baseball;

import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomTest {

    @Nested
    public class CustomGenerateNumberTest {

        LocalDateTime now = LocalDateTime.now();
        BaseBallGame bg = new BaseBallGame();


        @Test
        @DisplayName("생성된 숫자가 없거나 비어있는 리스트인지 확인")
        void generatedNumberIsEmptyOrNull() {
            assertThat(bg.answerNumber).isNotNull().isNotEmpty();
        }

        @Test
        @DisplayName("생성된 숫자가 valid 한지 확인")
        void generatedNumberIsValid() {
            List<Integer> an = bg.answerNumber;
            for (int i : an) {
                assertThat(an.parallelStream().filter(v -> v == i).count() == 1).isTrue();
            }

        }
    }

    @Nested
    public class CustomStateRulesTest {

        @Test
        @DisplayName("상태전이 규칙이 제대로 적용되었는지 확인 : ON_GAME --> EXIT_GAME")
        void onGameWithInvalidUserInput() {
            assertThat(BaseBallGame.rules.get(List.of(BaseBallGame.State.ON_GAME.ordinal(), BaseBallGame.Trigger.INVALID_USER_INPUT.ordinal())))
                    .isEqualTo(BaseBallGame.State.EXIT_GAME);
        }

        @Test
        @DisplayName("상태전이 규칙이 제대로 적용되었는지 확인 : ON_GAME --> FINISH_GAME")
        void onGameWithCorrectAnswer() {
            assertThat(BaseBallGame.rules.get(List.of(BaseBallGame.State.ON_GAME.ordinal(), BaseBallGame.Trigger.CORRECT_ANSWER.ordinal())))
                    .isEqualTo(BaseBallGame.State.FINISH_GAME);
        }

        @Test
        @DisplayName("상태전이 규칙이 제대로 적용되었는지 확인 : ON_GAME --> ON_GAME")
        void onGameWithIncorrectAnswer() {
            assertThat(BaseBallGame.rules.get(List.of(BaseBallGame.State.ON_GAME.ordinal(), BaseBallGame.Trigger.INCORRECT_ANSWER.ordinal())))
                    .isEqualTo(BaseBallGame.State.ON_GAME);
        }

        @Test
        @DisplayName("상태전이 규칙이 제대로 적용되었는지 확인 : FINISH_GAME --> EXIT_GAME")
        void finshGameWithExit() {
            assertThat(BaseBallGame.rules.get(List.of(BaseBallGame.State.FINISH_GAME.ordinal(), BaseBallGame.Trigger.EXIT.ordinal())))
                    .isEqualTo(BaseBallGame.State.EXIT_GAME);
        }

        @Test
        @DisplayName("상태전이 규칙이 제대로 적용되었는지 확인 : FINISH_GAME --> START_GAME")
        void finshGameWithRegame() {
            assertThat(BaseBallGame.rules.get(List.of(BaseBallGame.State.FINISH_GAME.ordinal(), BaseBallGame.Trigger.RE_GAME.ordinal())))
                    .isEqualTo(BaseBallGame.State.START_GAME);
        }


    }

}
