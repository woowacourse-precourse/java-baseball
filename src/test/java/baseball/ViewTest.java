package baseball;

import static baseball.constant.Finish.EXIT;
import static baseball.constant.Finish.RESTART;
import static baseball.constant.Finish.getFinishByCode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ViewTest {

    @Test
    void 재시작여부입력은_1혹은_2여야함() {
        // given
        String userInput1 = "1";
        String userInput2 = "2";
        String userInput3 = "3";
        String userInput4 = "12";
        String userInput5 = "0";
        String userInput6 = "01";

        assertThat(getFinishByCode(userInput1)).isEqualTo(RESTART);
        assertThat(getFinishByCode(userInput2)).isEqualTo(EXIT);
        assertException(userInput3);
        assertException(userInput4);
        assertException(userInput5);
        assertException(userInput6);
    }

    private void assertException(String userInput) {
        assertThatThrownBy(() -> getFinishByCode(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
