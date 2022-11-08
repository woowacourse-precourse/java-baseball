package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void Game_랜덤으로_숫자생성() {
        Game game1 = new Game();
        Game game2 = new Game();

        assertThat(game1.computer).isNotEqualTo(game2.computer);
    }

    @Test
    void getStrike_스트라이크_갯수() {
        Game game = new Game();
        game.computer = List.of(1, 2, 3);
        List<Integer> player1 = List.of(1, 2, 3);
        List<Integer> player2 = List.of(1, 4, 3);
        List<Integer> player3 = List.of(3, 2, 1);

        assertThat(game.getStrike(game.computer, player1)).isEqualTo(3);
        assertThat(game.getStrike(game.computer, player2)).isEqualTo(2);
        assertThat(game.getStrike(game.computer, player3)).isEqualTo(1);

    }

    @Test
    void getBall_볼_갯수() {
        Game game = new Game();
        game.computer = List.of(1, 2, 3);
        List<Integer> player1 = List.of(1, 2, 3);
        List<Integer> player2 = List.of(3, 2, 1);
        List<Integer> player3 = List.of(3, 1, 2);

        assertThat(game.getBall(game.computer, player1)).isEqualTo(0);
        assertThat(game.getBall(game.computer, player2)).isEqualTo(2);
        assertThat(game.getBall(game.computer, player3)).isEqualTo(3);
    }

    @Test
    void printResult_결과반환() {
        Game game = new Game();
        OutputStream out = new ByteArrayOutputStream();

        System.setOut(new PrintStream(out));
        game.printResult(1, 2);
        assertThat("1볼 2스트라이크" + "\n").isEqualTo(out.toString());


        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        game.printResult(0, 3);
        assertThat("3스트라이크" + "\n").isEqualTo(out.toString());

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        game.printResult(0, 0);
        assertThat("낫싱" + "\n").isEqualTo(out.toString());
    }

    @Test
    void isEnd_인풋으로_끝났는지판단() {
        Game game = new Game();
        game.computer = List.of(1, 2, 3);

        assertThat(game.isEnd("123")).isEqualTo(true);
        assertThat(game.isEnd("2")).isEqualTo(false);
        assertThat(game.isEnd("asfa")).isEqualTo(false);
        assertThat(game.isEnd("")).isEqualTo(false);
        assertThat(game.isEnd(".")).isEqualTo(false);
    }
}

