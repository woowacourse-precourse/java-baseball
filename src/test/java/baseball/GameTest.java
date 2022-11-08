package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    private final Game game = new Game();

    @Test
    void restart_종료를_선택할때() {
        String input = "2";
        assertThat(game.restart(input)).isFalse();
    }

    @Test
    void restart_재시작을_선택할때() {
        String input = "1";
        assertThat(game.restart(input)).isTrue();
    }

    @Test
    void restart_여러개의_값을_입력할때() {
        String input = "123";
        assertThatThrownBy(() -> game.restart(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void restart_문자를_입력할때() {
        String input = "a";
        assertThatThrownBy(() -> game.restart(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getGameResult_볼이_없을때_게임_결과_반환_확인() {
        int ball = 0;
        int strike = 3;

        assertThat(game.getGameResult(ball, strike)).isEqualTo("3스트라이크");
    }

    @Test
    void getGameResult_스트라이크가_없을때_게임_결과_반환_확인() {
        int ball = 2;
        int strike = 0;

        assertThat(game.getGameResult(ball, strike)).isEqualTo("2볼 ");
    }

    @Test
    void getGameResult_스트라이크_볼_있을때_게임_결과_반환_확인() {
        int ball = 1;
        int strike = 2;

        assertThat(game.getGameResult(ball, strike)).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void isWin_졌을때_스트라이크가_목표에_달성했는지_확인() {
        int strike = 2;

        assertThat(game.isWin(strike)).isFalse();
    }

    @Test
    void isWin_이겼을때_스트라이크가_목표에_달성했는지_확인() {
        int strike = 3;

        assertThat(game.isWin(strike)).isTrue();
    }

    @Test
    void play_볼과_스트라이크의_개수를_세는지_확인1() {
        Score score = new Score();
        List<Integer> userNumber = Arrays.asList(1, 2, 3);
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);

        game.play(score, userNumber, computerNumber);

        assertThat(score.getBall()).isEqualTo(0);
        assertThat(score.getStrike()).isEqualTo(3);
    }

    @Test
    void play_볼과_스트라이크의_개수를_세는지_확인2() {
        Score score = new Score();
        List<Integer> userNumber = Arrays.asList(2, 1, 3);
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);

        game.play(score, userNumber, computerNumber);

        assertThat(score.getBall()).isEqualTo(2);
        assertThat(score.getStrike()).isEqualTo(1);
    }
}
