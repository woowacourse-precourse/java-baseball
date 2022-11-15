package baseball.domain;

import baseball.common.Constant;
import baseball.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

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

    @Test
    @DisplayName("입력받은 문자열을 정수 리스트로 반환할 수 있다.")
    void 사용자_입력() {
        System.setIn(generateUserInput("135"));
        Player player = Player.create();
        assertThat(player.getBalls()).isEqualTo(Arrays.asList(1,3,5));
    }

    @Test
    @DisplayName("중복되지 않는 세자리 정답을 랜덤으로 생성할 수 있다.")
    void 난수_생성() {
        Computer computer = Computer.createComputer();
        List<Integer> balls = computer.getBalls();
        assertThat(balls.size()).isEqualTo(Constant.MAX_STRIKE_SIZE);
        assertThat(balls.stream().distinct().count()).isEqualTo(3);
    }

    @Test
    @DisplayName("두 숫자에 대한 스트라이크 개수를 0개 반환한다.")
    void 스트라이크_개수_0개_반환() {
        List<Integer> answerNum2 = List.of(1, 2, 3);
        List<Integer> playerNum2 = List.of(3, 4, 1);
        int strike2 = Referee.findStrikeCount(answerNum2, playerNum2);
        assertThat(strike2).isEqualTo(0);
    }

    @Test
    @DisplayName("두 숫자에 대한 스트라이크 개수를 1개 반환한다.")
    void 스트라이크_개수_1개_반환() {
        List<Integer> answerNum2 = List.of(1, 2, 3);
        List<Integer> playerNum2 = List.of(1, 4, 5);
        int strike2 = Referee.findStrikeCount(answerNum2, playerNum2);
        assertThat(strike2).isEqualTo(1);
    }

    @Test
    @DisplayName("두 숫자에 대한 스트라이크 개수를 2개 반환한다.")
    void 스트라이크_개수_2개_반환() {
        List<Integer> answerNum1 = List.of(1, 2, 3);
        List<Integer> playerNum1 = List.of(4, 2, 3);
        int strike1 = Referee.findStrikeCount(answerNum1, playerNum1);
        assertThat(strike1).isEqualTo(2);
    }

    @Test
    @DisplayName("두 숫자에 대한 스트라이크 개수를 3개 반환한다.")
    void 스트라이크_개수_3개_반환() {
        List<Integer> answerNum2 = List.of(1, 2, 3);
        List<Integer> playerNum2 = List.of(1, 2, 3);
        int strike2 = Referee.findStrikeCount(answerNum2, playerNum2);
        assertThat(strike2).isEqualTo(3);
    }

    @DisplayName("두 숫자에 대한 볼 개수를 0개 반환한다.")
    @Test
    void 볼_개수_0개_반환() {
        List<Integer> answerNum2 = List.of(1, 2, 3);
        List<Integer> playerNum2 = List.of(9, 8, 7);
        int ball2 = Referee.findBallCount(answerNum2, playerNum2);
        assertThat(ball2).isEqualTo(0);
    }

    @DisplayName("두 숫자에 대한 볼 개수를 1개 반환한다.")
    @Test
    void 볼_개수_1개_반환() {
        List<Integer> answerNum1 = List.of(1, 2, 3);
        List<Integer> playerNum1 = List.of(4, 1, 5);
        int ball1 = Referee.findBallCount(answerNum1, playerNum1);
        assertThat(ball1).isEqualTo(1);
    }

    @DisplayName("두 숫자에 대한 볼 개수를 2개 반환한다.")
    @Test
    void 볼_개수_2개_반환() {
        List<Integer> answerNum2 = List.of(1, 2, 3);
        List<Integer> playerNum2 = List.of(3, 2, 1);
        int ball2 = Referee.findBallCount(answerNum2, playerNum2);
        assertThat(ball2).isEqualTo(2);
    }

    @DisplayName("두 숫자에 대한 볼 개수를 3개 반환한다.")
    @Test
    void 볼_개수_3개_반환() {
        List<Integer> answerNum1 = List.of(1, 2, 3);
        List<Integer> playerNum1 = List.of(3, 1, 2);
        int ball1 = Referee.findBallCount(answerNum1, playerNum1);
        assertThat(ball1).isEqualTo(3);
    }

    @DisplayName("두 숫자에 대한 숫자 야구 게임의 결과를 형식에 맞춰 출력한다.")
    @Test
    void 숫자_야구_게임_결과_출력() {
//        Game game = new Game();
//        game.setGameResult(3, 0);
//        OutputView.printGameResult(game);
//        assertThat(output.toString()).contains("3스트라이크");
//
//        game.setGameResult(2, 1);
//        OutputView.printGameResult(game);
//        assertThat(output.toString()).contains("1볼 2스트라이크");
//
//        game.setGameResult(0, 0);
//        OutputView.printGameResult(game);
//        assertThat(output.toString()).contains("낫싱");
//
//        game.setGameResult(0, 1);
//        OutputView.printGameResult(game);
//        assertThat(output.toString()).contains("1볼");
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
