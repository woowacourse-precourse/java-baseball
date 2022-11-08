package baseball.view;

import org.junit.jupiter.api.Test;

import static baseball.view.GameHost.*;
import static org.junit.jupiter.api.Assertions.*;

class GameHostTest {

    @Test
    void 시작_문구_출력() {
        startPrint();
    }

    @Test
    void 성공_문구_출력() {
        successPrint();
    }
}