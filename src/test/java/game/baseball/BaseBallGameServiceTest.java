package game.baseball;

import baseball.Application;
import baseball.game.baseball.BaseBallGameService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static baseball.game.baseball.BaseBallGameService.inputMessage;
import static baseball.game.baseball.BaseBallGameService.startMessage;

public class BaseBallGameServiceTest extends NsTest {

    private final BaseBallGameService gameService = new BaseBallGameService();

    @Test
    void input메시지_출력() {
        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        gameService.inputMessage();

        // when

        // then
        Assertions.assertThat(inputMessage).isEqualTo(out.toString());
    }

    @Test
    void start메시지_출력() {
        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        gameService.startMessage();

        // when

        // then
        Assertions.assertThat(startMessage).isEqualTo(out.toString());
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});

    }
}
