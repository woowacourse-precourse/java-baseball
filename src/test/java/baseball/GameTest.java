package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import baseball.utility.Utility;
import camp.nextstep.edu.missionutils.test.NsTest;

public class GameTest extends NsTest {
    @Test
    void 기능5_게임_시작_메시지_출력() {
        assertEquals(Utility.START_MESSAGE, "숫자 야구 게임을 시작합니다.");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
    
}
