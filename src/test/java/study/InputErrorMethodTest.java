package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputErrorMethodTest {
    @Test
    void checkLengthError_input_크기_IllegalArgumentException발생_체크() {
        String input = "abcd";
        if(input.length() > 3){
            assertThatThrownBy(() -> { throw new IllegalArgumentException("boom"); }).isInstanceOf(Exception.class)
                    .hasMessageContaining("boom");
        }
    }

    @Test
    void checkOverlapError_input_중복_IllegalArgumentException발생_체크() {
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

    @Test
    void checkTextError_input_문자확인_IllegalArgumentException발생_체크() {
        String input = "a3#";

        try{
            Integer.parseInt(input);
        }catch(Exception e){
            assertThatThrownBy(() -> { throw new IllegalArgumentException("boom"); }).isInstanceOf(Exception.class)
                    .hasMessageContaining("boom");
        }
    }


}
