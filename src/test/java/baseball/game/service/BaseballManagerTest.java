package baseball.game.service;

import baseball.game.constants.Exception;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BaseballManagerTest {

    @Test
    void 게임_재시작() {
        String regameValue = "1";

        boolean isRegame = BaseballManager.isRegame(regameValue);

        assertTrue(isRegame);
    }

    @Test
    void 게임_종료() {
        String regameValue = "2";

        boolean isRegame = BaseballManager.isRegame(regameValue);

        assertFalse(isRegame);
    }
    
    @Test
    void 잘못된_입력() {
        String regameValue = "가나다라";

        assertThatThrownBy(() -> BaseballManager.isRegame(regameValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}