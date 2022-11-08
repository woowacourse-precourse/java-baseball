package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    @Test
    void case1_재게임_여_확인() {
        String input = "1";
        boolean result = true;
        assertThat(BaseballGame.chooseYesOrNo(input)).isEqualTo(result);
    }

    @Test
    void case2_재게임_부_확인() {
        String input = "2";
        boolean result = false;
        assertThat(BaseballGame.chooseYesOrNo(input)).isEqualTo(result);
    }

}
