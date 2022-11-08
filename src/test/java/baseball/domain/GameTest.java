package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    private static ByteArrayOutputStream outputStream;

    @BeforeEach
    void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
    }

    @Test
    void 게임시작시_게임시작_문구를_출력한다() {
        // given
        Computer computer = new Computer();
        User user = new User();
        Game game = new Game(computer, user);
        String startMessage = "숫자 야구 게임을 시작합니다.";
        setInput("12345");

        // when
        try {
            game.start();
        } catch (IllegalArgumentException ex) {
        }

        // then
        String outputMessage = outputStream.toString();
        assertTrue(outputMessage.contains(startMessage));
    }

    @Test
    void 게임종료시_결과메세지를_출력한다() {
        // given
        String finishMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        Game game = new Game();

        // when
        game.finish();

        // then
        String outputMessage = outputStream.toString();
        assertTrue(outputMessage.contains(finishMessage));
    }

    @Test
    void 재시작_질문에_1을_입력하면_FALSE를_반환한다() {
        // given
        setInput("1");
        Game game = new Game(new Computer(), new User());

        // when
        boolean stop = game.isStop();

        // then
        assertFalse(stop);
    }

    @Test
    void 재시작_질문에_2를_입력하면_TRUE를_반환한다() {
        // given
        setInput("2");
        Game game = new Game(new Computer(), new User());

        // when
        boolean stop = game.isStop();

        // then
        assertTrue(stop);
    }

    private void setInput(String... inputs) {
        final byte[] buf = String.join("\n", inputs).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}
