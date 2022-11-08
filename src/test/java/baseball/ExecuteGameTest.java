package baseball;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExecuteGameTest {
    @Test
    void repeatTest() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("3".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        ExecuteGame executeGame = new ExecuteGame(inputStream, ps);
        executeGame.canRepeatGame();
        String output = outputStream.toString();
        System.out.println(output);
//        assertThat(output).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n" +
//                "1 또는 2를 입력하세요.\n");
    }

    @Test
    void repeatTest2() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        ExecuteGame executeGame = new ExecuteGame(inputStream, ps);
        executeGame.canRepeatGame();
        String output = outputStream.toString();
        assertThat(executeGame.canRepeatGame()).isFalse();
    }

    @Test
    void repeatTest3() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);
        ExecuteGame executeGame = new ExecuteGame(inputStream, ps);
        executeGame.canRepeatGame();
        System.out.println(executeGame.canRepeatGame());
        assertThat(executeGame.canRepeatGame()).isTrue();
    }
}

