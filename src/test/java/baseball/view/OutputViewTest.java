package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class OutputViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void 게임_시작_문구_출력() {
        String gameStartMessage = "숫자 야구 게임을 시작합니다.\n";
        OutputView.printGameStartMessage();

        assertThat(output.toString()).isEqualTo(gameStartMessage);
    }

    @Test
    void 입력한_수에_대한_볼_스트라이크_개수_출력_1볼() {
        int strikeCount = 0;
        int ballCount = 1;
        String gameResultMessage = "1볼\n";
        OutputView.printGameResultMessage(strikeCount, ballCount);

        assertThat(output.toString()).isEqualTo(gameResultMessage);
    }

    @Test
    void 입력한_수에_대한_볼_스트라이크_개수_출력_2볼() {
        int strikeCount = 0;
        int ballCount = 2;
        String gameResultMessage = "2볼\n";
        OutputView.printGameResultMessage(strikeCount, ballCount);

        assertThat(output.toString()).isEqualTo(gameResultMessage);
    }

    @Test
    void 입력한_수에_대한_볼_스트라이크_개수_출력_3볼() {
        int strikeCount = 0;
        int ballCount = 3;
        String gameResultMessage = "3볼\n";
        OutputView.printGameResultMessage(strikeCount, ballCount);

        assertThat(output.toString()).isEqualTo(gameResultMessage);
    }

    @Test
    void 입력한_수에_대한_볼_스트라이크_개수_출력_1스트라이크() {
        int strikeCount = 1;
        int ballCount = 0;
        String gameResultMessage = "1스트라이크\n";
        OutputView.printGameResultMessage(strikeCount, ballCount);

        assertThat(output.toString()).isEqualTo(gameResultMessage);
    }
}
