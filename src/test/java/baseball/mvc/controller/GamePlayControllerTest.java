package baseball.mvc.controller;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.game.GameComputer;
import baseball.domain.game.GameResult;
import baseball.domain.number.GameNumbers;
import baseball.factory.GameComputerFactory;
import baseball.mvc.structure.Model;
import baseball.mvc.util.GameModelKeyConst;
import baseball.util.GameStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GamePlayControllerTest {

    private final GamePlayController controller = new GamePlayController();

    @Nested
    @DisplayName("process 메소드는")
    class ProcessMethodTest {

        @Nested
        @DisplayName("만약 컴퓨터 정답, 플레이어 정답, Model이 주어진다면")
        class ProcessInnerMethodTest {

            private static final String TOO_MANY_ANSWER = "잘못된 정답 개수입니다.";

            private GameNumbers playerAnswer = new GameNumbers("123");

            @Test
            @DisplayName("플레이어가 정답을 맞췄을 경우 게임 결과를 Model에 저장하고 GameStatus.END를 반환한다.")
            void end_test() {
                GameComputer computer = GameComputerFactory.createFakeGameComputer(3L, 0L);
                Model model = new Model();

                GameStatus gameStatus = controller.process(computer, playerAnswer, model);

                Assertions.assertThat(gameStatus).isSameAs(GameStatus.END);
                Assertions.assertThat(model.getAttribute(GameModelKeyConst.GAME_RESULT_KEY, GameResult.class)).isNotNull();
            }

            @ParameterizedTest
            @CsvSource(
                value = {
                    "0:0",
                    "1:0",
                    "2:0",
                    "0:1",
                    "0:2",
                    "1:1",
                    "2:1",
                    "1:2"
                },
                delimiter = ':'
            )
            @DisplayName("플레이어 정답을 맞추지 못한 경우 게임 결과를 Model에 저장하고 GameStatus.PLAY를 반환한다.")
            void play_test(long strike, long ball) {
                GameComputer computer = GameComputerFactory.createFakeGameComputer(strike, ball);
                Model model = new Model();

                GameStatus gameStatus = controller.process(computer, playerAnswer, model);

                Assertions.assertThat(gameStatus).isSameAs(GameStatus.PLAY);
                Assertions.assertThat(model.getAttribute(GameModelKeyConst.GAME_RESULT_KEY, GameResult.class)).isNotNull();
            }

            @ParameterizedTest
            @CsvSource(
                value = {
                    "4:0",
                    "3:1",
                    "2:2",
                    "1:3",
                    "0:4"
                },
                delimiter = ':'
            )
            @DisplayName("게임 결과 중 strike와 ball의 합이 4 이상이면 IllegalArgumentException 예외가 발생한다.")
            void too_many_answer_exception_test(long strike, long ball) {
                GameComputer computer = GameComputerFactory.createFakeGameComputer(strike, ball);
                Model model = new Model();

                Assertions
                    .assertThatThrownBy(() -> controller.process(computer, playerAnswer, model))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(TOO_MANY_ANSWER);
            }
        }
    }
}