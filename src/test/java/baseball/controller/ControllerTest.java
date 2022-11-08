package baseball.controller;

import baseball.game.Game;
import baseball.view.InputView;
import baseball.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ControllerTest {
    private Game game = mock(Game.class);

    @DisplayName("컨트롤러가 잘 작동한다")
    @Test
    void 작동_체크() {
        InputView inputView = new InputView() {
            private int returnValue = 1;

            @Override
            public String readLine() {
                return Integer.toString(returnValue++);
            }
        };
        OutputView outputView = new OutputView() {
            private final String[] message = {"숫자 야구 게임을 시작합니다.\n",
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n",
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"};
            private int messagePos = 0;

            @Override
            public void print(String content) {
                assertThat(message[messagePos]).isEqualTo(content);
                messagePos++;
            }

            @Override
            public void printError(String content) {

            }
        };
        Controller controller = Controller.createWithViews(inputView, outputView);
        controller.runGame(game);
        verify(game, times(2)).play(any());
    }

    @DisplayName("컨트롤러가 예외를 처리한다")
    @Test
    void 예외_체크() {
        InputView inputView = () -> "0";
        OutputView outputView = new OutputView() {
            private final String[] message = {"숫자 야구 게임을 시작합니다.\n",
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"};
            private int messagePos = 0;

            @Override
            public void print(String content) {
                assertThat(message[messagePos]).isEqualTo(content);
                messagePos++;
            }

            @Override
            public void printError(String content) {
                if (content != null) {

                }
            }
        };
        Controller controller = Controller.createWithViews(inputView, outputView);
        try {
            controller.runGame(game);
        } catch (Exception expected) {
            assertThat(expected.getMessage()).isEqualTo("1이나 2가 아닌 값이 입력되었습니다");
        }
        verify(game, times(1)).play(any());
    }
}
