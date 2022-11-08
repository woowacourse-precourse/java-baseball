package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.ball.Balls;
import baseball.domain.result.PlayResult;
import baseball.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    public void 결과_화면_출력_2볼_1스트라이크_검증() {
        Balls com = Balls.of(List.of(1, 2, 3));
        Balls player = Balls.of(List.of(1, 3, 2));
        PlayResult result = player.play(com);
        OutputView.printResult(result);

        String expected = "2볼 1스트라이크\r\n";
        assertEquals(output.toString().trim(), expected.trim());

    }

    @Test
    public void 결과_화면_출력_3스트라이크_검증() {
        Balls com = Balls.of(List.of(1, 2, 3));
        Balls player = Balls.of(List.of(1, 2, 3));
        PlayResult result = player.play(com);
        OutputView.printResult(result);

        String expected = "3스트라이크 " + "\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + "\r\n";
        assertEquals(expected, output.toString());
    }

    @Test
    public void 결과_화면_출력_낫싱_검증() {
        Balls com = Balls.of(List.of(1, 2, 3));
        Balls player = Balls.of(List.of(4, 5, 6));
        PlayResult result = player.play(com);
        OutputView.printResult(result);

        String expected = "낫싱\r\n";
        assertEquals(output.toString(), expected);
    }

    @Test
    public void 게임_시작_화면_출력_검증() {
        OutputView.printStartMessage();
        String expected = "숫자 야구 게임을 시작합니다.\r\n";

        assertEquals(expected, output.toString());
    }
}
