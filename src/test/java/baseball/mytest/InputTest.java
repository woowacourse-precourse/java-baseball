package baseball.mytest;

import baseball.UserNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    void 문자열_변환_테스트() {
        String input = "123";
        UserNumber userNumber = new UserNumber(input);

        Assertions.assertThat(userNumber.getUserNums().size()).isEqualTo(3);
    }
}
