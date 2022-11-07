package baseball;

import baseball.service.GameService;
import baseball.util.GameMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ServiceTest extends NsTest {
    private static GameService gameService;

    @BeforeAll
    public static void beforeAll(){
        gameService = new GameService();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void 시작_메시지_테스트(){
        String input = GameMessage.START_MASSAGE.getMassage();
        OutputStream out = checkMessage(input);
        gameService.sendMassage(GameMessage.START_MASSAGE);
        assertThat(input).isEqualTo(out.toString());
    }

    @Test
    public void 시작_메시지_예외_테스트(){
        String input = GameMessage.START_MASSAGE.getMassage() + "exception";
        OutputStream out = checkMessage(input);
        gameService.sendMassage(GameMessage.START_MASSAGE);
        Assertions.assertThrows(org.opentest4j.AssertionFailedError.class, ()->{
            assertThat(input).isEqualTo(out.toString());
        });
    }


    private OutputStream checkMessage(String input){
        input = GameMessage.START_MASSAGE.getMassage();
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        return out;
    }
}
