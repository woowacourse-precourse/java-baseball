package baseball.mvc.structure.adapter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.mvc.controller.GameCommandController;
import baseball.mvc.controller.GamePlayController;
import baseball.mvc.structure.ModelAndView;
import baseball.mvc.model.Request;
import baseball.mvc.structure.consts.GameRequestKeyConst;
import baseball.util.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandAdapterTest {

    private final GameCommandController controller = new GameCommandController();
    private final GameCommandAdapter adapter = new GameCommandAdapter();

    @Nested
    @DisplayName("supports 메소드는")
    class SupportsMethodTest {

        @Test
        @DisplayName("만약 주어진 Object의 타입이 GameCommandController이라면 true를 반환한다.")
        void true_test() {
            assertThat(adapter.supports(controller)).isTrue();
        }

        @Test
        @DisplayName("만약 주어진 Object의 타입이 GameCommandController가 아니라면 false를 반환한다.")
        void false_test() {
            assertThat(adapter.supports(new GamePlayController())).isFalse();
        }
    }

    @Nested
    @DisplayName("handle 메소드는")
    class HandleMethodTest {

        private final static String RESTART_INPUT = "1";
        private final static String EXIT_INPUT = "2";

        private final static String WRONG_INPUT = "잘못된 입력입니다.";

        private Request request;

        @BeforeEach
        void beforeEach() {
            request = new Request();
        }

        @Test
        @DisplayName("만약 handler와 플레이어 입력 1이 저장된 request가 주어지면 GameStatus.START를 ModelAndView에 저장해 반환한다.")
        void game_status_start_test() {
            request.addAttribute(GameRequestKeyConst.PLAYER_INPUT_KEY, RESTART_INPUT);

            ModelAndView modelAndView = adapter.handle(controller, request);

            assertThat(modelAndView.getGameStatus()).isSameAs(GameStatus.START);
        }

        @Test
        @DisplayName("만약 handler와 플레이어 입력 2가 저장된 request가 주어지면 GameStatus.EXIT를 ModelAndView에 저장해 반환한다.")
        void game_status_end_test() {
            request.addAttribute(GameRequestKeyConst.PLAYER_INPUT_KEY, EXIT_INPUT);

            ModelAndView modelAndView = adapter.handle(controller, request);

            assertThat(modelAndView.getGameStatus()).isSameAs(GameStatus.EXIT);
        }

        @ParameterizedTest
        @ValueSource(
                strings = {
                    "a",
                    "+",
                    "0",
                    "3",
                    "@"
                }
        )
        @DisplayName("만약 handler와 유효하지 않은 플레이어 입력이 저장된 request가 주어지면 IllegalArgumentException 예외가 발생한다.")
        void wrong_input_illegal_argument_exception_test(String playerInput) {
            request.addAttribute(GameRequestKeyConst.PLAYER_INPUT_KEY, playerInput);

            assertThatThrownBy(() -> adapter.handle(controller, request))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(WRONG_INPUT);
        }
    }
}