package baseball;

import baseball.exception.ExceptionMessage;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameUtilsTest {

    public final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("입력받은 문자열을 정수 리스트로 반환할 수 있다.")
    @Test
    void 사용자_입력() {
        System.setIn(generateUserInput("135"));
        List<Integer> input = GameUtils.getPlayerInputNum();
        assertThat(input).isEqualTo(Arrays.asList(1,3,5));
    }

    @DisplayName("중복되지 않는 세자리 정답을 랜덤으로 생성할 수 있다.")
    @Test
    void 난수_생성() {
        List<Integer> answer = GameUtils.getComputerAnswerNum();
        assertThat(answer.size()).isEqualTo(3);
        assertThat(answer.stream().distinct().count()).isEqualTo(3);
    }

    @DisplayName("두 숫자에 대한 스트라이크 개수를 반환한다.")
    @Test
    void 스트라이크_개수_반환() {
        List<Integer> answerNum1 = List.of(1, 2, 3);
        List<Integer> playerNum1 = List.of(4, 2, 3);
        int strike1 = GameUtils.checkStrikeAndUpdateScore(answerNum1, playerNum1);
        assertThat(strike1).isEqualTo(2);

        List<Integer> answerNum2 = List.of(1, 2, 3);
        List<Integer> playerNum2 = List.of(3, 4, 1);
        int strike2 = GameUtils.checkStrikeAndUpdateScore(answerNum2, playerNum2);
        assertThat(strike2).isEqualTo(0);
    }

    @DisplayName("두 숫자에 대한 볼 개수를 반환한다.")
    @Test
    void 볼_개수_반환() {
        List<Integer> answerNum1 = List.of(1, 2, 3);
        List<Integer> playerNum1 = List.of(4, 1, 5);
        int ball1 = GameUtils.checkBallAndUpdateScore(answerNum1, playerNum1);
        assertThat(ball1).isEqualTo(1);

        List<Integer> answerNum2 = List.of(1, 2, 3);
        List<Integer> playerNum2 = List.of(3, 2, 1);
        int ball2 = GameUtils.checkBallAndUpdateScore(answerNum2, playerNum2);
        assertThat(ball2).isEqualTo(2);
    }

    @DisplayName("두 숫자에 대한 숫자 야구 게임의 결과를 형식에 맞춰 출력한다.")
    @Test
    void 숫자_야구_게임_결과_출력() {
        GameUtils.printResultOfGame(3, 0);
        assertThat(output.toString()).contains("3스트라이크");

        GameUtils.printResultOfGame(2, 1);
        assertThat(output.toString()).contains("1볼 2스트라이크");

        GameUtils.printResultOfGame(0, 0);
        assertThat(output.toString()).contains("낫싱");

        GameUtils.printResultOfGame(0, 1);
        assertThat(output.toString()).contains("1볼");
    }

    @DisplayName("재시작과 종료 명령어 제외 다른 것을 입력 받았을때 예외를 던진다.")
    @Test
    void 명령어_예외() {
        System.setIn(generateUserInput("3"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, GameUtils::getCommandFromPlayer);
        assertThat(exception.getMessage()).isEqualTo(ExceptionMessage.INVALID_COMMAND_DIGIT_EXCEPTION.message());
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
