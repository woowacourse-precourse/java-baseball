package baseball.mvc.structure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.mvc.controller.GameCommandController;
import baseball.mvc.controller.GamePlayController;
import baseball.mvc.controller.GameSettingsController;
import baseball.mvc.structure.adapter.GameCommandAdapter;
import baseball.mvc.structure.adapter.GamePlayAdapter;
import baseball.mvc.structure.adapter.GameSettingsAdapter;
import baseball.util.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameHandlerManagerTest {

    private final GameHandlerManager manager = new GameHandlerManager();
    
    @Nested
    @DisplayName("getHandlerAdapter 메소드는")
    class GetHandlerAdapterMethodClass {

        @Test
        @DisplayName("만약 GamePlayController가 주어지면 GamePlayAdapter를 반환한다.")
        void game_play_adapter_return_test() {
            Adapter adapter = manager.getHandlerAdapter(new GamePlayController());

            assertThat(adapter).isInstanceOf(GamePlayAdapter.class);
        }

        @Test
        @DisplayName("만약 GameSettingsController가 주어지면 GameSettingsAdapter를 반환한다.")
        void game_settings_adapter_return_test() {
            Adapter adapter = manager.getHandlerAdapter(new GameSettingsController());

            assertThat(adapter).isInstanceOf(GameSettingsAdapter.class);
        }

        @Test
        @DisplayName("만약 GameCommandController가 주어지면 GameCommandAdapter를 반환한다.")
        void game_command_adapter_return_test() {
            Adapter adapter = manager.getHandlerAdapter(new GameCommandController());

            assertThat(adapter).isInstanceOf(GameCommandAdapter.class);
        }

        @Test
        @DisplayName("만약 Controller가 아닌 Object가 주어지면 NullPointerException 예외가 발생한다.")
        void null_pointer_exception_test() {
            assertThatThrownBy(() -> manager.getHandlerAdapter("123"))
                    .isInstanceOf(NullPointerException.class);
        }
    }

    @Nested
    @DisplayName("getHandler 메소드는")
    class GetHandlerMethodTest {

        @Test
        @DisplayName("만약 GameStatus.START가 주어지면 GameSettingsController를 반환한다.")
        void game_settings_controller_return_test() {
            Object handler = manager.getHandler(GameStatus.START);

            assertThat(handler).isInstanceOf(GameSettingsController.class);
        }

        @Test
        @DisplayName("만약 GameStatus.PLAY가 주어지면 GamePlayController를 반환한다.")
        void game_play_controller_return_test() {
            Object handler = manager.getHandler(GameStatus.PLAY);

            assertThat(handler).isInstanceOf(GamePlayController.class);
        }

        @Test
        @DisplayName("만약 GameStatus.END가 주어지면 GameCommandController를 반환한다.")
        void game_command_controller_return_test() {
            Object handler = manager.getHandler(GameStatus.END);

            assertThat(handler).isInstanceOf(GameCommandController.class);
        }

        @Test
        @DisplayName("만약 GameStatus.EXIT가 주어지면 null을 반환한다.")
        void null_return_test() {
            Object handler = manager.getHandler(GameStatus.EXIT);

            assertThat(handler).isNull();
        }
    }

}