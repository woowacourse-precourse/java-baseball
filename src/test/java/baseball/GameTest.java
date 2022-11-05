package baseball;

import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.OutputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @DisplayName("컴퓨터의 랜덤 숫자얻기")
    @Test
    void getComputerNumber() {
        Game game = new Game();

        assertThat(game.getComputerNumber()).doesNotContain(0).hasSize(3).doesNotHaveDuplicates();
    }

    @DisplayName("플레이어의 중복된 숫자이면 예외")
    @Test
    void isPlayerNumberDuplicate() {
        Game game = new Game();
        System.setIn(new ByteArrayInputStream("133".getBytes()));

        assertThatThrownBy(() -> game.getPlayerNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 3자리가 아닌 숫자이면 예외")
    @Test
    void isPlayerNumberThreeDigits() {
        Game game = new Game();
        System.setIn(new ByteArrayInputStream("1234".getBytes()));

        assertThatThrownBy(() -> game.getPlayerNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 숫자 체크")
    @Test
    void checkPlayerNumber() {
        Game game = new Game();
        game.computerNumber = List.of(4, 5, 7);
        game.playerNumber = List.of(4, 7, 5);
        int[] result = game.checkNumber(game.playerNumber);

        assertThat(result).isEqualTo(new int[]{2, 1});
    }

    @DisplayName("체크결과 볼스트라이크 출력")
    @Test
    void printResult1() {
        Game game = new Game();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        game.printResult(new int[]{2, 1});

        assertThat(out.toString()).isEqualTo("2볼 1스트라이크\r\n");
    }

    @DisplayName("체크결과 낫싱 출력")
    @Test
    void printResult2() {
        Game game = new Game();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        game.printResult(new int[]{0, 0});

        assertThat(out.toString()).isEqualTo("낫싱\r\n");
    }

    @DisplayName("체크결과 3스트라이크 게임종료 출력")
    @Test
    void printResult3() {
        Game game = new Game();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        game.printResult(new int[]{0, 3});

        assertThat(out.toString()).isEqualTo("3스트라이크\r\n" + game.WIN_NOTICE+"\r\n");
    }

    @DisplayName("게임 재시작/프로그램 종료 입력값 확인")
    @Test
    void checkRestartOrEnd() {
        Game game = new Game();
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        assertThat(game.getRestartOrEndNumber()).isEqualTo(1);
    }

    @DisplayName("게임 재시작/프로그램 종료 입력값 예외확인")
    @Test
    void checkRestartOrEndException() {
        Game game = new Game();
        System.setIn(new ByteArrayInputStream("3".getBytes()));

        assertThatThrownBy(() -> game.getRestartOrEndNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
