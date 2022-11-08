package baseball.mvc.structure;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.mvc.controller.GameCommandController;
import baseball.mvc.controller.GamePlayController;
import baseball.mvc.controller.GameSettingsController;
import baseball.util.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameHandlerMappingTest {

    GameHandlerMapping handlerMapping = new GameHandlerMapping();

    @Nested
    @DisplayName("getHandler 메소드는")
    class GetHandlerMethodTest {

        @Test
        @DisplayName("만약 GameStatus.START가 주어지면 GameSettingsController를 반환한다.")
        void game_settings_controller_return_test() {
            Object handler = handlerMapping.getHandler(GameStatus.START);

            assertThat(handler).isInstanceOf(GameSettingsController.class);
        }

        @Test
        @DisplayName("만약 GameStatus.PLAY가 주어지면 GamePlayController를 반환한다.")
        void game_play_controller_return_test() {
            Object handler = handlerMapping.getHandler(GameStatus.PLAY);

            assertThat(handler).isInstanceOf(GamePlayController.class);
        }

        @Test
        @DisplayName("만약 GameStatus.END가 주어지면 GameCommandController를 반환한다.")
        void game_command_controller_return_test() {
            Object handler = handlerMapping.getHandler(GameStatus.END);

            assertThat(handler).isInstanceOf(GameCommandController.class);
        }

        @Test
        @DisplayName("만약 GameStatus.EXIT가 주어지면 null을 반환한다.")
        void null_return_test() {
            Object handler = handlerMapping.getHandler(GameStatus.EXIT);

            assertThat(handler).isNull();
        }
    }
}