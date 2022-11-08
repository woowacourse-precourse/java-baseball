package baseball;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExecuteGameTest {
    @Test
    void insert_other_number_and_finish() {
        String INPUT = "3\n2\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(INPUT.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        ExecuteGame executeGame = new ExecuteGame();

        boolean result = executeGame.canRepeatGame();
        String output = outputStream.toString();
        assertThat(output).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n" +
                "1 또는 2를 입력해주세요\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." +
                "\n");
        assertThat(result).isFalse();
    }

    @Test
    void insert_other_number_and_repeat() {
        String INPUT = "3\n1\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(INPUT.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        ExecuteGame executeGame = new ExecuteGame();

        boolean result = executeGame.canRepeatGame();
        String output = outputStream.toString();
        assertThat(output).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n" +
                "1 또는 2를 입력해주세요\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." +
                "\n");
        assertThat(result).isTrue();
    }

    @Test
    void finish_game() {
        String FINISH_GAME = "2";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(FINISH_GAME.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        ExecuteGame executeGame = new ExecuteGame();
        boolean result = executeGame.canRepeatGame();
        String output = outputStream.toString();
        assertThat(output).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        assertThat(result).isFalse();
    }

    @Test
    void repeat_game() {
        String REPEAT_VALUE = "1";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(REPEAT_VALUE.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);

        ExecuteGame executeGame = new ExecuteGame();
        boolean result = executeGame.canRepeatGame();
        String output = outputStream.toString();
        assertThat(output).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        assertThat(result).isTrue();
    }
}

