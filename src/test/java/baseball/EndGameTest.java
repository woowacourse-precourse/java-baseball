package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EndGameTest {
    @Test
    @DisplayName("예외: 게임 재실행(1) 혹은 종료(2)가 아닌 다른 문자 입력한 경우")
    void case1() {
        String action = "4";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> EndGame.validateAction(action))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
