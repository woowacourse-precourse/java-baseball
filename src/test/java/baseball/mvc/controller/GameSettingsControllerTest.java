package baseball.mvc.controller;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.game.GameComputer;
import baseball.mvc.model.Model;
import baseball.mvc.structure.consts.GameModelKeyConst;
import baseball.util.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameSettingsControllerTest {

    private final GameSettingsController controller = new GameSettingsController();

    @Nested
    @DisplayName("process 메소드는")
    class ProcessMethodTest {

        @Test
        @DisplayName("만약 Model이 주어진다면 Model에 computer라는 key로 컴퓨터 정답을 생성해 저장하고 GameStatus.PLAY를 반환한다.")
        void success_test() {
            Model model = new Model();

            GameStatus gameStatus = controller.process(model);

            assertThat(gameStatus).isSameAs(GameStatus.PLAY);
            assertThat(model.getAttribute(GameModelKeyConst.COMPUTER_KEY, GameComputer.class))
                    .isNotNull();
        }
    }
}