package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballGameTest {

    @Test
    void case1_입력_확인() {
        InputStream input = new ByteArrayInputStream("123".getBytes());
        System.setIn(input);
        String result = "123";
        assertThat(BaseballGame.inputNumber()).isEqualTo(result);
    }

    @Test
    void case2_재게임_여_확인() {
        String input = "1";
        boolean result = true;
        assertThat(BaseballGame.chooseYesOrNo(input)).isEqualTo(result);
    }

    @Test
    void case3_재게임_부_확인() {
        String input = "2";
        boolean result = false;
        assertThat(BaseballGame.chooseYesOrNo(input)).isEqualTo(result);
    }

    @Test
    void case4_재게임_여부_외_입력_예외_확인() {
            InputStream input = new ByteArrayInputStream("3".getBytes());
            System.setIn(input);
            assertThatThrownBy(BaseballGame::askRestartGame)
                    .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void case5_3스트라이크인_경우_확인() {
        String input = "3스트라이크";
        assertThat(BaseballGame.correctInputNumber(input)).isTrue();
    }

    @Test
    void case6_3스트라이크_아닌_경우_확인() {
        String input = "1볼";
        assertThat(BaseballGame.correctInputNumber(input)).isFalse();
    }

}
