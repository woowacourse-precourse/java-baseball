package study;

import baseball.Computer;
import baseball.PlayerNum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

public class InputTest {
    private static PlayerNum playerNumber;
    private static Computer computer;
    private static final String gameMsg = "숫자를 입력해주세요 : ";
    private static final String gameEndMsg = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    @BeforeAll
    static void initAll() {
        playerNumber = new PlayerNum();
        computer = new Computer();
    }

    @Test
    void 플레이어_입력과_출력이_정상작동하는지_검증() {
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        playerNumber.createNumber();
        Assertions.assertThat(gameMsg).isEqualTo(out.toString());
    }
/*
    @Test
    void 게임종료시_입력이_정상작동하는지_검증() {
        String input = "1";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        computer.terminateGame();
        Assertions.assertThat(gameEndMsg).isEqualTo(out.toString());
    }
*/


}
