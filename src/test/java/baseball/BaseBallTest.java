package baseball;

import domain.Computer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class BaseBallTest {


    @Test
    void 게임_종료_여부_확인() {
        BaseBall baseBall = new BaseBall();
        baseBall.playGame();
    }
}
