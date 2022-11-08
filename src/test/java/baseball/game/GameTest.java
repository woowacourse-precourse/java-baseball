package baseball.game;

import baseball.controller.RandomInRange;
import baseball.view.InputView;
import baseball.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    RandomInRange random;

    @BeforeEach
    void 기본_세팅() {
        random = new RandomInRange() {
            private int value = 1;

            @Override
            public int pickRandomInRange(int startInclusive, int endInclusive) {
                return value++;
            }
        };
    }

    @DisplayName("게임이 잘 작동함")
    @Test
    void 잘_작동() {
        InputView inputView = new InputView() {
            private int returnValue = 0;
            private String[] inputMock = {"132", "123"};

            @Override
            public String readLine() {
                return inputMock[returnValue++];
            }
        };
        OutputView outputView = new OutputView() {
            private final String[] message = {"숫자를 입력해주세요 : ",
                    "2볼 ",
                    "1스트라이크",
                    "\n",
                    "숫자를 입력해주세요 : ",
                    "3스트라이크",
                    "\n",
                    "3개의 숫자를 모두 맞히셨습니다 !게임 종료\n"};
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
        Game game = new BaseballGame(inputView, outputView);
        game.play(random);
    }
}
