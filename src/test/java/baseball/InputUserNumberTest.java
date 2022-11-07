package baseball;

import baseball.controller.InputUserNumber;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class InputUserNumberTest extends NsTest {

    @DisplayName("사용자 입력 숫자 개수 테스트")
    @Test
    void InputUserNumberSizeTest() {
        // given
        InputUserNumber inputUserNumber = new InputUserNumber();
        String userInput1 = "123";
        // when
        ArrayList<Integer> userNumber = inputUserNumber.InputUserNumber(userInput1);
        // then
        assertThat(userNumber.size()).isEqualTo(3);

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
