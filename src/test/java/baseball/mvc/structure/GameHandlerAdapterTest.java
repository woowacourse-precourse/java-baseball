package baseball.mvc.structure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.mvc.controller.GameCommandController;
import baseball.mvc.controller.GamePlayController;
import baseball.mvc.controller.GameSettingsController;
import baseball.mvc.structure.adapter.GameCommandAdapter;
import baseball.mvc.structure.adapter.GamePlayAdapter;
import baseball.mvc.structure.adapter.GameSettingsAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameHandlerAdapterTest {

    private final GameHandlerAdapter handlerAdapter = new GameHandlerAdapter();

    @Nested
    @DisplayName("getHandlerAdapter 메소드는")
    class GetHandlerAdapterMethodTest {

        @Test
        @DisplayName("만약 GamePlayController가 주어지면 GamePlayAdapter를 반환한다.")
        void game_play_adapter_return_test() {
            Adapter adapter = handlerAdapter.getHandlerAdapter(new GamePlayController());

            assertThat(adapter).isInstanceOf(GamePlayAdapter.class);
        }

        @Test
        @DisplayName("만약 GameSettingsController가 주어지면 GameSettingsAdapter를 반환한다.")
        void game_settings_adapter_return_test() {
            Adapter adapter = handlerAdapter.getHandlerAdapter(new GameSettingsController());

            assertThat(adapter).isInstanceOf(GameSettingsAdapter.class);
        }

        @Test
        @DisplayName("만약 GameCommandController가 주어지면 GameCommandAdapter를 반환한다.")
        void game_command_adapter_return_test() {
            Adapter adapter = handlerAdapter.getHandlerAdapter(new GameCommandController());

            assertThat(adapter).isInstanceOf(GameCommandAdapter.class);
        }

        @Test
        @DisplayName("만약 Controller가 아닌 Object가 주어지면 NullPointerException 예외가 발생한다.")
        void null_pointer_exception_test() {
            assertThatThrownBy(() -> handlerAdapter.getHandlerAdapter("123"))
                    .isInstanceOf(NullPointerException.class);
        }
    }
}