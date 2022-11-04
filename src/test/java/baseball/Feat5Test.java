package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class Feat5Test {

    @Test
    void 재시작_검사(){
        GameService gameService = new GameService();

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean checkRestart = gameService.checkRestart();
        assertThat(checkRestart).isFalse();
    }

    @Test
    void 종료_검사(){
        GameService gameService = new GameService();

        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean checkRestart = gameService.checkRestart();
        assertThat(checkRestart).isTrue();
    }
}
