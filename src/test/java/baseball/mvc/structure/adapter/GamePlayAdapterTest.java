package baseball.mvc.structure.adapter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.game.GameComputer;
import baseball.domain.game.GameResult;
import baseball.helper.factory.GameComputerFactory;
import baseball.mvc.controller.GamePlayController;
import baseball.mvc.controller.GameSettingsController;
import baseball.mvc.structure.ModelAndView;
import baseball.mvc.model.Request;
import baseball.mvc.structure.consts.GameModelKeyConst;
import baseball.mvc.structure.consts.GameRequestKeyConst;
import baseball.util.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GamePlayAdapterTest {

    private final GamePlayController controller = new GamePlayController();
    private final GamePlayAdapter adapter = new GamePlayAdapter();

    @Nested
    @DisplayName("supports 메소드는")
    class SupportsMethodTest {

        @Test
        @DisplayName("만약 주어진 Object의 타입이 GamePlayController이라면 true를 반환한다.")
        void true_test() {
            assertThat(adapter.supports(controller)).isTrue();
        }

        @Test
        @DisplayName("만약 주어진 Object의 타입이 GamePlayController가 아니라면 false를 반환한다.")
        void false_test() {
            assertThat(adapter.supports(new GameSettingsController())).isFalse();
        }
    }

    @Nested
    @DisplayName("handle 메소드는")
    class HandleMethodTest {

        private Request request;

        @BeforeEach
        void beforeEach() {
            request = new Request();
        }

        @Nested
        @DisplayName("만약 handler와 컴퓨터 정답, 플레이어 정답이 저장된 request가 주어졌을 때")
        class HandlerMethodSuccessInnerTest {

            @Test
            @DisplayName("플레이어 정답이 유효하면서 3스트라이크가 아니라면 게임 결과와 GameStatus.PLAY를 반환한다.")
            void game_status_play_test() {
                request.addAttribute(GameRequestKeyConst.COMPUTER_KEY,
                        GameComputerFactory.createStubGameComputer(1L, 1L));
                request.addAttribute(GameRequestKeyConst.PLAYER_INPUT_KEY, "123");

                ModelAndView modelAndView = adapter.handle(controller, request);

                assertThat(modelAndView.getGameStatus()).isSameAs(GameStatus.PLAY);
                assertThat(modelAndView
                        .getModelAttribute(GameModelKeyConst.GAME_RESULT_KEY, GameResult.class))
                                .isNotNull();
            }

            @Test
            @DisplayName("플레이어 정답이 유효하면서 3스트라이크라면 게임 결과와 GameStatus.END를 반환한다.")
            void game_status_end_test() {
                request.addAttribute(GameRequestKeyConst.COMPUTER_KEY,
                        GameComputerFactory.createStubGameComputer(3L, 0L));
                request.addAttribute(GameRequestKeyConst.PLAYER_INPUT_KEY, "123");

                ModelAndView modelAndView = adapter.handle(controller, request);

                assertThat(modelAndView.getGameStatus()).isSameAs(GameStatus.END);
                assertThat(modelAndView
                        .getModelAttribute(GameModelKeyConst.GAME_RESULT_KEY, GameResult.class))
                                .isNotNull();
            }

            @ParameterizedTest
            @ValueSource(
                    strings = {
                        "1",
                        "012",
                        "1234",
                        "a12",
                        "1 3",
                        "a",
                        "12@"
                    }
            )
            @DisplayName("플레이어 정답이 유효하지 않다면 IllegalArgumentException 예외가 발생한다.")
            void illegal_argument_exception_test(String wrongPlayerInput) {
                request.addAttribute(GameRequestKeyConst.COMPUTER_KEY, new GameComputer());
                request.addAttribute(GameRequestKeyConst.PLAYER_INPUT_KEY, wrongPlayerInput);

                assertThatThrownBy(() -> adapter.handle(controller, request))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("만약 handler와 requset가 주어졌을 때")
        class HandlerMethodExceptionInnerTest {

            @Test
            @DisplayName("request에 플레이어 입력 값이 없다면 NullPointerException 예외가 발생한다.")
            void null_pointer_exception_without_player_input_test() {
                request.addAttribute(GameRequestKeyConst.PLAYER_INPUT_KEY, "123");

                assertThatThrownBy(() -> adapter.handle(controller, request))
                        .isInstanceOf(NullPointerException.class);
            }

            @Test
            @DisplayName("request에 GameComputer 값이 없다면 NullPointerException 예외가 발생한다.")
            void null_pointer_exception_without_game_computer_test() {
                request.addAttribute(GameRequestKeyConst.COMPUTER_KEY, new GameComputer());

                assertThatThrownBy(() -> adapter.handle(controller, request))
                        .isInstanceOf(NullPointerException.class);
            }
        }
    }
}