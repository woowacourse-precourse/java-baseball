package baseball.mvc.structure.adapter;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.game.GameComputer;
import baseball.mvc.controller.GamePlayController;
import baseball.mvc.controller.GameSettingsController;
import baseball.mvc.structure.ModelAndView;
import baseball.mvc.model.Request;
import baseball.mvc.structure.consts.GameModelKeyConst;
import baseball.util.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameSettingsAdapterTest {

    private final GameSettingsController controller = new GameSettingsController();
    private final GameSettingsAdapter adapter = new GameSettingsAdapter();

    @Nested
    @DisplayName("supports 메소드는")
    class SupportsMethodTest {

        @Test
        @DisplayName("만약 주어진 Object의 타입이 GameSettingsController이라면 true를 반환한다.")
        void true_test() {
            assertThat(adapter.supports(controller)).isTrue();
        }

        @Test
        @DisplayName("만약 주어진 Object의 타입이 GameSettingsController가 아니라면 false를 반환한다.")
        void false_test() {
            assertThat(adapter.supports(new GamePlayController())).isFalse();
        }
    }

    @Nested
    @DisplayName("handle 메소드는")
    class HandleMethodTest {

        @Test
        @DisplayName("만약 handler와 request가 주어지면 컴퓨터 정답과 GameStatus.PLAY를 ModelAndView에 저장해 반환한다.")
        void success_test() {
            Request request = new Request();

            ModelAndView modelAndView = adapter.handle(controller, request);

            assertThat(modelAndView.getGameStatus()).isSameAs(GameStatus.PLAY);
            assertThat(modelAndView.getModelAttribute(GameModelKeyConst.COMPUTER_KEY, GameComputer.class))
                    .isNotNull();
        }
    }
}