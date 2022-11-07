package baseball.util;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class BaseBallGameTest {
    @Test
    void 랜덤값과_사용자입력값_비교_후_볼_스트라이크_갯수_반환() {
        List<Integer> computerValue = List.of(1, 2, 3);
        String userInput = "234";

        List<Integer> result = BaseBallGame.threeRandomValueCompareToUserInput(computerValue, userInput);

        assertThat(result).isEqualTo(List.of(2, 0));
    }

    @Test
    void 볼_스트라이크_프린트() {
        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        List<Integer> ballStrikeStatus = List.of(3, 0);
        BaseBallGame.printByBallAndStrikeStatus(ballStrikeStatus);

        assertThat(captor.toString().trim()).isEqualTo("3볼");
    }
}
