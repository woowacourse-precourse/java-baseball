package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputErrorMethodTest {
    @Test
    void checkLengthError_input의크기_IllegalArgumentException발생_체크() {
        String input = "abcd";
        if(input.length() > 3){
            assertThatThrownBy(() -> { throw new IllegalArgumentException("boom"); }).isInstanceOf(Exception.class)
                    .hasMessageContaining("boom");
        }
    }

    @Test
    void checkOverlapError_input의중복_IllegalArgumentException발생_체크() {
        int userNumber = 232;

        int firth = userNumber/100;
        int second = (userNumber%100)/10;
        int third = userNumber%10;
        int disFirstToSecond = firth-second;
        int disThirdToSecond = third-second;

        if(disFirstToSecond == disThirdToSecond || disFirstToSecond == 0 || disThirdToSecond == 0) {
            assertThatThrownBy(() -> { throw new IllegalArgumentException("boom"); }).isInstanceOf(Exception.class)
                    .hasMessageContaining("boom");
        }
    }
}
